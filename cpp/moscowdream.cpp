#include <iostream>

using namespace std;

int main() {
  int a;  // easy problems
  int b;  // medium problems
  int c;  // hard problems
  int n;  // number of problems

  cin >> a >> b >> c >> n;

  // a > 0 b > 0 c > 0, requires at least 1 from each difficulty level
  // previous line + n >= 3 ensures that each difficulty is represented once
  // a + b + c >= n ensures that there are enough questions to form the paper
  if (a > 0 && b > 0 && c > 0 && n >= 3 && a + b + c >= n) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
  }
}