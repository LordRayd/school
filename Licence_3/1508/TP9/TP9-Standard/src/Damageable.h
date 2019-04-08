#ifndef RPG_DAMAGEABLE
#define RPG_DAMAGEABLE

#include "String.h"

namespace rpg{
	class Damageable{
		private:
			double m_hitPoints;
			String m_name;
		public:
			Damageable(double hp, String& n);
			Damageable(double hp);
			Damageable(Damageable& d);
			~Damageable();
			void damage(int damage);
			bool isDead();
			void healRepair(int heal);
			double getHitPoints();
			String& getName();
			void setName(String& n);
			friend class Creature;
			friend class Item;
			friend class CraftedWeapon;
			friend class LivingItem;

	};
}

#endif
