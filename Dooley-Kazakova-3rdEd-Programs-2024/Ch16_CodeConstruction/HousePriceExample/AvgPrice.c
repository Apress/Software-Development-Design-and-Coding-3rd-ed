/*
 * program to compute the average selling price of 
 * a set of homes.
 * Input comes from a file that is passed via the
 * command line.
 * Output is the Total and Average sale prices for
 * all the homes and the number of prices in the file.
 *
 * jfd 10/01/2010
 */
#include <stdlib.h>
#include <stdio.h>

int main(int argc, char **argv) {
	FILE *fp;
	double totalPrice, avgPrice;
	double price;
	int numPrices;
	
	/* check that the user entered the correct number of args */
	if (argc < 2) {
		fprintf(stderr,"Usage: %s <filename>\n", argv[0]);
		exit(1);
	}

	/* try to open the input file */
	fp = fopen(argv[1], "r");
	if (fp == NULL) {
		fprintf(stderr, "File Not Found: %s\n", argv[1]);
		exit(1);
	}

	totalPrice = 0.0;
	numPrices = 0;

	/* read the input file and accumulate the prices */
	while (!feof(fp)) {
		fscanf(fp, "%10lf\n", &price);
		totalPrice += price;
		numPrices++;
	}

	avgPrice = totalPrice / numPrices;
	printf("Number of houses is %d\n", numPrices);
	printf("Total Price of all houses is $%10.2f\n", totalPrice);
	printf("Average Price per house is $%10.2f\n", avgPrice);

	return 0;
}
