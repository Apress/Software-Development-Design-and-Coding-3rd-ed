/*
 * Testing error handling on file open
 */
 
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
	FILE *fd;
	char *fname = "NotAFile.txt";

	if ((fd = fopen(fname, "r")) == NULL) {
		perror("File not opened");
		exit(1);
	}
	printf("File exists\n");
	return 0;
}
