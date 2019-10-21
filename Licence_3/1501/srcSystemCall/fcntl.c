#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
int main(){
  char c;
  fcntl(0, F_SETFD,  O_NONBLOCK);
  read(0,&c,1);
  printf("fin \n");
}
