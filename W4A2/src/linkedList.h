/*
 * linkedList.h
 *
 *  Created on: Sep 26, 2016
 *      Author: andersonhatcherthomas
 */

#ifndef LINKEDLIST_H_
#define LINKEDLIST_H_
#include "Node.h"

class linkedList {
public:
	linkedList();
	virtual ~linkedList();
	void find(std::string nameToFind);
	void add(std::string nameToFind, int age);

private:
	Node* root;
};

#endif /* LINKEDLIST_H_ */
