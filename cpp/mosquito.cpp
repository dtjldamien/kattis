#include <iostream>

using namespace std;

int main() {
  int m;  // num mosquitoes
  int p;  // num pupae
  int l;  // num larvae
  int e;  // num eggs laid by one mosquito
  int r;  // survival rate of larvae
  int s;  // surivval rate of pupae
  int n;  // number of weeks

  while (cin >> m) {
    cin >> p >> l >> e >> r >> s >> n;

    for (int i = 0; i < n; i++) {
        int new_larvae = m * e;
        int new_pupae = l / r;
        int new_mosquitoes = p / s;

        l = new_larvae;
        p = new_pupae;
        m = new_mosquitoes;
    }

    cout << m << endl;
  }
}