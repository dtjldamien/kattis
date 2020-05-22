#include <bits/stdc++.h>

#include <iostream>
#include <iterator>
#include <map>

using namespace std;

int main() {
    // number of test cases
    int num_test_cases;
    cin >> num_test_cases;

    for (int i = 0; i < num_test_cases; i++) {
        int num_candidates;
        cin >> num_candidates;
        double votes [num_candidates];
        double total_votes = 0;
        double winning_votes = 0;
        int winner = 0;
        bool isTie = true;
        for (int j = 0; j < num_candidates; j++) {
            double num_votes;
            cin >> num_votes;
            votes [j] = num_votes;
            total_votes += num_votes;
            if (num_votes > winning_votes) {
                winning_votes = num_votes;
                winner = j + 1;
                isTie = false;
            } else if (num_votes == winning_votes) {
                isTie = true;
            }
        }
        if (isTie) {
            cout << "no winner" << endl;
        } else {
            if (winning_votes / total_votes > 0.5) {
                cout << "majority winner " << winner << endl;
            } else {
                cout << "minority winner " << winner << endl;
            }
        }
    }
}