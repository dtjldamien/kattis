#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
  while (true) {
    int k;  // number of courses Freddie chosen
    cin >> k;
    if (k == 0) {
      break;
    }
    int m;  // number of categories
    cin >> m;

    vector<int> courses_selected;
    for (int i = 0; i < k; i++) {
      int course;
      cin >> course;
      courses_selected.push_back(course);
    }

    bool requirements_met = true;
    for (int i = 0; i < m; i++) {
      int c;  // number of courses in this category
      int r;  // minimum number of courses from the category that must be taken
      cin >> c >> r;
      int counter = 0;

      for (int j = 0; j < c; j++) {
        int curr_course;
        cin >> curr_course;
        if (count(courses_selected.begin(), courses_selected.end(),
                  curr_course)) {
          counter++;
        }
      }

      if (counter < r) {
          requirements_met = false;
      }
    }

    if (requirements_met) {
        cout << "yes" << endl;
    } else {
        cout << "no" << endl;
    }
  }
}