/*
 * HashTable.h
 *
 *  Created on: Sep 26, 2016
 *      Author: andersonhatcherthomas
 */

#ifndef HASHTABLE_H_
#define HASHTABLE_H_

#include "linkedList.h"
#include <iostream>

class HashTable {
public:
	HashTable();
	virtual ~HashTable();
	void store(std::string name, int age);
	void find(std::string name);
private:
	int hash(std::string name);
	linkedList *hTable[5];
};



#endif /* HASHTABLE_H_ */
