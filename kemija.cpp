#include <iostream>
#include <string>

using namespace std;

int main() {
  string input;
  getline(cin, input);
  string output;
  cout << input;
  for (int i = 0; i < input.size(); i++) {
    if (input[i] == 'a' || input[i] == 'e' || input[i] == 'i' ||
        input[i] == 'o' || input[i] == 'u') {
      i += 2;  // skip the p and the repeated voewl
    }
    output.push_back(input[i]);
  }
  cout << output << endl;
}