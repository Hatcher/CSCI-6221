/*
 * HashTable.cpp
 *
 *  Created on: Sep 26, 2016
 *      Author: andersonhatcherthomas
 */

#include "HashTable.h"

HashTable::HashTable() {
	// TODO Auto-generated constructor stub
	//each entry in the array is a pointer to a node
	for(int i = 0; i < 5; i++){
		hTable[i] = nullptr;
	}
}

HashTable::~HashTable() {
	// TODO Auto-generated destructor stub
	for(int i = 0; i < 5; i++){
		delete this->hTable[i];
	}
}


void HashTable::store(std::string name, int age){
	int hashIndex = hash(name);
	if(this->hTable[hashIndex] == nullptr){
		this->hTable[hashIndex] = new linkedList();
	}
	linkedList *temp = this->hTable[hashIndex];
	temp->add(name, age);
}
void HashTable::find(std::string name){
	int hashValue = hash(name);
	linkedList *tempList = this->hTable[hashValue];
	tempList->find(name);
}

int HashTable::hash(std::string name){
	int hashValue = (name.length())%5;
	return hashValue;
}
