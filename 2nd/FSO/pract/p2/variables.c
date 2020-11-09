#include <stdio.h>
int x=2;
void m();
void main(){
 int x=3;
 m();
 printf("%d", x);
}
void m(){
 x = 4;
} 
