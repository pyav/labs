/*
 * Following program demonstrates printing of multiple assignments, increment
 * sequence and printing the printf returned value. Note that it compiles with a
 * warning as given below in the 'Output' section which is the actual output
 * obtained by executing the object file (./a.out).
 *
 *
 * Output
 * ------
 *
 * left-hand operand of comma expression has no effect [-Wunused-value]
 *
 * x = 10, y = 20, Final printed value = 20
 * y = 12
 * z = 7
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
  int x = 10;
  int y = 20;
  int z;

  printf("\nx = 10, y = 20, Final printed value = %d\n", (x, y));

  /* Check the sequence of evaluation and printed value */
  y = (x++, ++x);

  z = printf("y = %d\n", y);

  /* Check the printed value */
  printf("z = %d\n\n", z);

  return SUCCESS;
}

