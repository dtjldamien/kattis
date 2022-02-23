#include <iostream>

using namespace std;

int main() {
    int n; // number of requests
    cin >> n;
    std::cin.clear();
    // volume control is at 7
    // cannot go below 0 and cannot go above 10
    int volume = 7;

    // read in requests, and update volume
    // "Skru op!" to increase volume
    // "Skru ned!" to decrease volume
    for (int i = 0; i <= n; i++) {
        string request;
        getline(cin, request);

        if (request == "Skru op!" && volume < 10) {
            volume++;
        } else if (request == "Skru ned!" && volume > 0) {
            volume--;
        }
    }
    // output the position of volume after n requests
    cout << volume << endl;
    return 0;
}
