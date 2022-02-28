#include <iostream>
#include <math.h>

using namespace std;

int main() {
    int pegLength, holeRadius;
    cin >> pegLength >> holeRadius;
    
    // get diagonal of peg
    double pegDiagonal = sqrt(pow(pegLength, 2) + pow(pegLength, 2));

    // check if peg is small enough to fit hole
    if (pegDiagonal < 2 * holeRadius) {
        cout << "fits" << endl;
    } else {
        cout << "nope" << endl;
    }
    return 0;
}
