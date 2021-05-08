// https://open.kattis.com/problems/nodup
#include <iostream>
#include <unordered_set>

using namespace std;

int main() {
  string word;
  unordered_set<string> set;
  while (cin >> word) {
    if (set.count(word)) {
      cout << "no" << endl;
      return 0;
    } else {
      set.insert(word);
    }
  }
  cout << "yes" << endl;
}