#include <iostream>
#include <string>

using namespace std;

int main() {
  int num_cases;
  cin >> num_cases;

  for (int i = 0; i < num_cases; i++) {
    string problem;
    cin >> problem;
    if (problem == "P=NP") {
      cout << "skipped" << endl;
    } else {
      int idx = 0;
      string a = "";

      for (idx = 0; idx < problem.length(); idx++) {
        if (problem[idx] == '+') {
          idx++;
          break;
        } else {
          a += problem[idx];
        }
      }
      string b = "";
      for (idx = idx; idx < problem.length(); idx++) {
        b += problem[idx];
      }
      int sum = stoi(a) + stoi(b);
      cout << sum << endl;
    }
  }
}