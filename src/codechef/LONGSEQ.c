#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main (void)
{
	int i = 0;
	int T = 0;
	int count0 = 0;
	int temp = 0;
	size_t lenD = 0;
	char *D = (char *) calloc (100001, sizeof (char));

	scanf ("%d", &T);
	for (; i<T; i++) {
		scanf ("%s", D);
		lenD = strlen (D);
		count0 = 0;
		temp = 0;

		while (temp < lenD) {
			if (D[temp] == '0')
				count0++;
			temp++;
		}

		if (count0 == 1 || count0 == (lenD - 1))
			printf ("Yes\n");
		else 
			printf ("No\n");
	}

	return 0;
}
