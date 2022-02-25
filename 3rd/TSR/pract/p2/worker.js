const { socket } = require('zeromq');

const [_, __, backendUrl, identity, answer] = process.argv;

const rep = socket('rep')
  .connect(backendUrl)
  .on('message', (client, sep, tasksProcessed) => {
    console.log(
      client.toString(), 
      tasksProcessed.toString()
    );
    setTimeout(() => {
      rep.send([identity, '', client, '', answer + ' ' + tasksProcessed]);
    }, 1000)
  });
  
rep.identity = identity;
rep.send([identity, '', '']);