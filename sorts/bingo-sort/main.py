import random
import bingo_sort as bs

array = []
for i in range(10):
    array.append(random.randint(0, 100))
print(array)
bs.bingo_sort(array)
print(array)
