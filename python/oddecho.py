n = int(input())
# output every n-th input
for i in range(0, n):
    if i % 2 == 0:
        print(input())
    else:
        input()
        