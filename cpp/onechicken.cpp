#include <iostream>

using namespace std;

int main() {
  int n;  // number of people at the buffet
  int m;  // number of pieces of chicken
  cin >> n >> m;

  int diff;
  if (n < m) {
    diff = m - n;
    if (diff == 1) {
      cout << "Dr. Chaz will have 1 piece of chicken left over!" << endl;

    } else {
      cout << "Dr. Chaz will have " << diff << " pieces of chicken left over!"
           << endl;
    }
  } else {
    diff = n - m;
    if (diff == 1) {
      cout << "Dr. Chaz needs 1 more piece of chicken!" << endl;
    } else {
      cout << "Dr. Chaz needs " << diff << " more pieces of chicken!" << endl;
    }
  }
}