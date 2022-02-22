#include <iostream>

using namespace std;

int main() {
  string s;  // input
  cin >> s;

  for (int i = 0; i < s.length(); i++) {
    if (s[i] == 'a') {
      cout << s.substr(i) << endl;
      return 0;
    }
  }
}
