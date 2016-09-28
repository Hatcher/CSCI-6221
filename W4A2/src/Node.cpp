/*
 * Node.cpp
 *
 *  Created on: Sep 26, 2016
 *      Author: andersonhatcherthomas
 */

#include "Node.h"


Node::Node() {
	parent = nullptr;
	next = nullptr;
	// TODO Auto-generated constructor stub
}
Node::Node(Node* inputParent, std::string inputName, int inputAge){
	parent = inputParent;
	age = inputAge;
	name = inputName;
	next = nullptr;
}

Node::~Node() {
	// TODO Auto-generated destructor stub
	delete this->next;
	delete this;

}
bool Node::hasNext(){
	if(this->next == nullptr){
		return false;
	}
	return true;
}
Node* Node::Next(){
	return this->next;
}

int Node::getAge(){
	return this->age;
}

std::string Node::getName(){
	return this->name;
}

bool Node::setNext(Node* newNode){
	this->next = newNode;
	return true;
}
