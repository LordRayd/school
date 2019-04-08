#include "Damageable.h"

rpg::Damageable::Damageable(double hp, String& n):m_name("null"){
	this->m_hitPoints = hp;
	this->m_name = n;
}

rpg::Damageable::Damageable(double hp):m_name("null"){
	this->m_hitPoints = hp;
}

rpg::Damageable::Damageable(rpg::Damageable& d):m_name("null"){
	this->m_hitPoints = d.m_hitPoints;
	this->m_name = d.m_name;
}

rpg::Damageable::~Damageable(){
	
}

void rpg::Damageable::damage(int damage){
	if((this->getHitPoints() - damage) < 0.0){
		this->m_hitPoints = 0.0;
	}else{
		this->m_hitPoints -= damage;
	}
}

bool rpg::Damageable::isDead(){
	if(this->getHitPoints() == 0.0){
		return true;
	}else{
		return false;
	}
}

void rpg::Damageable::healRepair(int heal){
	if(!this->isDead()){
		this->m_hitPoints += heal;
	}
}

double rpg::Damageable::getHitPoints(){
	return this->m_hitPoints;
}

String& rpg::Damageable::getName(){
	return this->m_name;
}

void rpg::Damageable::setName(String& n){
	this->m_name = n;
}

