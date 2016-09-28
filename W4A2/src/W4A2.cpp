//============================================================================
// Name        : W4A2.cpp
// Author      : Anderson Thomas
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <fstream>
#include <vector>
#include "HashTable.h"

using namespace std;

void personHashDatabase(vector<string> inputVector, int *inputAges, string nameToFind){
	HashTable* hashDatabase = new HashTable();
	double timeToStore = 0;
	int position = 0;
	for(auto i = inputVector.begin(); i < inputVector.end(); i++){
		int age = inputAges[position];
		position++;
		clock_t begin = clock();
		hashDatabase->store(*i, age);
		clock_t end = clock();
		timeToStore= timeToStore + double(end-begin)/CLOCKS_PER_SEC;
	}

	cout << "The time required to add 1000 people with hashing was " << timeToStore << endl;

	double timeToFind = 0;
	clock_t begin = clock();
	hashDatabase->find(nameToFind);
	clock_t end = clock();
	timeToFind = timeToFind + double(end-begin)/CLOCKS_PER_SEC;

	cout << "The time to find " << nameToFind << " in the hashed database is "<< timeToFind << endl;
	delete hashDatabase;
}

void personDatabase(vector<string> inputVector, int *inputAges, string nameToFind){
	linkedList* nonHashDatabase = new linkedList();
	double timeToStore = 0;
	int position = 0;
	for(auto i = inputVector.begin(); i < inputVector.end(); i++){
		int age = inputAges[position];
		position++;
		clock_t begin = clock();
		nonHashDatabase->add(*i, age);
		clock_t end = clock();
		timeToStore= timeToStore + double(end-begin)/CLOCKS_PER_SEC;
	}



	cout << "The time required to add 1000 people without hashing was " << timeToStore << endl;

	double timeToFind = 0;
	clock_t begin = clock();
	nonHashDatabase->find(nameToFind);
	clock_t end = clock();
	timeToFind = timeToFind + double(end-begin)/CLOCKS_PER_SEC;

	cout << "The time required to find " << nameToFind << " in the non-hashed database was " << timeToFind << endl;
	delete nonHashDatabase;
}

int main() {
	vector<string> namesVector;
	ifstream namesFile("names.txt");
	if(namesFile.is_open()){
		std::string nameOfPerson;
		for(int i = 0; i < 1000; i++){
			getline(namesFile, nameOfPerson);
			namesVector.push_back(nameOfPerson);
		}
	}else{
		cout << " file could not be found " << endl;
	}
	namesFile.close();
	srand(time(NULL));
	int selection = rand() % namesVector.size();
	string nameToFind = namesVector[selection];

	int *ages = new int[namesVector.size()];
	for(int i = 0; i < namesVector.size(); i++){
		ages[i] = rand()%100+1;
	}
	personHashDatabase(namesVector, ages, nameToFind);
	personDatabase(namesVector, ages, nameToFind);
	return 0;
}
