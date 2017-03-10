#include <stdio.h>

int main(void)
{
	int T = 0;
	int n = 0;
	int i = 0;
	int j = 0;
	int a[10000];
	int b[10000];

	scanf("%d", &T);

	for (i = 0; i < T; i++) {
		scanf("%d", &n);

		for (j = 0; j < n; j++) {
			scanf("%d", &a[j]); /* Given encoded value */
			
			b[j] = a[j] >> 16;
			a[j] = a[j] - (b[j] << 16);
		}
		
		printf("Case %d:\n", i + 1);
		for (j = 0; j < n; j++) {
			printf("%d ", a[j]);
		}

		printf("\n");
		for (j = 0; j < n; j++) {
			printf("%d ", b[j]);
		}

		printf("\n");
	}

	return 0;
}

