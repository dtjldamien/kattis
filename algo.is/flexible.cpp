#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
  int width;  // width of room
  cin >> width;
  int p;  // number of partitions
  cin >> p;
  vector<int> locations;
  int location;
  locations.push_back(0);
  for (int i = 0; i < p; i++) {
    cin >> location;
    locations.push_back(location);
  }
  locations.push_back(width);

  vector<int> feasible_widths;
  for (int i = 0; i < locations.size() - 1; i++) {
    for (int j = i + 1; j < locations.size(); j++) {
      feasible_widths.push_back(locations[j] - locations[i]);
    }
  }
  sort(feasible_widths.begin(), feasible_widths.end());
  vector<int>::iterator itr;
  itr = unique(feasible_widths.begin(), feasible_widths.end());
  feasible_widths.resize(distance(feasible_widths.begin(), itr));
  for (auto feasible_width : feasible_widths) {
    cout << feasible_width << " ";
  }
  cout << endl;
}