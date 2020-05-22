#include <bits/stdc++.h>

#include <iostream>
#include <iterator>
#include <map>

using namespace std;

int main() {
  int line_size;
  cin >> line_size;
  map<int, int> between;
  int num_between_jimmy;
  between.insert(pair<int, int>(-1, 1));
  for (int i = 2; i <= line_size; i++) {
    cin >> num_between_jimmy;
    between.insert(pair<int, int>(num_between_jimmy, i));
  }
  for (int i = -1; i < line_size - 1; i++) {
    // -> second prints the value, -: first prints the key
    cout << between.find(i)->second << " ";
  }
}