#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  int n;  // number of players 2 < N < 20
  cin >> n;
  string prev_player;
  string curr_player;
  cin >> prev_player;

  bool is_increasing = true;
  bool is_decreasing = true;

  for (int i = 1; i < n; i++) {
      cin >> curr_player;
      // compare checks the alphabetical order of two strings
      if (prev_player.compare(curr_player) > 0) {
          is_increasing = false;
      } else if (prev_player.compare(curr_player) < 0) {
          is_decreasing = false;
      }
      prev_player = curr_player;
  }

  if (is_increasing) {
    cout << "INCREASING" << endl;
  } else if (is_decreasing) {
    cout << "DECREASING" << endl;
  } else {
    cout << "NEITHER" << endl;
  }
}