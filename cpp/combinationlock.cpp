#include <cmath>
#include <iostream>

using namespace std;

int main() {
  while (true) {
    int curr_number;
    int first_number;
    int second_number;
    int third_number;
    cin >> curr_number >> first_number >> second_number >> third_number;
    if (curr_number + first_number + second_number + third_number == 0) {
      break;
    }
    // int degree_per_mark = 9;
    // 360/40 = 9
    int num_degrees_turned = 720;  // clockwise 2 full turns
    
    // corner case, use >= in case previous number and next number is the same
    // to first number from current number
    if (curr_number >= first_number) {
      num_degrees_turned += (curr_number - first_number) * 9;
    } else {
      num_degrees_turned += (40 + curr_number - first_number) * 9;
    }

    // to second number from first number
    num_degrees_turned += 360;  // counter-clockwise 1 full turn
    if (second_number >= first_number) {
      num_degrees_turned += (second_number - first_number) * 9;
    } else {
      num_degrees_turned += (40 + second_number - first_number) * 9;
    }

    // to third number from second number
    if (second_number >= third_number) {
      num_degrees_turned += (second_number - third_number) * 9;
    } else {
      num_degrees_turned += (40 + second_number - third_number) * 9;
    }

    cout << num_degrees_turned << endl;
  }
}