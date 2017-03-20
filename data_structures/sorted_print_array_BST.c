/* 
 * This program prints array which represents a BST
 * in sorted order
 *
 * Author: @pyav
 */


#include <stdio.h>

#define SUCCESS 0
#define FAILURE 1

/* Print in sorted form */
void print_sorted(int arr[], int low, int high)
{
	if (low > high)
		return;
	
	print_sorted(arr, low*2 + 1, high);
	printf("%d ", arr[low]);
	print_sorted(arr, low*2 + 2, high);
}

/* Main driver program */
int main (void)
{
	int arr[] = {4,2,5,1,3};
	int arr_siz = sizeof(arr) / sizeof(arr[0]);

	print_sorted(arr, 0, arr_siz - 1);
	printf("\n");

	return SUCCESS;
}

