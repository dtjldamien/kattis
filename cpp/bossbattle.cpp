#include <iostream>

using namespace std;

int main() {
  int n;  // number of pillars in the room
  cin >> n;

  n -= 2;
  if (n < 1) {
    cout << 1 << endl;
  } else {
    cout << n << endl;
  }
}