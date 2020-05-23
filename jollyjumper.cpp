#include <bits/stdc++.h>

#include <cstdlib>
#include <iostream>

using namespace std;

// failed second test case
int main() {
  int n;
  while (cin >> n) {
    // number of test cases
    bool values[n - 1];

    // first starting value
    int prev;
    cin >> prev;
    int curr;
    for (int i = 1; i < n; i++) {
      cin >> curr;
      int diff = abs(prev - curr);
      // diff is at least 0
      if (diff >= 1 || diff < n) {
        values[diff] = true;
      }
    }
    bool isJolly = true;
    for (int i = 1; i < n; i++) {
      if (!values[i]) {
        isJolly = false;
        break;
      }
    }
    if (isJolly) {
      cout << "Jolly" << endl;
    } else {
      cout << "Not Jolly" << endl;
    }
  }
}