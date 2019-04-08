#include "Creature.h"

#ifndef RPG_CREATURE_CPP
#define RPG_CREATURE_CPP

using namespace rpg;

Creature::Creature(int p, int m, double hp, String& n):m_name("null"){
	this->m_hitPoints = hp;
	this->m_name = n;
    this->m_physic = p;
    this->m_mental = m;
}
Creature::Creature(Creature& c):m_name("null"){
	this->m_hitPoints = c.m_hitPoints;
	this->m_name = c.m_name;
    this->m_physic = c.m_physic;
    this->m_mental = c.m_mental;
}

Creature::~Creature(){
	
}
#endif