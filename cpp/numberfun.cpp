#include <iostream>

using namespace std;

int main() {
  int n;  // number of test cases
  cin >> n;
  int a;
  int b;
  int c;

  for (int i = 0; i < n; i++) {
    cin >> a >> b >> c;
    if (a + b == c) {
      // addition
      cout << "Possible" << endl;
    } else if (a - b == c) {
      // subtraction
      cout << "Possible" << endl;
    } else if (b - a == c) {
      // subtraction
      cout << "Possible" << endl;
    } else if (a * b == c) {
      // multiplication
      cout << "Possible" << endl;
    } else if (a % b == 0 && a / b == c) {
      // division + check for integer division
      cout << "Possible" << endl;
    } else if (b % a == 0 && b / a == c) {
      // division + check for integer division
      cout << "Possible" << endl;
    } else {
      cout << "Impossible" << endl;
    }
  }
}