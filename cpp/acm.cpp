#include <iostream>
#include <tuple>
#include <vector>

using namespace std;

int main() {
  vector<tuple<int, char, string>> entries;

  while (true) {
    int m;  // number of minutes
    cin >> m;
    if (m == -1) {
      break;
    }
    char problem;
    string result;
    cin >> problem >> result;

    entries.push_back(make_tuple(m, problem, result));
  }

  int num_problems_solved = 0;
  int total_time_measure = 0;
  bool solved[26] = {0};  // initialise false boolean array

  // need to do backwards
  for (int i = entries.size() - 1; i >= 0; i--) {
    int m;
    char problem;
    string result;
    tie(m, problem, result) = entries[i];
    if (result == "right") {
      num_problems_solved++;
      total_time_measure += m;
      // problems are only upper case letters
      solved[problem - 'A'] = true;
    } else {
      // penalty only added to solved problems
      if (solved[problem - 'A'] == true) {
        total_time_measure += 20;
      }
    }
  }
  cout << num_problems_solved << " " << total_time_measure << endl;
}