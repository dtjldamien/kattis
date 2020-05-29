#include <iostream>
#include <string>

using namespace std;

int main() {
  string record;
  cin >> record;

  int a_score = 0;
  int b_score = 0;
  for (int i = 0; i < record.length(); i = i + 2) {
    // need to convert ascii char value to int
    if (record[i] == 'A') {
      a_score += record[i + 1] - '0';
    } else {
      b_score += record[i + 1] - '0';
    }
  }

  if (a_score > b_score) {
    cout << 'A' << endl;
  } else {
    cout << 'B' << endl;
  }
}