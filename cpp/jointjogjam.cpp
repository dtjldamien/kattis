#include <iostream>
#include <iomanip>
#include <math.h>

using namespace std;

double calcDistance(int x1, int y1, int x2, int y2) {
    return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
}

int main() {
    int xStartK, yStartK, xStartO, yStartO, xEndK, yEndK, xEndO, yEndO;
    cin >> xStartK >> yStartK >> xStartO >> yStartO >> xEndK >> yEndK >> xEndO >> yEndO;
    
    // compare max distance between Kari and Ola
    double maxDistance = calcDistance(xStartK, yStartK, xStartO, yStartO);
    maxDistance = max(maxDistance, calcDistance(xEndK, yEndK, xEndO, yEndO));

    // does not include these two cases
    // maxDistance = max(maxDistance, calcDistance(xStartK, yStartK, xEndO, yEndO));
    // maxDistance = max(maxDistance, calcDistance(xEndK, yEndK, xStartO, yStartO));

    cout << setprecision(12);
    cout << maxDistance << endl;
    return 0;
}
