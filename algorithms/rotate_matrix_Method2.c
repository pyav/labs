/*
 * Following code rotates a 2D matrix clockwise by 90 degree. Check the output
 * below to get more idea on this.
 *
 *
 * Output
 * ------
 *
 * 1 2 3 4 5 
 * 6 7 8 9 10 
 * 11 12 13 14 15 
 * 16 17 18 19 20 
 * 21 22 23 24 25 
 *
 * 21 16 11 6 1 
 * 22 17 12 7 2 
 * 23 18 13 8 3 
 * 24 19 14 9 4 
 * 25 20 15 10 5 
 *
 *
 * Author
 * ------
 *
 * pyav
 ******************************************************************************/

#include <stdio.h>

#define SUCCESS 0
#define ROWS 5
#define COLUMNS 5

int main(void)
{
  int i = 0;
  int j = 0;
  int temp_r = 0;
  int temp_c = 0;
  int temp = 0;

  /* The matrix */
  int a[ROWS][COLUMNS] = {
    {1, 2, 3, 4, 5}, 
    {6, 7, 8, 9, 10}, 
    {11, 12, 13, 14, 15}, 
    {16, 17, 18, 19, 20}, 
    {21, 22, 23, 24, 25}
  };

  printf("\n");	

  /* Print the unrotated matrix */
  for (i = 0; i < ROWS; i++) {
    for (j = 0; j < COLUMNS; j++)
      printf ("%d ", a[i][j]);

    printf ("\n");
  }

  printf ("\n");

  temp_r = ROWS;
  temp_c = COLUMNS - 1;

  /* Roatate the data in the matrix */
  for (i = 0; i < temp_r; i++) {
    for (j = i; j < temp_c; j++) {
      temp = a[j][COLUMNS - i - 1];
      a[j][COLUMNS - i - 1] = a[i][j];
      a[i][j] = a[ROWS - j - 1][i];
      a[ROWS - j - 1][i] = a[ROWS - i - 1][COLUMNS - j - 1];
      a[ROWS - i - 1][COLUMNS - j - 1] = temp;
    }

    temp_c = temp_c - 1;
    temp_r = temp_r - 1;
  }

  /* Print the rotated matrix */
  for (i = 0; i < ROWS; i++) {
    for (j = 0; j < COLUMNS; j++)
      printf ("%d ", a[i][j]);

    printf ("\n");
  }

  printf ("\n");

  return SUCCESS;
}

