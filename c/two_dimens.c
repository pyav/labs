/*
 * Following program demonstrates 2D array using a single pointer. The factor of
 * jump is the total number of columns.
 *
 * Output
 * ------
 *
 * 0 1 2 3 
 * 4 5 6 7 
 * 8 9 10 11 
 * 
 *
 * Author
 * ------
 *
 * pyav
 */

#include <stdio.h>
#include <malloc.h>

#define SUCCESS 0

int main(void)
{
  int i = 0;
  int j = 0;
  int r = 3;
  int c = 4;
  int k = 0;
  int *arr = NULL;

  arr = malloc(r * c * sizeof (int));

  /* Enter values */
  for (i = 0; i < r; i++)
    for (j = 0; j < c; j++)
      *(arr + i * c + j) = k++;

  /* Access values */
  for (i = 0; i < r; i++) {
    for (j = 0; j < c; j++)
      printf("%d ", *(arr + i * c + j));

    printf("\n");
  }

  /* Cleanup */
  free(arr);

  return SUCCESS;
}

