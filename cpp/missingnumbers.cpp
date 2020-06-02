#include <iostream>
#include <vector>

using namespace std;

int main() {
  int n;
  cin >> n;

  vector<bool> is_recited;
  is_recited.resize(201);
  for (int i = 0; i < n - 1; i++) {
    int idx;
    cin >> idx;
    is_recited[idx] = true;
  }

  int last_num;
  cin >> last_num;
  is_recited[last_num] = true;

  bool has_missing = false;
  for (int i = 1; i <= last_num; i++) {
    if (!is_recited[i]) {
      cout << i << endl;
      has_missing = true;
    }
  }

  if (!has_missing) {
      cout << "good job" << endl;
  }
}