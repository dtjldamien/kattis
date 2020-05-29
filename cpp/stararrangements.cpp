#include <iostream>

using namespace std;

int main() {
  int n;
  cin >> n;
  cout << n << ":" << endl;
  for (int i = 2; i <= (n / 2) + 1; i++) {
    // i and j differs by at most 1
    for (int j = i - 1; j < i + 1; j++) {
      if (i + j == n) {
        cout << i << "," << j << endl;
      } else {
        int sum = 0;
        int k = 0;
        while (sum < n) {
          if (k % 2 == 0) {
            sum += i;
          } else {
            sum += j;
          }
          k++;
        }
        if (sum == n) {
          cout << i << "," << j << endl;
        }
      }
    }
  }
}