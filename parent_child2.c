#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>

void main()
{
    pid_t pid1, pid2;
    int s1, s2;

    if ((pid1 = fork()) == 0)
    {
        printf("I'm the first child (%d, child of %d)\n", getpid(), getppid());
    }
    else
    {
        if ((pid2 = fork()) == 0)
        {
            printf("I'm the second child (%d, child of %d)\n", getpid(), getppid());
        }
        else
        {
            waitpid(pid1, &s1, 0);
            waitpid(pid2, &s2, 0);
            printf("I'm the parent (%d, child of %d)\n", getpid(), getppid());
        }
    }
}
