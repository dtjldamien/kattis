#include <iostream>

using namespace std;

int main() { 
  string arrangement;
  cin >> arrangement; 
  int num_white = 0;
  int num_black = 0;

  for (int i = 0; i < arrangement.length(); i++) {
    if (arrangement[i] == 'W') {
      num_white++;
    } else {
      num_black++;
    }
  }

  if (num_white == num_black) {
    cout << '1' << endl;
  } else {
    cout << '0' << endl;
  }
}