#include <bits/stdc++.h>

#include <iostream>

using namespace std;

int main() {
  int num_test_cases;
  cin >> num_test_cases;
  for (int i = 0; i < num_test_cases; i++) {
    // get string
    string line;
    cin >> line;
    int square_size = sqrt(line.size());
    char square[square_size][square_size];
    int index = 0;

    // store string in a square, 2d array
    for (int row = 0; row < square_size; row++) {
      for (int col = 0; col < square_size; col++) {
        square[row][col] = line[index];
        index++;
      }
    }

    // decode the square
    for (int col = square_size - 1; col >= 0; col--) {
      for (int row = 0; row < square_size; row++) {
        cout << square[row][col];
      }
    }
    cout << endl;
  }
}
