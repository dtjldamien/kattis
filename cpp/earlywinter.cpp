#include <iostream>
#include <string>

using namespace std;

int main() {
  int n;    // past n years
  int d_m;  // num_days btw end of summer and first snow for curr year
  cin >> n >> d_m;

  int d_i;  // num_days btw end of summer and first snow for i_th year
  for (int i = 0; i < n; i++) {
    cin >> d_i;
    if (d_m < d_i) {
      continue;
    } else if (d_m >= d_i) {
      cout << "It hadn't snowed this early in " << i << " years!" << endl;
      return 0;
    }
  }
  cout << "It had never snowed this early!" << endl;
}