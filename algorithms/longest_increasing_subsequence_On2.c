/*
 * This program prints the longest increasing subsequence length in On^2
 * 
 * References: http://www.geeksforgeeks.org/
 * Author: @pyav
 */

#include<stdio.h>
#include<malloc.h>

#define SUCCESS 0
#define FAILURE 1
#define FUNC_FAILURE -1

/* Function which calculates the longest increasing subsequence */
int lis(int *arr, size_t n)
{
    int i = 0;
    int j = 0;
    int max = 0;
    int *lis = (int *) malloc(n * sizeof (int));

    /* Check whether lis points to a memory */
    if (NULL == lis) {
        perror("malloc");
        return FUNC_FAILURE;
    } 

    /* Initialize lis with 1 */
    for (; i < n; i++)
        lis[i] = 1;

    /* Actual longest increasing subsequence calculation */
    for (i = 1; i < n; i++) {
        for (j = 0; j < i; j++) {
            if (arr[i] > arr[j] && lis[i] < (lis[j] + 1)) {
                lis[i] = lis[j] + 1;
            }
        }
    }

    for (i = 0; i < n; i++)
        printf("%d ", lis[i]);

    printf("\n");

    for (i = 0; i < n; i++)
        if (max < lis[i])
            max = lis[i];

    /* Cleanup */
    free(lis);

    /* Return the longest increasing subsequence value */ 
    return max;
}

/* Main driver code */
int main(void)
{
    /* Sample array */
    int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};

    /* Calculate the number of elements in the sample array */
    size_t n = sizeof arr/ sizeof arr[0];

    /* Call the function which calculates the longest increasing subsequence */
    printf("Longest increasing subsequence value = %d\n", lis(arr, n));

    return SUCCESS;
}

