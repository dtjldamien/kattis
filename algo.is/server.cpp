// https://open.kattis.com/problems/server
#include <iostream>
#include <vector>

using namespace std;

int main() {
  int n;  // number of tasks
  cin >> n;
  int t;  // server can run tasks for at most T minutes
  cin >> t;
  vector<int> task_durations;
  int task_duration;
  for (int i = 0; i < n; i++) {
    cin >> task_duration;
    task_durations.push_back(task_duration);
  }
  int num_tasks_completed = 0;
  for (int i = 0; i < n; i++) {
    if (t - task_durations[i] < 0) {
      break;
    } else {
      t -= task_durations[i];
      num_tasks_completed++;
    }
  }
  cout << num_tasks_completed  << endl;
}