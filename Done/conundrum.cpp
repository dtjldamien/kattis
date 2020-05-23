#include <cmath>
#include <iomanip>
#include <iostream>

using namespace std;

// failed second test case
int main() {
  string cipher;
  cin >> cipher;
  int days = 0;
  for (int i = 0; i < cipher.length(); i = i + 3) {
    if (cipher.at(i) != 'P') {
      days++;
    }
  }
  for (int i = 1; i < cipher.length(); i = i + 3) {
    if (cipher.at(i) != 'E') {
      days++;
    }
  }
  for (int i = 2; i < cipher.length(); i = i + 3) {
    if (cipher.at(i) != 'R') {
      days++;
    }
  }
  cout << days << endl;
}
