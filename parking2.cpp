#include <cmath>
#include <iostream>

using namespace std;

int main() {
  int num_test_cases;
  // take in input
  cin >> num_test_cases;

  for (int i = 0; i < num_test_cases; i++) {
    int num_stores;
    cin >> num_stores;

    int curr_store_distance;
    cin >> curr_store_distance;
    int min_store_distance = curr_store_distance;
    int max_store_distance = curr_store_distance;
    for (int j = 1; j < num_stores; j++) {
      cin >> curr_store_distance;
      min_store_distance = min(curr_store_distance, min_store_distance);
      max_store_distance = max(curr_store_distance, max_store_distance);
    }
    // (max - min) / 2 is the parking spot
    // to travel around, have to walk the entire distance between first and last store twice
    // imagine being at the parking spot
    // go left to the left most store (d = parkingspot - leftmost)
    // then travel right to the right most store (d = parkingspot - leftmost + rightmost - leftmost)
    // then travel back to the car (d = rightmost - parkingspot + parking spot - leftmost + rightmost - leftmost)
    // d = 2 rightmost - 2 leftmost
    int minimal_walking_distance = (max_store_distance - min_store_distance) * 2;
    cout << minimal_walking_distance << endl;
  }
}
