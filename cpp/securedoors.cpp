#include <iostream>
#include <unordered_set>

using namespace std;

int main() {
    unordered_set <string> accessLog;
    string input;
    getline(cin, input);
    int n = stoi(input);

    string delimiter = " ";

    for (int i = 0; i < n; i++) {
        getline(cin, input);

        string direction = input.substr(0, input.find(delimiter));
        string name = input.substr(input.find(delimiter) + 1);
        if (direction == "entry") {
            // check if employee is in the access log
            if (accessLog.find(name) != accessLog.end()) {
                cout << name << " entered (ANOMALY)" << endl;
            } else {
                accessLog.insert(name);
                cout << name << " entered" << endl;
            }
        } else {
            // check if employee is in the access log
            if (accessLog.find(name) != accessLog.end()) {
                accessLog.erase(name);
                cout << name << " exited" << endl;
            } else {
                cout << name << " exited (ANOMALY)" << endl;
            }
        }
    }
    return 0;
}
