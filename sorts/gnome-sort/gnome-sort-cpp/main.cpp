#include <iostream>
#include <cstdlib>

using namespace std;

const int ARRAY_SIZE = 20;

void dwarfSort(int array []){
    int i = 1;
    while(i < ARRAY_SIZE){
        if(i==0){
            i=1;
        }
        if(array[i-1] <= array[i]){
            i++;
        }else{
         long tmp = array[i-1];
            array[i-1] = array[i];
            array[i] = tmp;
            i--;
        }
    }
}

void printArray(int array []){
    for (int i = 0; i < ARRAY_SIZE; i++) {
        cout << array[i] << " ";
    }
    cout << endl;
}

int main() {
    int *array = new int[ARRAY_SIZE];
    for (int i = 0; i < ARRAY_SIZE; i++) {
        array[i] = rand() % 100 + 1;
    }

    printArray(array);
    dwarfSort(array);
    printArray(array);
    return 0;
}



