#include <iostream>

using namespace std;

int main() {
    int n, firstNumber;
    cin >> n >> firstNumber;
    int count = 1;
    int currentNumber;
    // read n inputs
    while (count < n) {
        count++;
        cin >> currentNumber;
        if (currentNumber % firstNumber == 0) {
            cout << currentNumber << endl;
            cin >> firstNumber;
            count++;
        }
    }
    return 0;
}
