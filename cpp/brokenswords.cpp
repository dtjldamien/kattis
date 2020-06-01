#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  int n;  // number of swords broken
  cin >> n;

  int num_top_btm_slats = 0;
  int num_left_right_slats = 0;

  string curr_sword;
  for (int i = 0; i < n; i++) {
    cin >> curr_sword;
    for (int j = 0; j < 4; j++) {
      if (curr_sword[j] == '0') {
        if (j <= 1) {
          num_top_btm_slats++;
        } else {
          num_left_right_slats++;
        }
      }
    }
  }

  int num_swords = min(num_top_btm_slats, num_left_right_slats) / 2;
  num_top_btm_slats -= num_swords * 2;
  num_left_right_slats -= num_swords * 2;

  cout << num_swords << ' ' << num_top_btm_slats << ' ' << num_left_right_slats
       << endl;
}