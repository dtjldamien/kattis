#include <iostream>

using namespace std;

int main() {
  int x;
  int y;
  cin >> x;
  cin >> y;
  if (y % 2 == 0) {
    cout << "possible" << endl;
  } else {
    cout << "impossible" << endl;
  }
}