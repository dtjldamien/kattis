tower = input()
# find the first index of the first '('
num_left_bars = tower.find('(')
num_right_bars = len(tower) - num_left_bars - 2

if num_left_bars == num_right_bars:
    print("correct")
else:
    print("fix")
    