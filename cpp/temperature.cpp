#include <iostream>

using namespace std;

int main() {
  double x;  // point on scale B where A is zero
  double
      y;  // number of degrees in B that equal a change of a single degree in A
  cin >> x;
  cin >> y;

  if (x == 0 && y == 1) {
    // they have the same starting point and rate of change
    cout << "ALL GOOD" << endl;
  } else if (y == 1) {
    // same rate of change, different starting point, will never coincide
    cout << "IMPOSSIBLE" << endl;
  } else {
      // since B increases at a faster rate than A, have to look into the negatives
      double temp = x / (1 - y);
      cout.precision(9);
      cout << temp << endl;
  }
}