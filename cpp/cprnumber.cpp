#include <iostream>

using namespace std;

int main() {
  string cprNumber;
  cin >> cprNumber;

  // parse the cpr number into 10 digits
  // sample cpr number: "070761-4285"
  int c1 = cprNumber[0] - '0';
  int c2 = cprNumber[1] - '0';
  int c3 = cprNumber[2] - '0';
  int c4 = cprNumber[3] - '0';
  int c5 = cprNumber[4] - '0';
  int c6 = cprNumber[5] - '0';
  // skip '-'
  int c7 = cprNumber[7] - '0';
  int c8 = cprNumber[8] - '0';
  int c9 = cprNumber[9] - '0';
  int c10 = cprNumber[10] - '0';

  int sum = 4 * c1 + 3 * c2 + 2 * c3 + 7 * c4 + 6 * c5 + 5 * c6 + 4 * c7 + 3 * c8 + 2 * c9 + c10;
  
  if (sum % 11 == 0) {
    cout << 1 << endl;
  } else {
    cout << 0 << endl;
  }
  return 0;
}
