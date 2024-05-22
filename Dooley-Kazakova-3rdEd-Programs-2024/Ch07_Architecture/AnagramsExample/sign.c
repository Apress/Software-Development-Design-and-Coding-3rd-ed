/* Copyright (C) 1999 Lucent Technologies */
/* From 'Programming Pearls' by Jon Bentley */

/*
 * sign.c -- sign each line of a file for finding anagrams
 * The input line "stop" gives the output line "opst stop"
 * modified by jfdooley 10-12-2005
 *
 * should be at the front end of a sign <dict | sort | squash pipe.
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* assume that the words are no more than 100 characters long */
#define WORDMAX 100

/* 
 * quick way to compare two characters
 * returns <0 if x comes before y
 * =0 if x and y are the same
 * >0 if x comes after y lexicographically
 * we need this function to pass to qsort()
 */
int charcomp(char *x, char *y) {  
	return *x - *y;
}

int main() {  
	char word[WORDMAX], sig[WORDMAX];

    while (scanf("%s", word) != EOF) {
        strcpy(sig, word);
        qsort(sig, strlen(sig), sizeof(char), charcomp);
        printf("%s %s\n", sig, word);
    }
    return 0;
}
