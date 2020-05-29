#include <iostream>

using namespace std;

int main() {
  int t;  // number of test cases
  cin >> t;

  for (int i = 0; i < t; i++) {
    int prev_num;
    int curr_num;
    int num_imported = 0;
    cin >> prev_num >> curr_num;
    while (curr_num != 0) {
      if (curr_num > 2 * prev_num) {
        num_imported += curr_num - 2 * prev_num;
      }
      prev_num = curr_num;
      cin >> curr_num;
    }
    cout << num_imported << endl;
  }
}