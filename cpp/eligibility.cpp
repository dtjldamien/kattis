#include <iostream>
#include <string>

using namespace std;

int main() {
  int num_cases;
  cin >> num_cases;
  for (int i = 0; i < num_cases; i++) {
    string name;
    string date_began_post_secondary_studies;
    string date_of_birth;
    int num_courses_completed;

    cin >> name >> date_began_post_secondary_studies >> date_of_birth >> num_courses_completed;

    int year_post_secondary_studies =
        stoi(date_began_post_secondary_studies.substr(0, 4));
    if (year_post_secondary_studies >= 2010) {
      cout << name << " eligible" << endl;
    } else {
      int birth_year = stoi(date_of_birth.substr(0, 4));
      if (birth_year >= 1991) {
        cout << name << " eligible" << endl;
      } else {
        if (num_courses_completed >= 41) {
          cout << name << " ineligible" << endl;
        } else {
          cout << name << " coach petitions" << endl;
        }
      }
    }
  }
}