#include "LivingItem.h"
#include <iostream>

using namespace rpg;
using namespace std;

LivingItem::LivingItem(int v, double hp, Race& r, String& n): Creature(r, n), Item(v, hp, n){
	clog << "LivingItem," << this << ",Constructeur" << std::endl;
}

LivingItem::LivingItem(LivingItem& li): Creature(li.m_race, li.Creature::m_name), Item(li.Item::m_value, li.Item::m_hitPoints, li.Item::m_name){
  clog << "LivingItem," << this << ",Constructeur" << std::endl;
}

LivingItem::~LivingItem(){
  clog << "LivingItem," << this << ",Destructeur" << std::endl;
}
