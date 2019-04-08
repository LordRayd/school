#include "Creature.h"
#include "Damageable.h"
#include "IntegerItem.h"
#include "Race.h"

#include <iostream>

using namespace rpg;
using namespace std;

Creature::Creature(Race& r, String& n): Damageable(r.getPhysicFormula().getValue(),n), m_race(r){
	this->m_physic = this->getHitPoints();
	this->m_mental = r.getMentalFormula().getValue();
	clog << "Creature," << this << ",Constructeur" << std::endl;
}

Creature::Creature(Creature& c): Damageable(c.getHitPoints(), c.getName()), m_race(c.m_race){
    this->m_physic = c.getHitPoints();
    this->m_mental = c.m_race.getMentalFormula().getValue();
	clog << "Creature," << this << ",Constructeur" << std::endl;
}

Creature::~Creature(){
	clog << "Creature," << this << ",Destructeur" << std::endl;
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
