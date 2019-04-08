#include "Weapon.h"

using namespace rpg;

Weapon::Weapon(IntegerItem ii){
	this->damage = ii;
}

Weapon::Weapon(Weapon& d){
	this->damage = d.getDamage();
}

Weapon::~Weapon(){
	
}

IntegerItem Weapon::getDamage(){
	return this->damage;
}
