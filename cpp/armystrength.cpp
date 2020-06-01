#include <iostream>
#include <queue>

using namespace std;

int main() {
  int t;  // num test case
  cin >> t;

  for (int i = 0; i < t; i++) {
    int num_g;  // num monster in Godzilla's army
    int num_m;  // num monsters in MechaGodzilla's army
    cin >> num_g >> num_m;

    // create min heap, so weakest will pop first
    priority_queue<int, vector<int>, greater<int>> g_monsters;
    priority_queue<int, vector<int>, greater<int>> m_monsters;
    int curr_monster_strength;

    for (int j = 0; j < num_g; j++) {
      cin >> curr_monster_strength;
      g_monsters.push(curr_monster_strength);
    }

    for (int j = 0; j < num_m; j++) {
      cin >> curr_monster_strength;
      m_monsters.push(curr_monster_strength);
    }

    while (!g_monsters.empty() && !m_monsters.empty()) {
      if (g_monsters.top() < m_monsters.top()) {
        g_monsters.pop();
      } else {  // including g == m
        m_monsters.pop();
      }
    }

    if (g_monsters.empty()) {
      cout << "MechaGodzilla" << endl;
    } else if (m_monsters.empty()) {
      cout << "Godzilla" << endl;
    } else {
      cout << "uncertain" << endl;
    }
  }
}