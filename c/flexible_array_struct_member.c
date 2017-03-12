/*
 * Following code demonstrates the usage of flexible array member in a structure
 * 
 * Output
 * ------
 *
 * e->size = 10
 * e->ch = pyav testi
 *
 *
 * References
 * ----------
 *
 *  (1) https://www.securecoding.cert.org/
 *
 * Notes
 * -----
 *
 *  (1) To avoid any potential for undefined behavior, structures that contain a
 *      flexible array member should always be allocated dynamically. 
 *  (2) Flexible arrays must
 *    (2.1) Have dynamic storage duration (malloc() or similar function).
 *    (2.2) Be dynamically copied (using memcpy() or similar function) and not
 *          by assignment.
 *    (2.3) Be passed by pointer and not by value when used as an argument to a
 *          function.
 *
 *
 *
 * Author: @pyav
 *
 ******************************************************************************/

#include <stdio.h>
#include <malloc.h>
#include <string.h>
#include <stdlib.h>

#define SUCCESS 0
#define MAX_LEN 10

/* The structure */
struct test {
  size_t size;
  char ch[]; /* Flexible array member */
};

/* Main driver code */
int main(void) 
{
  char *ch = "pyav testing";
  struct test *e = (struct test *) malloc(sizeof (struct test) + 
                                          (MAX_LEN + 1) * sizeof (char));

  /* Validate */
  if (NULL == e) {
    perror("malloc");
    exit(EXIT_FAILURE);
  }

  /* Copy string, max MAX_LEN size */
  e->size = strnlen(ch, MAX_LEN);
  memcpy(e->ch, ch, e->size);
  e->ch[e->size] = '\0';

  /* Print values */
  printf("e->size = %zd\n", e->size);
  printf("e->ch = %s\n", e->ch);

  /* Cleanup */
  free(e);

  return SUCCESS;
}
/* End of main driver code */

