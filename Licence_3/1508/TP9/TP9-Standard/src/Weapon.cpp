#include "Weapon.h"
#include <iostream>

using namespace rpg;
using namespace std;

Weapon::Weapon(IntegerItem& ii): m_damage(ii){
	clog << "Weapon," << this << ",Constructeur" << std::endl;
}

Weapon::Weapon(const Weapon& d): m_damage(d.m_damage){
	clog << "Weapon," << this << ",Constructeur" << std::endl;
}

Weapon::~Weapon(){
	clog << "Weapon," << this << ",Destructeur" << std::endl;
}

IntegerItem& Weapon::getDamage(){
	return this->m_damage;
}
