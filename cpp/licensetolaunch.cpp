#include <iostream>

using namespace std;

int main() {
  int n;
  cin >> n;
  int min_space_junk;
  cin >> min_space_junk;
  int day = 0;
  int curr_space_junk;
  for (int i = 1; i < n; i++) {
      cin >> curr_space_junk;
      if (curr_space_junk < min_space_junk) {
          min_space_junk = curr_space_junk;
          day = i;
      }
  }
  cout << day << endl;
}