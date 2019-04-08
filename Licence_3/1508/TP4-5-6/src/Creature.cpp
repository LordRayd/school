#include "Creature.h"
#include "Damageable.h"
#include "IntegerItem.h"
#include "Race.h"

using namespace rpg;

Creature::Creature(Race r, String& n): Damageable(r.getPhysicFormula().getValue(),n), m_race(r){
	this->m_race = r;
	this->m_physic = this->getHitPoints();
	this->m_mental = r.getMentalFormula().getValue();
}

Creature::Creature(Creature& c): Damageable(c.getHitPoints(), c.getName()), m_race(c.m_race){
	this->m_race = c.m_race;
    this->m_physic = c.getHitPoints();
    this->m_mental = c.m_race.getMentalFormula().getValue();
}

Creature::~Creature(){
	
}
