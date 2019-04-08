#include "Damageable.h"

#ifndef RPG_CREATURE_H
#define RPG_CREATURE_H

namespace rpg{

	class Creature : public Damageable{
		private:
			int m_physic;
			int m_mental;
		public:
			Creature(int p, int m, double hp, String& n);
			Creature(Creature& c);
			~Creature();
	};
}

#endif