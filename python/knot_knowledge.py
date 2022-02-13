num_knots = int(input())

# hash set of knots that sonja needs to learn
knots = set()
knots_input = input().split(" ")
for i in range(len(knots_input)):
    knots.add(knots_input[i])

# hash set of knots that sonja already knows
known_knots = set()
known_knots_input = input().split(" ")
for i in range(len(known_knots_input)):
    known_knots.add(known_knots_input[i])

# set difference
unknown_knots = knots - known_knots
print(unknown_knots.pop())
