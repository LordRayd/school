#include "CraftedWeapon.h"
#include "Damageable.h"
#include "Item.h"

#include <iostream>

using namespace rpg;
using namespace std;

CraftedWeapon::CraftedWeapon(IntegerItem& ii, int v, double hp, String n): Weapon(ii), Item(v, hp, n){
	clog << "CraftedWeapon," << this << ",Constructeur" << std::endl;
}

CraftedWeapon::CraftedWeapon(CraftedWeapon& cw): Weapon(cw.m_damage), Item(cw.m_value, cw.m_hitPoints, cw.m_name){
    clog << "CraftedWeapon," << this << ",Constructeur" << std::endl;
}

CraftedWeapon::~CraftedWeapon(){
    clog << "CraftedWeapon," << this << ",Destructeur" << std::endl;
}