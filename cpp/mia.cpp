#include <iostream>
#include <string>

using namespace std;

int calculate_score(int num1, int num2) {
  // sort such that the highest number comest first
  if (num1 < num2) {
    swap(num1, num2);
  }
  if (num1 == 2 && num2 == 1) {
    return 1000;
  } else if (num1 == num2) {
    // doubles
    switch (num1) {
      case 1:
        return 110;
      case 2:
        return 220;
      case 3:
        return 330;
      case 4:
        return 440;
      case 5:
        return 550;
      case 6:
        return 660;
    }
  } else {
    return stoi(to_string(num1) + to_string(num2));
  }
}

int main() {
  int s0;
  int s1;
  int r0;
  int r1;
  cin >> s0;
  cin >> s1;
  cin >> r0;
  cin >> r1;

  while (s0 + s1 + r0 + r1 != 0) {
    int score1 = calculate_score(s0, s1);
    int score2 = calculate_score(r0, r1);
    if (score1 > score2) {
      cout << "Player 1 wins." << endl;
    } else if (score1 < score2) {
      cout << "Player 2 wins." << endl;
    } else {
      cout << "Tie." << endl;
    }
    cin >> s0;
    cin >> s1;
    cin >> r0;
    cin >> r1;
  }
}
