#include <iostream>

using namespace std;

int main() {
  int k;  // player initially with the box
  int n;  // number of questions
  cin >> k >> n;
  int total_time_taken = 0;
  int time_taken = 0;
  bool has_exploded = false;
  char z;  // type of answer given
  for (int i = 0; i < n; i++) {
    cin >> time_taken >> z;
    total_time_taken += time_taken;
    if (total_time_taken >= 210) {
      has_exploded = true;
    }
    if (z == 'T' && !has_exploded) {
      // take note, cannot use k %= 8
      // when k = 8, k = 0
      if (k == 8) {
        k = 1;
      } else {
        k++;
      }
    }
  }
  cout << k << endl;
}