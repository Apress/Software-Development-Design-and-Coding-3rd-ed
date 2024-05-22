#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

/*
 * Program to solve the KWIC problem using a standard
 * top-down decomposition and a main program-subroutine
 * architecture.
 * 
 * jfdooley 07/2017
 */

/* We'll keep a doubly-linked list of words */
typedef struct Node {
    char *word;
    struct Node *next;
    struct Node *previous;
} wordNode;

wordNode *wordlist = NULL;
wordNode *lastWord = NULL;
int listSize=0;

/*
 * insert a word node into the wordlist
 */
void insertWord(int len, char word[]) {
    //printf("Storing word %s\n", word);
    char *wrd = malloc(len*1);
    strcpy(wrd, word);
    wordNode *node = malloc(sizeof(wordNode));
    node->next=NULL;
    node->word=wrd;
    node->previous = lastWord;
    if (lastWord==NULL) {
        wordlist = node;
    } else {
        lastWord->next=node;
    }
    lastWord = node;
    listSize++;
}

/* either pass in the file name (that we get from the command line)
 * or pass in the file descriptor
 */
void readWords() {
    char word[80];
    FILE *fr;
    fr = fopen ("G:\\currentClasses\\COP4020-ProgLang\\cProgs\\kwicSimple\\test.txt", "rt");  /* open the file for reading */
    if (fr==NULL) {
        printf("no file!!!\n");
        return;
    }
    int x;
    /*
	 * read one character at a time from file, stopping at EOF, which
     * indicates the end of the file.  Note that the idiom of "assign
     * to a variable, check the value" used below works because
     * the assignment statement evaluates to the value assigned.
	 */
    int haveWord = 0;
    int nCh=0;
    while  ( ( x = fgetc( fr ) ) != EOF ) {
        if (isalnum(x)) {
            haveWord = 1;
            word[nCh++] = (char)x;
        } else {
            if (haveWord) {  // add word to list
                word[nCh++]='\0';
                insertWord(nCh+1,word);
                nCh=0;
                haveWord=0;
            }
        }
    }
    fclose(fr);  /* close the file prior to exiting the routine */
}

/*
 * print a linked list of words and 
 * end with a newline
 */
void printList(wordNode *list) {
    while (list!=NULL) {
        printf("%s ", list->word);
        list= list->next;
    }
    printf("\n");
}

/* we should use the libc qsort routine here instead */
void indexSort(wordNode *keys[], wordNode *wordlist) {
    wordNode *wl = wordlist;  // assumes at least three words!!
    while (wl!=NULL) {
        wordNode *comp = wordlist;
        int i=0;
        while (comp!=NULL) {
            if (strcmpi(wl->word,comp->word)>=0) i++;
            comp = comp->next;
        }
        keys[i] = wl;
        wl=wl->next;
    }
}

void printKeys(int sz, wordNode *wrds[]){
  for (int i=1; i<sz; i++)
    printf("%s ", wrds[i]->word);
  printf("\n\n");
}

void printKWIC(int sz, wordNode *keys[]){
    for (int i=1; i<sz; i++){
        //printf("%s\n",keys[i]->word);
        if (keys[i]->previous==NULL) continue;
        char *before1 = keys[i]->previous->word;
        if (keys[i]->previous->previous==NULL) continue;
        char *before2 = keys[i]->previous->previous->word;
        if (keys[i]->next==NULL) continue;
        char *after1 = keys[i]->next->word;
        if (keys[i]->next->next==NULL) continue;
        char *after2 = keys[i]->next->next->word;
        printf(" %s %s - %s - %s %s\n",before2,before1,keys[i]->word,after1,after2);
    }
}


/*
 * classic main progrem-subroutine architecture
 */
int main(int argc, char **argv) {

	if (argc < 2) {
		fprintf(stderr, "Usage: %s <filename> <ignorefile>\n", argv[0]);
		exit(1);
	}

    readWords();
    printList(wordlist);
    wordNode *keys[listSize];
    indexSort(keys, wordlist);
    printKeys(listSize,keys);
    printKWIC(listSize, keys);
    return 0;
}
