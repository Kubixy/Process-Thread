#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>

void main()
{
	pid_t pid;

	if ((pid = fork()) == 0)
	{
		printf("I'm the child (%d, child of %d)\n",getpid(),getppid());
	}
	else 
	{
		printf("I'm the parent (%d, child of %d)\n",getpid(),getppid());
	}
}
