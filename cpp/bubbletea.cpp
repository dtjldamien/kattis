#include <iostream>

using namespace std;

int main() {
  int shares = 0;
  double avg_cost = 0;
  double curr_price = 0;
  while (true) {
    string event;
    cin >> event;
    if (event == "buy") {
      int shares_bought;
      cin >> shares_bought >> curr_price;
      avg_cost = (shares * avg_cost + shares_bought * curr_price) /
                 (shares + shares_bought);
      shares += shares_bought;
    } else if (event == "sell") {
      int shares_sold;
      cin >> shares_sold >> curr_price;
      avg_cost = (shares * avg_cost - shares_sold * curr_price) /
                 (shares - shares_sold);
      shares -= shares_sold;
    } else if (event == "split") {
      int multiplier;
      cin >> multiplier;
      shares *= multiplier;
      avg_cost /= multiplier;
    } else if (event == "merge") {
      int multiplier;
      cin >> multiplier;
      shares /= multiplier;
      avg_cost *= multiplier;
    } else if (event == "die") {
      cin >> curr_price;
      break;
    }
  }
  int after_tax = shares * (curr_price - (curr_price - avg_cost) * .3);
  cout << after_tax << endl;
}