#include <cmath>
#include <iostream>

using namespace std;

int main() {
  double outer_diameter;
  double volume;
  while (true) {
    cin >> outer_diameter >> volume;
    if (outer_diameter == 0 && volume == 0) {
      break;
    } else {
      // setting precision, 9dp
      cout << fixed;
      cout.precision(9);
      cout << cbrt(((-6 * volume) / M_PI) + pow(outer_diameter, 3)) << endl;
    }
  }
}
