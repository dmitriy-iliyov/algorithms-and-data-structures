def gnome_opt(array):
    i, j, size = 1, 2, len(array)
    while i < size:
        if array[i - 1] <= array[i]:
            i, j = j, j + 1
        else:
            array[i - 1], array[i] = array[i], array[i - 1]
            i -= 1
            if i == 0:
                i, j = j, j + 1
    return array
