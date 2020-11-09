
#include <stdio.h>
#include <string.h>

#define InitBalance 1000
float Balance;

void askIfWantsToSeeBalance(float balance);

int main()
{ int operation;
  float income, withdraw;
  
  
  while (operation != 6) {
      
      printf("\nWelcome to the FSO ATM\n");
      Balance=InitBalance;
      operation=0;
      printf("\nIndicate operation to do:\n");
      printf(" 1.Cash Income\n 2.Cash Withdrawal\n 3.Balance Enquiry\n");
      printf(" 4.Account Activity\n 5.Change PIN\n 6.Exit\n\n");
      printf(" Operation:");
      scanf("%d",&operation); 
  
      switch(operation){
          case 1:
              printf(" Cash Income\n");
              printf("\n Enter the amount to deposit:");   
              scanf("%f",&income);
              Balance=Balance+income;  
              printf(" Successful income\n");
              break;
              
          case 2: 
              printf(" Cash Withdrawal\n");
              printf("\n Enter the amount to withdraw:");
              scanf("%f",&income);
              
              if(Balance>income){
                  Balance=Balance-income;
              }else{
                  printf(" Operation does not allowed\n");
                  printf("   Not enough cash\n");
              }
              break;
              
          case 3:
              printf(" Balance Enquiry\n");
              break;
              
          case 4:
          case 5:
              printf(" This operation is not implemented");
              break;
              
          case 6:
              printf(" EXIT\n"); 
              break;
              
          default: 
              printf(" ERROR: This opertaion does not applied\n");
              break;
              
      }
      
      
  }
  
  askIfWantsToSeeBalance(Balance);
  printf("\n\n Thanks \n\n");
  
  
  
  return(0);
  

}

void askIfWantsToSeeBalance(float balance)
{
    char* response;
    printf("\nDo you want to see your  current balance? [Yes/No]\n ");
    scanf("%s", response);
    
    if(strcmp(response, "Yes") == 0)
        printf("\n\n Current Balance: %.2f Euros", balance);
    else if(strcmp(response, "No") == 0)
        printf("\n\n I have spent my money in food too, don't feel bad about that bro");
    else 
        printf("\n\n WTF dude, you're weird");
        
    
}
