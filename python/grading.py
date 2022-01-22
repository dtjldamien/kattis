a, b, c, d, e = map(int, input().split())
current_score = int(input())

if current_score >= a:
    print("A")
elif current_score >= b:
    print("B")
elif current_score >= c:
    print("C")
elif current_score >= d:
    print("D")
elif current_score >= e:
    print("E")
else:
    print("F")
