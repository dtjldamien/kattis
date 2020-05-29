#include <iostream>

using namespace std;

int main() {
  int t;  // num_planets to be analyzed
  // 10^9 x 10^9 would be much larger than the range of int
  long long int p;  // population
  int r;  // population growth factor
  int f;  // annual food production

  // before population is no longer sustainable by food production
  int num_years_remaining;
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> p >> r >> f;
    num_years_remaining = 0;
    while (p <= f) {
      p *= r;
      num_years_remaining++;
    }
    cout << num_years_remaining << endl;
  }
}