#include <iostream>
#include <string>

using namespace std;

int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
      string curr_worker;
      cin >> curr_worker;
      cout << curr_worker.length() << endl;
  }
}