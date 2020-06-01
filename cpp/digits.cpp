#include <iostream>
#include <string>

using namespace std;

int main() {
  string x0_string;
  cin >> x0_string;
  while (x0_string != "END") {
    // number of digits in the decimal representation of x1
    string x1_string = to_string(x0_string.length());
    int counter = 1;

    while (x0_string != x1_string) {
      x0_string = x1_string;
      x1_string = to_string(x0_string.length());
      counter++;
    }

    cout << counter << endl;
    cin >> x0_string;
  }
}