#include <iostream>
#include <vector>

using namespace std;

string convertToBinary(char digit) {
    string binary = "";
    int number = digit - '0';
    while (number > 0) {
        binary = (number % 2 == 0 ? "." : "*") + binary;
        number /= 2;
    }
    while (binary.length() < 4) {
        binary = "." + binary;
    }
    return binary;
}

int main() {
    string time;
    getline(cin, time);

    // create 2d matrix watch with 4 rows and 9 columns of empty spaces
    vector<vector<char> > watch;
    for (int i = 0; i < 4; i++) {
        vector<char> row;
        for (int j = 0; j < 9; j++) {
            row.push_back(' ');
        }
        watch.push_back(row);
    }

    string firstCol = convertToBinary(time[0]);
    for (int i = 0; i < 4; i++) {
        watch[i][0] = firstCol[i];
    }

    string secondCol = convertToBinary(time[1]);
    for (int i = 0; i < 4; i++) {
        watch[i][2] = secondCol[i];
    }

    string thirdCol = convertToBinary(time[2]);
    for (int i = 0; i < 4; i++) {
        watch[i][6] = thirdCol[i];
    }

    string fourthCol = convertToBinary(time[3]);
    for (int i = 0; i < 4; i++) {
        watch[i][8] = fourthCol[i];
    }

    // print watch
    for (int i = 0; i < 4; i++) {
        vector<char> row;
        for (int j = 0; j < 9; j++) {
            cout << watch[i][j];
        }
        cout << endl;
    }

    return 0;
}
