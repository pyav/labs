/*
 * Problem Statement
 * -----------------
 *
 * Pyav got stuck in a three dimensional matrix. Having being chased by a demon
 * he needs to find the time required for the quickest way out of the matrix
 * which allows block to block passage in a way defined in "Allowed direction of
 * movements" section below. Each block has a cost attached to it which
 * represents the time taken to cross the block. It is given that the demon
 * always takes more time than the minimum time required to cross the matrix.
 * Help Pyav know the minimum time required to cross the 3D matrix so that he
 * can be assured that he will be saved from the demon as he knows that the
 * demon will always take more time than that minimum time. 
 *
 * The entry happened at the index 0,0,0 and the exit can only happen from
 * M,N,O. These indices follow the 3D notation of X,Y and Z axes respectively. 
 * The values in each block can be from 0 to 9. 
 *
 * Allowed direction of movements
 * ------------------------------
 *
 * Increasing X starting from 0, increasing Y starting from 0 and increasing Z
 * starting from 0.
 *
 * Example
 * -------
 *
 * A 3D matrix given is: {
 *                        {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
 *                        {{10, 11, 12}, {13, 14, 15}, {16, 17, 18}},
 *                        {{19, 20, 21}, {22, 23, 24}, {25, 26, 27}}
 *                       }
 *
 * The path to be followed to get minimum cost path is
 * ---------------------------------------------------
 *
 * 1, 2, 3, 6, 9, 18, 27
 *
 * Output
 * ------
 *
 * Min time = 66
 *
 * Solution
 * --------
 *
 * This program calculates the cost of the path which takes minimum time to
 * reach to an index in a 3D-matrix. The start index is 0,0,0 and the
 * destination index is given as M,N,O. 
 * 
 * Author
 * ------
 *
 * @pyav
 */
/******************************************************************************/

#include <stdio.h>

#define LEN 3
#define BRD 3
#define HT 3
#define SUCCESS 0
#define FAILURE 1

int temp[LEN][BRD][HT];

/* Find minimum of two numbers */
int min(int a, int b)
{
  return (a < b)? a: b; 
}

/* Find minimum of three numbers */
int min3(int a, int b, int c)
{
  return min(min(a, b), c);
}

/* Calculate and return minimum cost to reach to the end of a 2D matrix */
void min_cost_path_2D(int arr[LEN][BRD][HT], int M, int N, int O)
{
  int i = 0;
  int j = 0;
  int k = 0;

  /* Start point will always be the same */
  temp[0][0][0] = arr[0][0][0];

  if (O == 0) {
    /* First row cost calculation */
    for (j = 1; j < N; j++)
      temp[0][j][O] = arr[0][j][O] + temp[0][j - 1][O];

    /* First column cost calculation */
    for (i = 1; i < M; i++)
      temp[i][0][O] = arr[i][0][O] + temp[i - 1][0][O];

    /* Calculate the minimum cost */
    for (i = 1; i < M; i++)
      for (j = 1; j < N; j++)
        temp[i][j][O] = arr[i][j][O] + min(temp[i - 1][j][O], 
                                           temp[i][j - 1][O]);
  } else if (N == 0) {
    /* First row cost calculation */
    for (k = 1; k < O; k++)
      temp[0][N][k] = arr[0][N][k] + temp[0][N][k - 1];

    /* First column cost calculation */
    for (i = 1; i < M; i++)
      temp[i][N][0] = arr[i][N][0] + temp[i - 1][N][0];

    /* Calculate the minimum cost */
    for (i = 1; i < M; i++)
      for (k = 1; k < O; k++)
        temp[i][N][k] = arr[i][N][k] + min(temp[i - 1][N][k], 
                                           temp[i][N][k - 1]);
  } else if (M == 0) {
    /* First row cost calculation */
    for (j = 1; j < N; j++)
      temp[M][j][0] = arr[M][j][0] + temp[M][j - 1][0];

    /* First column cost calculation */
    for (k = 1; k < O; k++)
      temp[M][0][k] = arr[M][0][k] + temp[M][0][k - 1];

    /* Calculate the minimum cost */
    for (k = 1; k < O; k++)
      for (j = 1; j < N; j++)
        temp[M][j][k] = arr[M][j][k] + min(temp[M][j - 1][k], 
                                           temp[M][j][k - 1]);
  }
}

/*
 * Calculate and return minimum cost to reach a block indexed 
 * at M,N,O from 0,0,0 in arr.
 */
int min_cost_path_3D(int arr[LEN][BRD][HT], int M, int N, int O)
{
  int i = 0;
  int j = 0;
  int k = 0;

  /* Calculate min-cost path for XY axes */
  min_cost_path_2D(arr, M, N, 0);

  /* Calculate min-cost path for XZ axes */
  min_cost_path_2D(arr, M, 0, O);

  /* Calculate min-cost path for YZ axes */
  min_cost_path_2D(arr, 0, N, O);

  /* Now calculate min-cost path for internal indices like 1,1,1 and so on */
  for (i = 1; i < M; i++)
    for (j = 1; j < N; j++)
      for (k = 1; k < O; k++)
        temp[i][j][k] = arr[i][j][k] + min3(temp[i][j][k - 1],
                                            temp[i][j - 1][k],
                                            temp[i - 1][j][k]);

  /* Return the total value of minimum time required to cross the matrix */
  return temp[M - 1][N - 1][O - 1];
}

/* Main driver code */
int main(void)
{
  /* Destination index M,N,O */
  int M = 3;
  int N = 3;
  int O = 3;

  /* 3D cost array */
  int arr[LEN][BRD][HT] = {
                           {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                           {{10, 11, 12}, {13, 14, 15}, {16, 17, 18}},
                           {{19, 20, 21}, {22, 23, 24}, {25, 26, 27}}
                          };

  /* 
   * A 3D cube has 3 top faces originating from the index 0,0,0. These 3D
   * indices are represented by i,j,k where all of them starts from 0 and ends
   * at M,N,O respectively which is a representation of X,Y,Z axes respectively. 
   */

  printf("Min time = %d\n", min_cost_path_3D(arr, M, N, O));

  return SUCCESS;
}
/* End of main driver code */

