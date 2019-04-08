#ifndef RPG_WEAPON
#define RPG_WEAPON

#include "IntegerItem.h"

namespace rpg{

	class Weapon{
		private:
			IntegerItem damage;
		public:
			Weapon(IntegerItem ii);
			Weapon(Weapon& d);
			~Weapon();
			IntegerItem getDamage();
	};
}

#endif
