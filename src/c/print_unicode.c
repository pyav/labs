#include<stdio.h>
#include<wchar.h>
#include<locale.h>

int main(void)
{
  int i;

  setlocale(LC_ALL, "");

  for (i = 0; i < 1000;i++)
    printf("Unicode (%d) = %lc\n", i, i);

  return 0;
}

