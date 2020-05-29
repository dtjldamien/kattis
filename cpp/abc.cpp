#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  int arr[3];
  for (int i = 0; i < 3; i++) {
    cin >> arr[i];
  }
  sort(arr, arr + 3);
  string order;
  cin >> order;
  for (int i = 0; i < 3; i++) {
    cout << arr[order[i] - 65] << ' ';
  }
  cout << endl;
}