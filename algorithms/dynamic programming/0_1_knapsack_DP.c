/*
 * Following code is a demonstration of the solution of 0-1 Knapsack problem.
 *
 *
 * Output
 * ------
 *
 * The weight array: 1 2 3 
 * The value array: 6 10 12 
 * Total weight capacity is: 5
 * Max value = 22
 *
 *
 * Author
 * ------
 *
 * pyav
 ******************************************************************************/

#include <stdio.h>

#define SUCCESS 0

/* Get higher value */
int max(int a, int b)
{
  return (a > b)? a: b;
}

/*
 * The maximum value that can be obtained from n items is max of the following
 * two values:
 *   (1) Maximum value obtained by n-1 items and W weight (excluding nth item).
 *   (2) Value of nth item plus maximum value obtained by n-1 items and W 
 *       minus weight of the nth item (including nth item).
 */
int knapsack(int W, int wt[], int val[], int n)
{
  int i = 0;
  int w = 0;
  int B[n + 1][W + 1];

  for (w = 0; w <= W; w++) 
    B[0][w] = 0;

  for (i = 0; i <= n; i++) 
    B[i][0] = 0;

  /* Calculate and fill the matrix of values */
  for (i = 1; i <= n; i++) 
    for (w = 0; w <= W; w++ )
      if (wt[i - 1] <= w)
        B[i][w] = max(B[i - 1][w], 
            val[i - 1] + B[i - 1][w - wt[i - 1]]);
      else
        B[i][w] = B[i - 1][w];

  /* Return the max value */
  return B[n][W];
}

/* Main driver code */
int main(void)
{
  int i = 0;
  int W = 5;

  /* Declare weight array, value array and calculate the number of elements */
  int wt[] = {1, 2, 3};
  int val[] = {6, 10, 12};
  int n = sizeof (val)/ sizeof (val[0]);

  /* Print the values */
  printf("\nThe weight array: ");
  for (i = 0; i < n; i++)
    printf("%d ", wt[i]);

  printf("\nThe value array: ");
  for (i = 0; i < n; i++)
    printf("%d ", val[i]);

  printf("\nTotal weight capacity is: %d\n", W);

  /* Calculate the Knapsack value and print it */
  printf("Max value = %d\n\n", knapsack(W, wt, val, n));

  return SUCCESS;
}

