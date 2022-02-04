# get input, number of blocks available
num_blocks = int(input())

# top layer consists of a single block (1**2)
# second layer consists of 9 blocks (1+2)**2
# third layer consists of 25 block (1+2+2)**2
# each layer requires (2n - 1)^2 blocks 
height = 0
layer_length = 1

while True:
    # check if we have enough blocks for next layer
    blocks_required = (2 * (height + 1) - 1) ** 2
    if (num_blocks < blocks_required):
        break
    else:
        height += 1
        num_blocks -= blocks_required

print(height)
