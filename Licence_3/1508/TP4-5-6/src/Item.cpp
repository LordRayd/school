#ifndef RPG_ITEM_CPP
#define RPG_ITEM_CPP

#include "Item.h"
#include "String.h"

using namespace rpg;

Item::Item(int v, double hp, String& n):Damageable::Damageable(hp,n){
    this->m_value = v;
}
Item::Item(Item& i):Damageable::Damageable(i.Damageable::getHitPoints(), i.Damageable::getName()){
    this->m_value = i.m_value;
}

Item::~Item(){
	
}

int Item::getValue(){
    return this->m_value;
}

#endif
