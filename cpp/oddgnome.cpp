#include <iostream>

using namespace std;

// failed second test case
int main() {
  int num_gnome_groups;
  cin >> num_gnome_groups;
  for (int i = 0; i < num_gnome_groups; i++) {
    int num_gnomes;
    cin >> num_gnomes;
    int prev_gnome;
    int curr_gnome;
    bool found = false;
    cin >> curr_gnome;
    for (int j = 1; j < num_gnomes; j++) {
      prev_gnome = curr_gnome;
      cin >> curr_gnome;
      // gnome's id must be exactly one more than the integer preceding it
      if (prev_gnome + 1 != curr_gnome && !found) {
        cout << j + 1 << endl;
        found = true;
      }
    }
  }
}
