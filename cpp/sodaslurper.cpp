#include <iostream>

using namespace std;

int main() {
  int e; // number of empty soda bottles in Tim's possession at the start of the day
  int f; // number of empty soda bottles found during the day
  int c; // number of empty bottles required to buy a new soda
  cin >> e;
  cin >> f;
  cin >> c;

  int num_empty_bottles = e + f;
  int sodas_drank = 0;
  while (num_empty_bottles >= c) {
    sodas_drank += (num_empty_bottles / c);
    num_empty_bottles = (num_empty_bottles % c) + num_empty_bottles / c;
  }
  cout << sodas_drank << endl;
}