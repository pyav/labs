/*
 * This code finds the minimum number of edits that can be performed on a string
 * to convert it to another. Following edit operations are allowed:
 *    1. Insert
 *    2. Remove
 *    3. Replace
 *
 *
 * References
 * ----------
 *
 * (1) Introduction to Algorithms - Cormen, Leiserson, Rivest, Stein
 * (2) http://www.geeksforgeeks.org
 *
 *
 * NOTE
 * ----
 *
 * Though the book listed in (1) above discusses about few other opeartions, we
 * will concentrate our focus to only the three operations listed above.
 *
 *
 * Author
 * ------
 *
 * pyav
 *
 ******************************************************************************/

#include <stdio.h>
#include <string.h>

#define SUCCESS 0
#define FAILURE 1

/* Minimum of two */
int min(int a, int b)
{
  return (a < b)? a: b;
}

/* Least among three */
#define min3(a, b, c) min(min(a, b), c)

/* Calculate and return the edit distance value using dp */
int edit_dist_dp(char *str1, char *str2, size_t l1, size_t l2)
{
  int i = 0;
  int j = 0;
  int E[l1 + 1][l2 + 1];

  for (j = 0; j <= l2; j++)
    E[0][j] = j;

  for (i = 0; i <= l1; i++)
    E[i][0] = i;

  for (i = 1; i <= l1; i++)
    for (j = 1; j <= l2; j++)
      if (str1[i - 1] == str2[j - 1])
        E[i][j] = E[i - 1][j - 1];
      else
        E[i][j] = 1 + min3(E[i][j - 1], E[i - 1][j], E[i - 1][j - 1]); 

  return E[l1][l2];
}

/* Main driver code */
int main(void)
{
  int edit_distance = -1;
  char *str1 = "pyavgithub";
  char *str2 = "pYavghub";

  size_t l1 = strlen(str1);
  size_t l2 = strlen(str2);

  edit_distance = edit_dist_dp(str1, str2, l1, l2);
  printf("Edit distance of %s & %s = %d\n", str1, str2, edit_distance);

  return SUCCESS;
}

