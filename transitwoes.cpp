#include <iostream>

using namespace std;

int main() {
  // two three digit numbers
  int leave_house_time;
  int class_start_time;
  int num_transit_routes;
  // take in input
  cin >> leave_house_time >> class_start_time >> num_transit_routes;

  int total_travel_time = 0;
  // time taken to walk from one bus stop to another
  // d0 = time taken to walk from house to bus stop
  // dN = time taken to walk from last bus stop to class
  int walking_time[num_transit_routes + 1];
  for (int i = 0; i < num_transit_routes + 1; i++) {
    cin >> walking_time[i];
  }

  // amount of time Yraglac rides the bus
  int transit_time[num_transit_routes];
  for (int i = 0; i < num_transit_routes; i++) {
    cin >> transit_time[i];
  }

  // amount of time Yraglac waits for the bus
  int interval_time[num_transit_routes];
  for (int i = 0; i < num_transit_routes; i++) {
    cin >> interval_time[i];
  }

  total_travel_time += walking_time[0];
  for (int i = 0; i < num_transit_routes; i++) {
    if (total_travel_time < interval_time[i]) {
      total_travel_time += interval_time[i] - total_travel_time;
    } else {
      total_travel_time += total_travel_time % interval_time[i];
    }
    total_travel_time += transit_time[i];
    total_travel_time += walking_time[i + 1];
  }

  if (total_travel_time + leave_house_time < class_start_time) {
    cout << "yes" << endl;
  } else {  // leave
    cout << "no" << endl;
  }
}
