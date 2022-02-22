#include <iostream>

using namespace std;

int main() {
  // look up the maxmium total weight it can haul including weight of truck
  // total weight of trailer and goods should not exceed 90% of towing capcity
  int gcvwr; // max total weight it can haul in lbs
  int truckWeight; // weight of truck
  int numItems; // number of items to bring
  cin >> gcvwr >> truckWeight >> numItems;
  
  // take in weight of the items to bring
  int totalItemWeight = 0;
  for (int i = 0; i < numItems; i++) {
    int itemWeight;
    cin >> itemWeight;
    totalItemWeight += itemWeight;
  }

  // get remaining towing capcity
  int remainingCapacity = gcvwr - truckWeight;
  int maxTrailerWeight = remainingCapacity * 0.9 - totalItemWeight;

  cout << maxTrailerWeight << endl;

  return 0;
}
