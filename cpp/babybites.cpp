#include <iostream>
#include <string>

using namespace std;

int main() {
  int n;  // number of bites Arild receives
  cin >> n;

  string word;
  bool is_fishy = false;
  for (int i = 1; i <= n; i++) {
    cin >> word;
    if (word == "mumble") {
      continue;
    } else if (stoi(word) == i) {
      continue;
    } else {
      is_fishy = true;
      break;
    }
  }

  if (is_fishy) {
    cout << "something is fishy" << endl;
  } else {
    cout << "makes sense" << endl;
  }
}