/*
 * Link of the problem statement: https://www.codechef.com/problems/ENCD04
 * 
 * Testcase input:
 * 
 * 4
 * 5
 * 0 3 1 2 9
 * 7 3 4 9 9
 * 1 7 5 5 3
 * 2 3 4 2 5
 * 1
 * 6
 * 0 1 2 3 4 5
 * 0
 *
 * Output:
 *
 * 24
 * 15
 */

#include <stdio.h>

#define SUCCESS 0

/* Find minimum of two numbers */
int min(a, b) {
  return (a < b)? a: b; 
}

/* Calculate and return minimum cost to reach the bottom-right from top-left */
int min_cost_path(int arr[999][999], int N, int M)
{
  int i = 0;
  int j = 0;
  int temp[999][999]; 

  /* Start point will always be the same */
  temp[0][0] = arr[0][0];

  /* First row cost calculation */
  for (j = 1; j < M; j++)
    temp[0][j] = arr[0][j] + temp[0][j - 1];

  /* First column cost calculation */
  for (i = 1; i < N; i++)
    temp[i][0] = arr[i][0] + temp[i - 1][0];

  /* Calculate the minimum cost */
  for (i = 1; i < N; i++) {
    for (j = 1; j < M; j++) {
      temp[i][j] = arr[i][j] + min(temp[i - 1][j], temp[i][j - 1]);
    }
  }

  return temp[N - 1][M - 1];
}

/* Main driver code */
int main(void)
{
  int i = 0;
  int j = 0;
  int N = 0;
  int M = 0;
  int arr[999][999]; 

  /* Take row input */
  scanf("%d", &N);

  while (N != 0) { /* Terminate if no row */
    /* Take column input */
    scanf("%d", &M);

    /* Take the matrix input */
    for (i = 0; i < N; i++) {
      for (j = 0; j < M; j++) {
        scanf("%d", &arr[i][j]);
      }
    }

    /* Call the function to calculate minimum cost, then print the value */
    printf("%d\n", min_cost_path(arr, N, M));

    /* Take row input again */
    scanf("%d", &N);
  }

  return SUCCESS;
}
/* End of main driver code */

