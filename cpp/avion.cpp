#include <iostream>

using namespace std;

int main() {
  bool is_found = false;
  string curr_blimp;
  for (int i = 1; i <= 5; i++) {
    cin >> curr_blimp;
    if (curr_blimp.find("FBI") != string::npos) {
      // found
      is_found = true;
      cout << i << " ";
    }
  }
  if (!is_found) {
    cout << "HE GOT AWAY!" << endl;
  }
}