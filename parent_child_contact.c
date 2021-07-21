#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>

void main()
{
    pid_t pid;
    int fd[2];
    char buffer[30];
    pipe(fd);

    switch (pid = fork()) {
        case -1: printf("Unable to create a child");
                 exit(-1);
                 break;
        
        case 0:  write(fd[1],"Hello father",10);
                 break;
        
        default: wait(NULL);
                 read(fd[0],buffer,10);
                 printf("Message --> %s\n", buffer);
                 break;
    } 
}