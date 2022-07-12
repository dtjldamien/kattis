#include <stdio.h>
#include <string.h>

#define MAX_LIMIT 80

int main()
{
  char text[MAX_LIMIT];
  gets(text);

  int vowelCount = 0;

  for (int i = 0; i < strlen(text); i++)
  {
    if (text[i] == 'a' || text[i] == 'e' || text[i] == 'i' || text[i] == 'o' || text[i] == 'u' || text[i] == 'A' || text[i] == 'E' || text[i] == 'I' || text[i] == 'O' || text[i] == 'U')
    {
      vowelCount++;
    }
  }

  printf("%d\n", vowelCount);
}
