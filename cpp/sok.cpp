#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  int a;  // orange juice
  int b;  // apple juice
  int c;  // pineapple juice
  cin >> a >> b >> c;

  int i;  // ratio orange
  int j;  // ratio apple
  int k;  // ratio pineapple;
  cin >> i >> j >> k;

  double per_unit_orange = 1.0 * a / i;
  double per_unit_apple = 1.0 * b / j;
  double per_unit_pineapple = 1.0 * c / k;

  double smallest_per_unit =
      min({per_unit_orange, per_unit_apple, per_unit_pineapple});

  cout.precision(9);
  cout << a - smallest_per_unit * i << " ";
  cout << b - smallest_per_unit * j << " ";
  cout << c - smallest_per_unit * k << endl;
}