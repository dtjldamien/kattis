#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

// failed second test case
int main() {
  string first_integer;
  string second_integer;
  cin >> first_integer;
  cin >> second_integer;

  int max_length = max(first_integer.length(), second_integer.length());

  // pad with zeroes
  for (int i = max_length - first_integer.length(); i > 0; i--) {
    first_integer = '0' + first_integer;
  }

  for (int i = max_length - second_integer.length(); i > 0; i--) {
    second_integer = '0' + second_integer;
  }

  string sum = "";
  int carry = 0;
  int curr_sum = 0;
  for (int i = max_length - 1; i >= 0; i--) {
    // convert char '0' to int 0
    curr_sum = int(first_integer[i]) - 48 + int(second_integer[i]) - 48 + carry;
    carry = 0;
    if (curr_sum >= 10) {
      curr_sum -= 10;
      carry = 1;  // always be 1, only addition
    }
    sum = to_string(curr_sum) + sum;
  }
  if (carry == 1) {
    sum = '1' + sum;
  }
  cout << sum << endl;
}
