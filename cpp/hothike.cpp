#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
  int n;  // length of vacation in days
  cin >> n;

  vector<int> temps;
  int temp;
  for (int i = 0; i < n; i++) {
    cin >> temp;
    temps.push_back(temp);
  }

  int max_temp = 41;  // -20<= tt <= 40
  int day_to_start = 0;
  for (int i = 0; i < n - 2; i++) {
    if (max(temps[i], temps[i + 2]) < max_temp) {
      day_to_start = i + 1;
      max_temp = max(temps[i], temps[i + 2]);
    }
  }

  cout << day_to_start << " " << max_temp << endl;
}