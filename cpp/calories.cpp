#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

vector<string> getRecord(string record) {
    vector<string> result;
    string delimiter = " ";
    size_t pos = 0;
    string token;
    while ((pos = record.find(delimiter)) != std::string::npos) {
        token = record.substr(0, pos);
        result.push_back(token);
        record.erase(0, pos + delimiter.length());
    }
    result.push_back(record);
    return result;
}

int main() {
    // take in test case
    string line;
    string nextLine;
    const int calorieConversion[] = {9, 4, 4, 4, 7};
    double totalCalories = 0;
    double totalFatCalories = 0;
    while (true) {
        getline(cin, line);
        if (line == "-") {
            int percentageFromFat = round(totalFatCalories * 100.0 / totalCalories);
            cout << percentageFromFat << "%" << endl;
            getline(cin, nextLine);
            if (nextLine == "-") {
                break;
            } else {
                line = nextLine;
                totalCalories = 0;
                totalFatCalories = 0;
            }
        }
        vector<string> record = getRecord(line);
        double currCalories = 0;
        double currFatCalories = 0;
        double currPercentageUnaccounted = 0;
        double currPercentageFatUnaccounted = 0;
        if (record[0].back() == 'g') {
            currFatCalories = stod(record[0].substr(0, record[0].length() - 1)) * calorieConversion[0];
            currCalories += currFatCalories;
        } else if (record[0].back() == 'C') {
            currFatCalories = stod(record[0].substr(0, record[0].length() - 1));
            currCalories += currFatCalories;
        } else if (record[0].back() == '%') {
            currPercentageFatUnaccounted = stod(record[0].substr(0, record[0].size() - 1));
            currPercentageUnaccounted += currPercentageFatUnaccounted;
        }
        for (int i = 1; i < record.size(); i++) {
            if (record[i].back() == 'g') {
                currCalories += stod(record[i].substr(0, record[i].size() - 1)) * calorieConversion[i];
            } else if (record[i].back() == 'C') {
                currCalories += stod(record[i].substr(0, record[i].size() - 1));
            }
        }
        for (int i = 1; i < record.size(); i++) {
            if (record[i].back() == '%') {
                currPercentageUnaccounted += stod(record[i].substr(0, record[i].size() - 1));
            }
        }
        currCalories = 100.0 * currCalories / (100 - currPercentageUnaccounted);
        currFatCalories += currPercentageFatUnaccounted / 100.0 * currCalories;
        totalFatCalories += currFatCalories;
        totalCalories += currCalories;
    }
    return 0;
}
