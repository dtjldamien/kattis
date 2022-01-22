code = int(input())
swapped_code = 0
# Swap the digits
while code > 0:
    digit = code % 10
    swapped_code = swapped_code * 10 + digit
    code = code // 10 # floor division
print(swapped_code)
