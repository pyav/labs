/*
 * Link of the problem statement: https://www.codechef.com/problems/CHEFDETE
 */

#include<stdio.h>
#include<stdbool.h>

int main(void)
{
	int N = 0;
	int i = 0;
	int val = 0;
	bool arr[100000] = {false};

	scanf ("%d", &N);

	for (i = 0; i < N; i++) {
		scanf ("%d", &val);
		if (val != 0)
			arr[val - 1] = true;
	}

	for (i = 0; i < N; i++)
		if (!arr[i])
			printf ("%d ", i + 1);

	printf ("\n");
	return 0;
}
