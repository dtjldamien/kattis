#include <bits/stdc++.h>

#include <iostream>

using namespace std;

int main() {
  int N;  // 3 <= N <= 200 000
  int t;  // 1 <= t <= 7
  cin >> N;
  cin >> t;
  int A[N];
  int sum_A = 0;
  int curr_num;
  int sum_even = 0;
  string case6 = "";
  char curr_char;
  for (int i = 0; i < N; i++) {
    cin >> curr_num;
    A[i] = curr_num;
    sum_A += curr_num;
    if (curr_num % 2 == 0) {
      sum_even += curr_num;
    }
    curr_char = 'a' + curr_num % 26;
    case6 += curr_char;
  }
  switch (t) {
    case 1:
      cout << 7 << endl;
      break;
    case 2:
      if (A[0] > A[1]) {
        cout << "Bigger" << endl;
      } else if (A[0] == A[1]) {
        cout << "Equal" << endl;
      } else {
        cout << "Smaller" << endl;
      }
      break;
    case 3: {
      int three_integers[3] = {A[0], A[1], A[2]};
      sort(three_integers, three_integers + 3);
      cout << three_integers[1] << endl;
    } break;
    case 4:
      cout << sum_A << endl;
      break;
    case 5:
      cout << sum_even << endl;
      break;
    case 6:
      cout << case6 << endl;
      break;
    case 7:
      int idx = 0;
      bool visited[N];
      while (true) {
        if (A[idx] < 0 || A[idx] >= N) {
          cout << "Out" << endl;
          break;
        } else if (idx == N - 1) {
          cout << "Done" << endl;
          break;
        } else {
          if (visited[idx] == true) {
            cout << "Cyclic" << endl;
            break;
          }
          visited[idx] = true;
          idx = A[idx];
        }
      }
      break;
  }
}