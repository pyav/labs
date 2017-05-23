/*
 * Following program demonstrates multiple prints in a single assignment. It
 * also shows that the length of the last print (nearest to the semi-colon) is
 * assigned to the variable. 
 * 
 *
 * Output
 * ------
 *
 * Pyav1234
 * 4
 *
 *
 * Author
 * ------
 *
 * pyav
 */

#include <stdio.h>

#define SUCCESS 0

int main(void)
{
  int x = (printf("Pyav"), printf("1234"));

  printf("\n%d\n", x);

  return SUCCESS;
}

