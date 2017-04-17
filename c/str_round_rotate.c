/*
 * Following program demonstrates a string search in another one being round
 * rotated. Note that there is no safety check while copying the string. Also,
 * addresses are masked from the 'Output' section. A couple of test cases are
 * printed for each invocation of the object file (./a.out). 
 * 
 *
 * Output
 * ------
 *
 * Enter main string: pyavPyav
 * Enter sub string: avPy
 * Found at: 0x........
 *
 *
 * Enter main string: pyavPyav
 * Enter sub string: avpy
 * Found at: 0x........
 *
 *
 * Enter main string: pyav
 * Enter sub string: Py
 * Not found.
 *
 *
 *
 * Author
 * ------
 *
 * pyav
 ******************************************************************************/

#include <stdio.h>
#include <malloc.h>
#include <string.h>

#define SUCCESS 0

int main(void)
{
  char *sub_str = NULL;
	char *main_str = NULL;
	char *final_str = NULL;
  char *final_main_str = NULL;

	main_str = malloc(64 * sizeof (char));
	sub_str = malloc(5 * sizeof (char));

	printf("\nEnter main string: ");
	scanf("%s", main_str);

	printf("Enter sub string: ");
	scanf("%s", sub_str);

  /* Concatenate */
	final_main_str = strcat(main_str, main_str);

  /* Check the presence */
	if ((final_str = strstr(final_main_str, sub_str)) != NULL)
		printf ("Found at: %p\n\n", &final_str);
	else
		printf ("Not found.\n\n");

  /* Cleanup */
	free (main_str);
	free (sub_str);

	return SUCCESS;
}

