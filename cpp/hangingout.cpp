#include <iostream>

using namespace std;

int main() {
  // take in input
  int max_people;
  int num_events;
  cin >> max_people >> num_events;

  int num_groups_not_allowed = 0;
  int num_people = 0;

  for (int i = 0; i < num_events; i++) {
    string event;
    int group_size;
    cin >> event >> group_size;
    if (event == "enter") {
      // checks if group is able to enter
      if (group_size + num_people > max_people) {
        num_groups_not_allowed++;
      } else {
        num_people += group_size;
      }
    } else {  // leave
      num_people -= group_size;
    }
  }

  // output
  cout << num_groups_not_allowed << endl;
}
