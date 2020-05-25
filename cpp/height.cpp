#include <iostream>

using namespace std;

int main() {
  int p;  // number of data sets
  cin >> p;
  for (int i = 0; i < p; i++) {
    int k;  // data set number
    cin >> k;
    int students[20];
    for (int j = 0; j < 20; j++) {
      cin >> students[j];
    }
    // insertion sort
    int h;
    int key;
    int num_steps_taken_back = 0;
    for (int j = 1; j < 20; j++) {
      key = students[j];
      h = j - 1;
      while (h >= 0 && students[h] > key) {
        students[h + 1] = students[h];
        h = h - 1;
        num_steps_taken_back++;
      }
      students[h + 1] = key;
    }
    cout << k << " " << num_steps_taken_back << endl;
  }
}