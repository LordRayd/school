#include "CraftedWeapon.h"
#include "Damageable.h"
#include "Item.h"

using namespace rpg;

CraftedWeapon::CraftedWeapon(IntegerItem ii, int v, double hp, String& n): Weapon::Weapon(ii), Item::Item(v, hp, n){
	
}

CraftedWeapon::CraftedWeapon(CraftedWeapon& cw): Weapon::Weapon(cw.getDamage()), Item::Item(cw.getValue(), cw.getHitPoints(), cw.getName()){
	
}

CraftedWeapon::~CraftedWeapon(){
	
}


