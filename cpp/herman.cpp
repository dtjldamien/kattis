#include <cmath>
#include <iostream>
#include <iomanip>

using namespace std;

// failed second test case
int main() {
  double radius;
  cin >> radius;
  double normal_area = M_PI * radius * radius;
  double taxicab_area = pow(radius, 2) * 2;
  std::cout << std::setprecision(6) << std::fixed;
  cout << normal_area << endl;
  cout << taxicab_area << endl;
}
