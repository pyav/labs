/*
 * This program computes the length of longest common subsequence using 
 * Dynamic Programming concepts. 
 * 
 * Author: @pyav
 * References: (1) Introduction to Algorithms - Cormen, Leiserson, Rivest, Stein
 *             (2) http://www.geeksforgeeks.org
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define SUCCESS 0
#define FAILURE 1
#define FUNC_FAILURE -1

int max(int a, int b)
{
	return (a >= b)? a: b;
}

/* Function to evaluate the longest common subsequence */
int lcs(char *X, char *Y, size_t len_X, size_t len_Y)
{
	int i = 0;
	int j = 0;
	int c[len_X + 1][len_Y + 1];

	for (j = 0; j <= len_Y; j++)
		c[i][j] = 0;
	
	j = 0;

	for (i = 0; i <= len_X; i++)
		c[i][j] = 0;

	for (i = 1; i <= len_X; i++) {
		for (j = 1; j <= len_Y; j++) {
			if (X[i] == Y[j]) {
				c[i][j] = 1 + c[i - 1][j  - 1];
			} else {
				c[i][j] = max(c[i - 1][j], c[i][j - 1]);
			}
		}
	}

	/* Find the longest common subsequence */
	int index = c[len_X][len_Y];
	char *lcs = (char *) malloc((1 + index) * sizeof (char));
  if (NULL == lcs) {
    perror("malloc");
    return FUNC_FAILURE;
  }

	lcs[index] = '\0'; /* Make it a string */

	i = len_X;
	j = len_Y;

	while (i > 0 && j > 0) {
		if (X[i - 1] == Y[j - 1]) {
			lcs[index - 1] = X[i - 1];
			index--;
			i--;
			j--;
		} else if (c[i - 1][j] > c[i][j - 1]) {
			i--;
		} else {
			j--;
		}
	}

	printf("\nThe lcs of %s and %s is: %s\n\n", X, Y, lcs);
	
	free(lcs);
  return SUCCESS;
} /* End of lcs() */

/* Main driver code */
int main(void)
{
	char *X = "AGGTAB";
	char *Y = "GXTXAYB";
	size_t len_X = strlen(X);
	size_t len_Y = strlen(Y);

	if (SUCCESS == lcs(X, Y, len_X, len_Y))
    return SUCCESS;
  else 
    return FAILURE;
}

