#include <iostream>
#include <vector>

using namespace std;

int main() {
  double c;  // capacity of the tank in gallons 0 < C
  double x;  // rate of fuel leak in gallons per hour X <= 100
  double m;  // distance in miles to the next gas station 0 < M <= 500
  cin >> c >> x >> m;
  c /= 2;  // half the tank is drained

  vector<bool> possible;
  possible.resize(6);
  for (int i = 0; i < 6; i++) {
    double s;  // speed
    double f;  // fuel efficiency
    cin >> s >> f;

    double time_taken = m / s;
    double fuel_needed = m / f + time_taken * x;

    if (fuel_needed <= c) {
      possible[i] = true;
    }
  }

  for (int i = 5; i >= 0; i--) {
    if (possible[i]) {
      cout << "YES ";
      switch (i) {
        case 0:
          cout << "55" << endl;
          break;
        case 1:
          cout << "60" << endl;
          break;
        case 2:
          cout << "65" << endl;
          break;
        case 3:
          cout << "70" << endl;
          break;
        case 4:
          cout << "75" << endl;
          break;
        case 5:
          cout << "80" << endl;
          break;
      }
      return 0;
    }
  }

  cout << "NO" << endl;
}