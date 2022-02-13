def binary_search(arr, start_index, end_index, target):
    if end_index >= start_index:
        mid_index = (start_index + end_index) // 2
        if arr[mid_index] == target:
            return mid_index
        elif arr[mid_index] > target:
            return binary_search(arr, start_index, mid_index - 1, target)
        else:
            return binary_search(arr, mid_index + 1, end_index, target)
    else:
        # return next largest can
        return start_index

# get the number of paint sizes offered by the shop and the number of colours Joe needs
n, m = map(int, input().split())

# the size of a can offered by the paint shop, in microlitres
can_sizes_list = []
for i in range(n):
    can_sizes_list.append(int(input()))

# sort the paint sizes in ascending order
can_sizes_list.sort()

# number of microlitres that Joe needs of a given colour
amount_needed_list = []
for i in range(m):
    amount_needed_list.append(int(input()))

# Joe does not want to buy more than one can of any given colour
paint_wasted = 0
for amount_needed in amount_needed_list:
    # use binary search to find the smallest can size that can satisfy the amount needed
    can_size = can_sizes_list[binary_search(can_sizes_list, 0, len(can_sizes_list), amount_needed)]
    paint_wasted += can_size - amount_needed

print(paint_wasted)
