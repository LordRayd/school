#ifndef RPG_ITEM
#define RPG_ITEM

#include "Damageable.h"

namespace rpg{

	class Item : public Damageable{
		private:
			int m_value;
		public:
			Item(int v, double hp, String n);
			Item(Item& i);
			~Item();
			int getValue();
			friend class CraftedWeapon;
			friend class LivingItem;
	};
}

#endif
