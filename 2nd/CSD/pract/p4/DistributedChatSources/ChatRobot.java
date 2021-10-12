// This file must be implemented when completing activity 2
//

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;

//
// ChatRobot implementation
//
public class ChatRobot implements MessageListener {
   private ChatConfiguration conf;
   private IChatServer srv = null;
   private IChatUser myUser = null; 
   private String channelToJoin = null;
   private IChatChannel ch = null;
   public static void main(String[] args) {
      try {
         new ChatRobot(args[1]).doConnect(args[0], "Robot");
      } catch (Exception e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      } 
   }

   public ChatRobot(String channelToJoin) {
      this.channelToJoin = channelToJoin;
      // this.conf = conf;
   }

   public void doConnect(String serverName, String nick) throws Exception {
      try {
         Registry nsServer = LocateRegistry.getRegistry("localhost", 9000);
         srv = (IChatServer) nsServer.lookup(serverName);
      } catch (java.rmi.ConnectException e) {
         throw new Exception("rmiregistry not found at '");
      } catch (java.rmi.NotBoundException e) {
         throw new Exception("Server '" + serverName + "' not found.");
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println(e.getMessage());
      }
      
      myUser = new ChatUser(nick, this);

      try {
         srv.connectUser(myUser);
      } catch (RemoteException re) {
         re.printStackTrace();
         System.out.println(re.getMessage());
      }

      IChatChannel[] channels = srv.listChannels();

      if (channels == null || channels.length == 0)
         throw new Exception("Server has no channels");

      // String list[] = new String[channels.length];
      for (int i = 0; i < channels.length; i++) {
         if(channels[i].getName().equals(channelToJoin)) {
            ch = channels[i];
            break;
         }
      }

      ch.join(myUser);
   }

   public void messageArrived(IChatMessage msg) {
      try {
         String message = msg.getText();

         if (message.startsWith(ChatChannel.JOIN)) {
            String nick = message.substring(ChatChannel.JOIN.length() + 1);
            doSendChannelMessage(ch.getName(), "Hola " + nick);
         }
      } catch (RemoteException re) {
         System.out.println(re.getMessage());
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      
   }

   public void doSendChannelMessage(String dst, String msg) throws Exception {
      try {
         IChatChannel c_dst = srv.getChannel(dst);
         IChatMessage c_msg = new ChatMessage(myUser, c_dst, msg);

         c_dst.sendMessage(c_msg);
      } catch (Exception e) {
         throw new Exception("Cannot send message: " + e);
      }
   }

}
