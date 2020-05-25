#include <bits/stdc++.h>

#include <iostream>

using namespace std;

int main() {
  // works for averages hard too
  int t;  // number of data sets
  cin >> t;
  for (int i = 0; i < t; i++) {
    int n_cs;  // number of cs students
    int n_e;   // number of econs students
    cin >> n_cs;
    cin >> n_e;
    double cs_iqs[n_cs];
    double total_cs_iq = 0;
    double curr_cs_iq;
    for (int j = 0; j < n_cs; j++) {
      cin >> curr_cs_iq;
      cs_iqs[j] = curr_cs_iq;
      total_cs_iq += curr_cs_iq;
    }
    double avg_cs_iq = total_cs_iq / n_cs;
    sort(cs_iqs, cs_iqs + n_cs);
    double total_e_iq = 0;
    double curr_e_iq;
    for (int j = 0; j < n_e; j++) {
      cin >> curr_e_iq;
      total_e_iq += curr_e_iq;
    }
    double avg_econs_iq = total_e_iq / n_e;
    int n_true = 0;
    for (int j = 0; j < n_cs; j++) {
      if (cs_iqs[j] > avg_econs_iq && cs_iqs[j] < avg_cs_iq) {
        n_true++;
      }
    }
    cout << n_true << endl;
  }
}