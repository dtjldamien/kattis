#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

int main() {
  int n;  // number of buses
  cin >> n;
  bool buses[1001] = {0};  // initialise array to be all false
  int bus_number;
  for (int i = 0; i < n; i++) {
    cin >> bus_number;
    buses[bus_number] = true;
  }
  int consecutive_counter = 0;
  int consecutive_end = 0;
  for (int i = 1; i <= 1000; i++) {
    if (buses[i]) {
      if (consecutive_counter == 0) {
        cout << i;
      } else if (i == 1000) {
        if (consecutive_counter == 1) {
          cout << ' ' << 1000;
        } else if (consecutive_counter > 1) {
          cout << '-' << 1000;
        }
      }
      consecutive_counter++;
      consecutive_end = i;
    } else {
      if (consecutive_counter == 2) {
        cout << ' ' << consecutive_end << ' ';
      } else if (consecutive_counter > 2) {
        cout << '-' << consecutive_end << ' ';
      } else if (consecutive_counter == 1) {
        cout << ' ';
      }
      consecutive_counter = 0;
    }
  }
  cout << endl;
}