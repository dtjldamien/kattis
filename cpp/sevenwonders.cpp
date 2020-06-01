#include <algorithm>
#include <cmath>
#include <iostream>

using namespace std;

int main() {
  string cards_played;
  cin >> cards_played;

  int num_tablet = 0;
  int num_compass = 0;
  int num_gear = 0;

  for (int i = 0; i < cards_played.length(); i++) {
    if (cards_played[i] == 'T') {
      num_tablet++;
    } else if (cards_played[i] == 'C') {
      num_compass++;
    } else {
      num_gear++;
    }
  }

  int num_sets = min(num_tablet, num_compass);
  num_sets = min(num_sets, num_gear);

  int num_points = pow(num_tablet, 2) + pow(num_compass, 2) + pow(num_gear, 2) +
                   num_sets * 7;

  cout << num_points << endl;
}