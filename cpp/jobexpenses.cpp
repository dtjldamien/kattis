#include <iostream>

using namespace std;

int main() {
  int n;  // number of integers
  cin >> n;
  
  int k; // curr integer
  int total_expenses = 0;
  for (int i = 0; i < n; i++) {
    cin >> k;
    if (k < 0) {
      total_expenses += abs(k);
    }
  }
  cout << total_expenses << endl;
}