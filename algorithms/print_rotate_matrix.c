/*
 * Following code prints the data of a 2D matrix in rotated format by 90 degree
 * clockwise. It does not change the matrix. 
 *
 * 
 * Output
 * ------
 *
 * 1 2 3 
 * 4 5 6 
 * 7 8 9 
 *
 * 7 4 1 
 * 8 5 2 
 * 9 6 3 
 *
 *
 * Author
 * ------
 *
 * pyav
 ******************************************************************************/

#include <stdio.h>

#define SUCCESS 0
#define ROWS 3
#define COLUMNS 3

int main(void)
{
  int i = 0;
  int j = 0;

  /* The matrix */
  int a[ROWS][COLUMNS] = {
                          {1, 2, 3}, 
                          {4, 5, 6}, 
                          {7, 8, 9}
                         };

  printf ("\n");

  /* Print the matrix */
  for (i = 0; i < ROWS; i++) {
    for (j = 0; j < COLUMNS; j++)
      printf ("%d ", a[i][j]);

    printf ("\n");
  }

  printf ("\n");

  /* 
   * Print matrix in rotated format. Rotation is by 90 degree clockwise.
   * Do not change the data in the matrix, only print.
   */
  for (i = 0; i < COLUMNS; i++) {
    for (j = ROWS-1; j >= 0; j--)
      printf ("%d ", a[j][i]);

    printf ("\n");
  }

  printf("\n");

  return SUCCESS;
}

