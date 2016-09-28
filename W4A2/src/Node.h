/*
 * Node.h
 *
 *  Created on: Sep 26, 2016
 *      Author: andersonhatcherthomas
 */

#ifndef NODE_H_
#define NODE_H_
#include <string>

class Node {
public:
	Node();
	Node(Node* inputParent, std::string inputName, int inputAge);
	virtual ~Node();
	Node* Next();
	int getAge();
	std::string getName();
	bool setNext(Node* newNode);
	bool hasNext();

private:
	Node* next;
	Node* parent;
	int age;
	std::string name;
};

#endif /* NODE_H_ */
