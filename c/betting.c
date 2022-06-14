#include <stdio.h>
  
int main()
{
  int percentageOne;
  scanf("%d", &percentageOne);
  int percentageTwo = 100 - percentageOne;
  float payoutOne = 1 + 1.0 * percentageTwo / percentageOne;
  float payoutTwo = 1 + 1.0 * percentageOne / percentageTwo;
  printf("%f\n", payoutOne);
  printf("%f\n", payoutTwo);
}
