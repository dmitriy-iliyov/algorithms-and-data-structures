import random
import gnome_sort as gs

array = []
for i in range(10):
    array.append(random.randint(0, 100))
print(array)
gs.gnome_opt(array)
print(array)