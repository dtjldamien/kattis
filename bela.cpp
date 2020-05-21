#include <iostream>

using namespace std;

int CalculateDominantSuitValue(char card) {
  switch (card) {
    case 'A':
      return 11;
    case 'K':
      return 4;
    case 'Q':
      return 3;
    case 'J':
      return 20;
    case 'T':
      return 10;
    case '9':
      return 14;
    case '8':
      return 0;
    case '7':
      return 0;
  }
  return 0;  // stub
}

int CalculateNonDominantSuitValue(char card) {
  switch (card) {
    case 'A':
      return 11;
    case 'K':
      return 4;
    case 'Q':
      return 3;
    case 'J':
      return 2;
    case 'T':
      return 10;
    case '9':
      return 0;
    case '8':
      return 0;
    case '7':
      return 0;
  }
  return 0;  // stub
}

int main() {
  // two three digit numbers
  int num_hands;
  char dominant_suit;

  // take in input
  cin >> num_hands;
  cin >> dominant_suit;

  // instantiate hands
  char card;
  char suit;
  int sum = 0;

  // while there is input
  while (cin >> card && cin >> suit) {
    if (suit == dominant_suit) {
      sum += CalculateDominantSuitValue(card);
    } else {
      sum += CalculateNonDominantSuitValue(card);
    }
  }

  // output
  cout << sum << endl;
}
