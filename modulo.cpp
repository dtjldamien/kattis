#include <bits/stdc++.h>

#include <iostream>

using namespace std;

int main() {
  set<int> distinct_numbers;
  for (int i = 0; i < 10; i++) {
    int number;
    cin >> number;
    number %= 42;
    distinct_numbers.insert(number);
  }
  cout << distinct_numbers.size() << endl;
}
