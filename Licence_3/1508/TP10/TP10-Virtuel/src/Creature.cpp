#include "Creature.h"
#include "Damageable.h"
#include "IntegerItem.h"
#include "Race.h"
#include <iostream>

using namespace rpg;

Creature::Creature(Race& r, String& n): Damageable(r.getPhysicFormula().getValue(),n), m_race(r){
	this->m_physic = this->getHitPoints();
	this->m_mental = r.getMentalFormula().getValue();
	std::cout << "Constructeur Creature" << std::endl;
}

Creature::Creature(Creature& c): Damageable(c.getHitPoints(), c.getName()), m_race(c.m_race){
    this->m_physic = c.getHitPoints();
    this->m_mental = c.m_race.getMentalFormula().getValue();
  	std::cout << "Constructeur Creature" << std::endl;
}

Creature::~Creature(){
  std::cout << "Destructeur Creature" << std::endl;
}

int Creature::getPhysic(){
	return this->m_physic;
}

int Creature::getMental(){
	return this->m_mental;
}

Race Creature::getRace(){
	return this->m_race;
}
