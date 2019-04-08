#include "Item.h"

#ifndef RPG_ITEM_CPP
#define RPG_ITEM_CPP

using namespace rpg;

Item::Item(int v, double hp, String& n):m_name("null"){
	this->m_hitPoints = hp;
	this->m_name = n;
    this->m_value = v;
}
Item::Item(Item& i):m_name("null"){
	this->m_hitPoints = i.m_hitPoints;
	this->m_name = i.m_name;
    this->m_value = i.m_value;
}

Item::~Item(){
	
}
#endif