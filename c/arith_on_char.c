/*
 * Following code demonstrates arithmetic operation on char variables.
 *
 * Output
 * ------
 *
 * a = 30, b = 40, c =  10
 * d = (a * b) / c = 120
 * sizeof a = 1, sizeof b = 1, sizeof c = 1
 *
 *
 * Author
 * ------
 *
 * pyav
 ******************************************************************************/

#include <stdio.h>

#define SUCCESS 0

int main(void)
{
  char a = 30, b = 40, c = 10;
  char d = (a * b) / c;

  printf("\na = %d, b = %d, c =  %d\n", a, b, c);
  printf("d = (a * b) / c = %d\n", d);
  printf("sizeof a = %d, sizeof b = %d, sizeof c = %d\n\n", sizeof a, sizeof b,
         sizeof c);

  return SUCCESS;
}
