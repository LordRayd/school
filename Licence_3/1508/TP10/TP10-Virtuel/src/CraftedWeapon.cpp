#include "CraftedWeapon.h"
#include "Damageable.h"
#include "Item.h"

using namespace rpg;

CraftedWeapon::CraftedWeapon(IntegerItem& ii, int v, double hp, String n): Damageable(hp, n), Weapon(ii), Item(v, hp, n){

}

CraftedWeapon::CraftedWeapon(CraftedWeapon& cw): Damageable(cw.m_hitPoints, cw.m_name), Weapon(cw.m_damage), Item(cw.m_value, cw.m_hitPoints, cw.m_name){

}

CraftedWeapon::~CraftedWeapon(){

}
