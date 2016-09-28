//============================================================================
// Name        : W4A2.cpp
// Author      : Anderson Thomas
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <stdlib.h>
#include "HashTable.h"

using namespace std;

void personHashDatabase(){
	std::string names[25] = {"andy","josh","patrick","collin","mason","max","olivia","michelle","tan","lemon","anthony","beau","greenfeld","trump","hillary","larry","mimie","neil","kris","austin","leah","mason","jack","john","dave"};
	bool adding = false;
	HashTable *hashy = new HashTable();
	for(int i = 0; i < 1000; i++){
		std::string named = names[rand() % 25];
		int age = rand() % 100 + 1;
		adding = hashy->store(named, age);
	}
	hashy->find("michelle");
	adding = hashy->store("Francis", 18);
	hashy->find("Francis");
	delete hashy;
}

void personDatabase(){
	std::string names[25] = {"andy","josh","patrick","collin","mason","max","olivia","michelle","tan","lemon","anthony","beau","greenfeld","trump","hillary","larry","mimie","neil","kris","austin","leah","mason","jack","john","dave"};
	linkedList* listy = new linkedList();
	bool adding = false;
	for(int i = 0; i < 1000; i++){
		std::string named = names[rand() % 25];
		int age = rand() % 100 + 1;
		adding = listy->add(named, age);
	}
	listy->find("michelle");
	listy->find("Francis");
	delete listy;
}

int main() {

	personHashDatabase();
	personDatabase();
	return 0;
}
