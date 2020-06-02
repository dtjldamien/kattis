#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int n; // number of participants 1 <= n <= 200
    int b; // budget 1 <= b <= 500000
    int h; // number of hotels to consider 1 <= h <= 18
    int w; // number of weeks to choose between 1 <= w <= 13
    cin >> n >> b >> h >> w;

    int min_cost = 201 * 10001;
    for (int i = 0; i < h; i++) {
        int p; // price for one person staying the weekend at the hotel
        cin >> p;

        for (int j = 0; j < w; j++) {
            int a; // number of available beds for this weekend
            cin >> a;

            if (a >= n) {
                min_cost = min(min_cost, p * n);
            }
        }
    }

    if (min_cost <= b) {
        cout << min_cost << endl;
    } else {
        cout << "stay home" << endl;
    }
}