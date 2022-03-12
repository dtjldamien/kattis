#include <algorithm>
#include <iostream>
#include <map>
#include <string>

using namespace std;

int main() {
    map<char, string> dict;
    dict['a'] = "@";
    dict['b'] = "8";
    dict['c'] = "(";
    dict['d'] = "|)";
    dict['e'] = "3";
    dict['f'] = "#";
    dict['g'] = "6";
    dict['h'] = "[-]";
    dict['i'] = "|";
    dict['j'] = "_|";
    dict['k'] = "|<";
    dict['l'] = "1";
    dict['m'] = "[]\\/[]";
    dict['n'] = "[]\\[]";
    dict['o'] = "0";
    dict['p'] = "|D";
    dict['q'] = "(,)";
    dict['r'] = "|Z";
    dict['s'] = "$";
    dict['t'] = "']['";
    dict['u'] = "|_|";
    dict['v'] = "\\/";
    dict['w'] = "\\/\\/";
    dict['x'] = "}{";
    dict['y'] = "`/";
    dict['z'] = "2";
    string input;
    // convert input to lowercase
    getline(cin, input);
    for(int i = 0; i < input.length(); i++) {
        input[i] = tolower(input[i]);
    }
    for (int i = 0; i < input.size(); i++) {
        if (dict.find(input[i]) != dict.end()) {
            cout << dict[input[i]];
        } else {
            cout << input[i];
        }
    }
    cout << endl;
    return 0;
}
