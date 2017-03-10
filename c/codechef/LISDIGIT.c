/*
 * Link of the problem statement: https://www.codechef.com/problems/LISDIGIT
 */

#include <stdio.h>

#define SUCCESS 0
#define FAILURE 1

int main(void)
{
	int T = 0;
	int n = 0;
	int i = 0;
	int j = 0;
	int num = 0;
	int lis = 0;

	scanf("%d", &T);
	for (i = 0; i < T; i++) {
		scanf("%d", &n);
		
		for (j = 0; j < n; j++) {
				scanf("%d", &lis);
				num = num * 10 + lis;
		}

		printf("%d\n", num);
		num = 0;
	}

	return SUCCESS;
}

