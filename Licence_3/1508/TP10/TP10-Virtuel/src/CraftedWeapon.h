#ifndef RPG_CRAFTED_WEAPON
#define RPG_CRAFTED_WEAPON

#include "Item.h"
#include "Weapon.h"
#include "IntegerItem.h"

namespace rpg{

	class CraftedWeapon: public Weapon, public Item{
		public:
			CraftedWeapon(IntegerItem& ii, int v, double hp, String n);
			CraftedWeapon(CraftedWeapon& cw);
			virtual ~CraftedWeapon();
	};
}

#endif
