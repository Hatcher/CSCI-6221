/*
 * linkedList.cpp
 *
 *  Created on: Sep 26, 2016
 *      Author: andersonhatcherthomas
 */

#include "linkedList.h"
#include <iostream>
#include <vector>

linkedList::linkedList() {
	// TODO Auto-generated constructor stub
	root = nullptr;
}

linkedList::~linkedList() {
	// TODO Auto-generated destructor stub
}

void linkedList::find(std::string nameToFind){
	Node *temp = this->root;
	std::vector<int> ages;
	while(temp != nullptr){
		if(temp->getName() == nameToFind){
			int ageFound = temp->getAge();
			ages.push_back(ageFound);
		}
		temp = temp->Next();
	}
	if(ages.size() > 0){
		if(ages.size() > 1){
			std::cout << "We have " << ages.size() << " entries stored for " << nameToFind << ", their age could be " << ages.back();
		}else {
			std::cout << nameToFind << " is " << ages.back() << " years old";
		}
		ages.pop_back();
		for(auto i = ages.begin(); i != ages.end(); i++){
			std::cout << ", " << *i;
		}
	}else{
		std::cout << "No one by that name exists in our database";
	}
	std::cout << "." << std::endl;

}


void linkedList::add(std::string nameToAdd, int age){
	Node *temp = this->root;
	Node *newNode = new Node(temp, nameToAdd, age);
	if(temp != nullptr){
		while(temp->hasNext() == true){
			temp = temp->Next();
		}
		temp->setNext(newNode);
	}else{
		this->root = newNode;
	}
}
