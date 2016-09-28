//============================================================================
// Name        : W4A1.cpp
// Author      : Anderson Thomas
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <time.h>

using namespace std;
/*
 * Write two functions in C++:
 * 1) one that declares a large array on the stack
 * 2) and one that creates the same large array from the heap.
 *
 * Call each of the functions a large number of times (> 100k times) and
 * output the time required by each. Explain the results.
 */


/*
 * In C++, when you use the new operator to allocate memory,
 * this memory is allocated in the application’s heap segment.
*/
void heapArray(int inputArraySize){
	int *arr = new int[inputArraySize];
	delete [] arr;
}

void stackArray(int inputArraySize){
	int arr [inputArraySize];
}


int main() {
	int arraySize = 1000;
	int totalCallsToMake = 100009;

	double timeToMakeHeapArray = 0;
	for(int i = 0; i < totalCallsToMake; i++){
		clock_t begin = clock();
		heapArray(arraySize);
		clock_t end = clock();
		timeToMakeHeapArray = timeToMakeHeapArray + double(end-begin)/CLOCKS_PER_SEC;
	}
	cout << "The time to make " << totalCallsToMake << " arrays, of size " << arraySize << ", on the heap was " << timeToMakeHeapArray << endl;

	double timeToMakeStackArray = 0;
	for(int i = 0; i < totalCallsToMake; i++){
		clock_t begin = clock();
		stackArray(arraySize);
		clock_t end = clock();
		timeToMakeStackArray = timeToMakeStackArray + double(end-begin)/CLOCKS_PER_SEC;
	}
	cout << "The time to make " << totalCallsToMake << " arrays, of size " << arraySize << ", on the stack was " << timeToMakeStackArray << endl;

	return 0;
}
