#include <iostream>

using namespace std;

// failed second test case
int main() {
  int num_test_case;
  cin >> num_test_case;
  for (int i = 0; i < num_test_case; i++) {
    string line1;
    string line2;
    cin >> line1;
    cin >> line2;

    string output = "";
    for (int i = 0; i < line1.length(); i++) {
      if (line1.at(i) == line2.at(i)) {
        output += ".";
      } else {
        output += "*";
      }
    }
    cout << line1 << endl;
    cout << line2 << endl;
    cout << output << endl;
    cout << endl;
  }
}
