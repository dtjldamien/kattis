#include <iostream>

using namespace std;

int main() {
  while (true) {
    int w;  // width of the room
    int l;  // length of the room
    cin >> w >> l;

    if (w + l == 0) {
      break;
    }

    int n;
    cin >> n;
    int think_x = 0;
    int think_y = 0;

    int actual_x = 0;
    int actual_y = 0;

    for (int i = 0; i < n; i++) {
      char direction;
      int steps;
      cin >> direction >> steps;
      if (direction == 'u') {
        think_y += steps;
        actual_y += steps;
        if (actual_y >= l) {
          actual_y = l - 1;
        }
      } else if (direction == 'd') {
        think_y -= steps;
        actual_y -= steps;
        if (actual_y < 0) {
          actual_y = 0;
        }
      } else if (direction == 'l') {
        think_x -= steps;
        actual_x -= steps;
        if (actual_x < 0) {
          actual_x = 0;
        }
      } else if (direction == 'r') {
        think_x += steps;
        actual_x += steps;
        if (actual_x >= w) {
          actual_x = w - 1;
        }
      }
    }

    cout << "Robot thinks " << think_x << " " << think_y << endl;
    cout << "Actually at " << actual_x << " " << actual_y << endl << endl;
  }
}