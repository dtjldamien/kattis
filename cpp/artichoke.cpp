#include <cmath>
#include <iostream>

using namespace std;

int main() {
  int p;
  int a;
  int b;
  int c;
  int d;
  int n;
  cin >> p >> a >> b >> c >> d >> n;

  // price(k)=p⋅(sin(a⋅k+b)+cos(c⋅k+d)+2)
  double min_price = p * (sin(a * 1 + b) + cos(c * 1 + d) + 2);
  double max_price = p * (sin(a * 1 + b) + cos(c * 1 + d) + 2);
  double max_decline = 0;
  double curr_price;

  for (int k = 2; k <= n; k++) {
    curr_price = p * (sin(a * k + b) + cos(c * k + d) + 2);

    if (curr_price > max_price) {
      // the decline resets
      max_price = curr_price;
      min_price = curr_price;
    }
    if (curr_price < min_price) {
      min_price = curr_price;
    }
    if (max_price - min_price > max_decline) {
      max_decline = max_price - min_price;
    }
  }

  cout.precision(9);
  cout << max_decline << endl;
}