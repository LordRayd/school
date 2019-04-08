#ifndef RPG_ITEM_CPP
#define RPG_ITEM_CPP

#include "Item.h"
#include "String.h"
#include <iostream>

using namespace rpg;
using namespace std;

Item::Item(int v, double hp, String n):Damageable::Damageable(hp,n){
    this->m_value = v;
	clog << "Item," << this << ",Constructeur" << std::endl;
}
Item::Item(Item& i):Damageable::Damageable(i.Damageable::getHitPoints(), i.Damageable::getName()){
    this->m_value = i.m_value;
	clog << "Item," << this << ",Constructeur" << std::endl;
}

Item::~Item(){
	clog << "Item," << this << ",Destructeur" << std::endl;
}

int Item::getValue(){
    return this->m_value;
}

#endif
