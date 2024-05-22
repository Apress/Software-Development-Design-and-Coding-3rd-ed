/*
 * testing error handling using errno
 */
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <errno.h>

int main(int argc, char **argv) {
	double x = 0;
	double y = -1;
	errno = 0;

	x = sqrt(y);
	if (errno) {
		perror("sqrt Failed");
		exit(1);
	}
	printf("sqrt -1 is %f\n", x);
	return 0;
}
