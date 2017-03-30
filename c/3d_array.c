/*
 * Following code demonstrates 3D-array usage. 
 *
 * Output
 * ------
 *
 * $ gcc -Wall 3d_array.c && ./a.out 
 * first second third 
 * fourth fifth sixth 
 *
 *
 * NOTE
 * ----
 *
 * Another way to demonstrate this array usage could be to use character pointer
 * to the strings of 2D arrary. The signature could be 
 * char *arr[MAX_FIRST_D][MAX_SECOND_D]
 *
 *
 * Author
 * ------
 *
 * pyav
 ******************************************************************************/

#include <stdio.h>

#define SUCCESS 0
#define MAX_FIRST_D 2
#define MAX_SECOND_D 3
#define MAX_THIRD_D 10

int main(void)
{
  int i = 0; 
  int j = 0; 

  /* Initialize the array */
  char arr[MAX_FIRST_D][MAX_SECOND_D][MAX_THIRD_D] = {
    {"first", "second", "third"},
    {"fourth", "fifth", "sixth"},
  };

  /* Print the array */
  for (i = 0; i < MAX_FIRST_D; i++) {
    for (j = 0; j < MAX_SECOND_D; j++)
      printf("%s ", arr[i][j]);

    printf("\n");
  }

  return SUCCESS;
}

