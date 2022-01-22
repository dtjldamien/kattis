# list of numbers
# input().split() returns a list of strings, delimiter of whitespace
# map(int, input().split()) returns a list of integers, typecast string to int
nums = map(int, input().split())
print(sum(nums))
