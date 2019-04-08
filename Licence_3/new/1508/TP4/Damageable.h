#include "Exercice3.cpp"

#ifndef RPG_DAMAGEABLE_H
#define RPG_DAMAGEABLE_H

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
			String getName();
			void setName(String& n);
	};
}

#endif