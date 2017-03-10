/* 
 * Link of the problem statement: https://www.codechef.com/problems/KOL16J 
 */

#include <stdio.h>
#include <stdbool.h>

#define SUCCESS 0
#define FAILURE 1

int main(void)
{
	int T = 0; /* Test Cases */
	int n = 0; /* Chapters */
	int i = 0;
	int j = 0;
	int k = 0;
	int k2 = 0;
	int sum = 0;
  bool linear = true;

	scanf("%d", &T);

	for (i = 0; i < T; i++) {
    sum = 0;
    linear = true;

    scanf("%d", &n);
    scanf("%d", &k);
    sum = sum + k;

    for (j = 1; j < n; j++) {
      scanf("%d", &k2);
      sum = sum + k2;

      if (k2 != k+1)
        linear = false;

      k = k2;
    }

    if (sum != n*(n+1)/2) {
      printf("no\n");
    } else {
      if (!linear)
        printf("yes\n");
      else
        printf("no\n");
    }
  }

  return SUCCESS;
}

