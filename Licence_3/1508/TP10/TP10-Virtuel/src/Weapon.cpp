#include "Weapon.h"

using namespace rpg;

Weapon::Weapon(IntegerItem& ii): m_damage(ii){
	
}

Weapon::Weapon(const Weapon& d): m_damage(d.m_damage){
	
}

Weapon::~Weapon(){
	
}

IntegerItem& Weapon::getDamage(){
	return this->m_damage;
}
