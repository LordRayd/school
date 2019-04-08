#ifndef RPG_WEAPON
#define RPG_WEAPON

#include "IntegerItem.h"

namespace rpg{

	class Weapon{
		private:
			IntegerItem& m_damage;
		public:
			Weapon(IntegerItem& ii);
			Weapon(const Weapon& d);
			virtual ~Weapon();
			IntegerItem& getDamage();
			friend class CraftedWeapon;
	};
}

#endif
