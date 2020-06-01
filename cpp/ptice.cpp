#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  int n;  // num questions
  string answer;
  cin >> n >> answer;

  char adrian[3] = {'A', 'B', 'C'};
  char bruno[4] = {'B', 'A', 'B', 'C'};
  char goran[6] = {'C', 'C', 'A', 'A', 'B', 'B'};

  int adrian_score = 0;
  int bruno_score = 0;
  int goran_score = 0;

  for (int i = 0; i < n; i++) {
    if (answer[i] == adrian[i % 3]) {
      adrian_score++;
    }
    if (answer[i] == bruno[i % 4]) {
      bruno_score++;
    }
    if (answer[i] == goran[i % 6]) {
      goran_score++;
    }
  }

  int max_score = max(adrian_score, bruno_score);
  max_score = max(max_score, goran_score);

  cout << max_score << endl;
  if (adrian_score == max_score) {
    cout << "Adrian" << endl;
  }
  if (bruno_score == max_score) {
    cout << "Bruno" << endl;
  }
  if (goran_score == max_score) {
    cout << "Goran" << endl;
  }
}