#include <iostream>

using namespace std;

int main() {
  while (true) {
    int x;  // number of sweet jars
    int y;  // number of honey jars
    cin >> x >> y;
    if (x == 0 && y == 0) {
      break;
    }
    if (x + y == 13) {
      // takes precedence since x > y or x < y can be true even if x + y == 13
      cout << "Never speak again." << endl;
    } else if (y > x) {
      cout << "Left beehind." << endl;
    } else if (x > y) {
      cout << "To the convention." << endl;
    } else {
      // x == y
      cout << "Undecided." << endl;
    }
  }
}