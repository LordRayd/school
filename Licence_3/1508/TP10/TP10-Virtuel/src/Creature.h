#ifndef RPG_CREATURE
#define RPG_CREATURE

#include "Damageable.h"
#include "Race.h"

namespace rpg{

	class Creature : virtual public Damageable{
		private:
			int m_physic;
			int m_mental;
			Race m_race;
		public:
			Creature(Race& r, String& n);
			Creature(Creature& c);
			virtual ~Creature();
			int getPhysic();
			int getMental();
			Race getRace();
			friend class LivingItem;
	};
}

#endif
