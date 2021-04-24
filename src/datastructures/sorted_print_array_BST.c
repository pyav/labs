/* 
 * This program prints array which represents a BST in sorted order
 *
 * Output
 * ------
 *
 * 1 2 3 4 5 
 *
 *
 * Author: @pyav
 */

#include <stdio.h>

#define SUCCESS 0

/* Print in sorted order */
void print_sorted(int arr[], int low, int high)
{
  if (low > high)
    return;

  print_sorted(arr, (low * 2) + 1, high);
  printf("%d ", arr[low]);
  print_sorted(arr, (low * 2) + 2, high);
}

/* Main driver code */
int main (void)
{
  /* Array representing data in a BST level-wise */
  int arr[] = {4,2,5,1,3};

  /* Calculate number of elements */
  int no_elems = sizeof(arr) / sizeof(arr[0]);

  /* Print in sorted order, send last index of array */
  print_sorted(arr, 0, no_elems - 1);

  printf("\n");

  return SUCCESS;
}

