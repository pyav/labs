/*
 * Link of the problem statement: https://www.codechef.com/problems/NOTINCOM
 */

#include <stdio.h>

#define SUCCESS 0
#define FAILURE -1

int main(void)
{
  int T = 0;
  int N = 0;
  int M = 0;
  int i = 0;
  int j = 0;
  int t = 0;
  int count = 0;

  scanf("%d", &T);

  for (i = 0; i < T; i++) {
    count = 0;
    scanf("%d %d", &N, &M);
    int A[1000000] = {0};

    for (j = 0; j < N; j++) {
      scanf("%d", &t);

      A[t - 1] = 1;
    }

    for (j = 0; j < M; j++) {
      scanf("%d", &t);

      if (A[t - 1] == 1)
        count = count + 1;
    }

    printf("%d\n", count);
  }

  return SUCCESS;
}

