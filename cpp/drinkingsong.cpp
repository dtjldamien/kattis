#include <stdio.h>

#include <iostream>

using namespace std;

int main() {
  int n;  // 1 <= n <= 99
  string beverage;
  cin >> n >> beverage;

  // tle for third test case
  while (n != 1) {
    printf("%d bottles of %s on the wall, %d bottles of %s.\n", n,
           beverage.c_str(), n, beverage.c_str());
    n--;
    if (n == 1) {
      printf("Take one down, pass it around, 1 bottle of %s on the wall.\n\n",
             beverage.c_str());
    } else {
      printf("Take one down, pass it around, %d bottles of %s on the wall.\n\n",
             n, beverage.c_str());
    }
  }

  printf(
      "1 bottle of %s on the wall, 1 bottle of %s.\nTake it down, pass it "
      "around, no more bottles of %s.\n",
      beverage.c_str(), beverage.c_str(), beverage.c_str());
}