#include "LivingItem.h"
#include <iostream>

using namespace rpg;

LivingItem::LivingItem(int v, double hp, Race& r, String& n): Damageable(hp, n), Creature(r, n), Item(v, hp, n){
  std::cout << "Constructeur LivingItem" << std::endl;
}

LivingItem::LivingItem(LivingItem& li): Damageable(li.m_hitPoints, li.m_name), Creature(li.m_race, li.m_name), Item(li.m_value, li.m_hitPoints, li.m_name){
  std::cout << "Constructeur LivingItem" << std::endl;
}

LivingItem::~LivingItem(){
  std::cout << "Destructeur LivingItem" << std::endl;
}
