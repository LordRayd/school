#include "Damageable.h"
#include "Exercice3.h"

#ifndef RPG_DAMAGEABLE_CPP
#define RPG_DAMAGEABLE_CPP

using namespace rpg;

Damageable::Damageable(double hp, String& n):m_name("null"){
	this->m_hitPoints = hp;
	this->m_name = n;
}

Damageable::Damageable(double hp):m_name("null"){
	this->m_hitPoints = hp;
}

Damageable::Damageable(Damageable& d):m_name("null"){
	this->m_hitPoints = d.m_hitPoints;
	this->m_name = d.m_name;
}

Damageable::~Damageable(){
	
}

void Damageable::damage(int damage){
	if((this->getHitPoints() - damage) < 0.0){
		this->m_hitPoints = 0.0;
	}else{
		this->m_hitPoints -= damage;
	}
}

bool Damageable::isDead(){
	if(this->getHitPoints() == 0.0){
		return true;
	}else{
		return false;
	}
}

void Damageable::healRepair(int heal){
	if(!this->isDead()){
		this->m_hitPoints += heal;
	}
}

double Damageable::getHitPoints(){
	return this->m_hitPoints;
}

String Damageable::getName(){
	return this->m_name;
}

void Damageable::setName(String& n){
	this->m_name = n;
}

#endif