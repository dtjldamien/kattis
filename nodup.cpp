#include <iostream>
#include <unordered_set>

using namespace std;

int main() {
  string word;
  unordered_set<string> set;
  while (cin >> word) {
    if (set.find(word) != set.end()) {
      cout << "no" << endl;
      return 0;
    }
  }
  cout << "yes" << endl;
}