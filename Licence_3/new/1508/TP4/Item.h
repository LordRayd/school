#include "Damageable.h"

#ifndef RPG_ITEM_H
#define RPG_ITEM_H

namespace rpg{

	class Item : public Damageable{
		private:
			int m_value;
		public:
			Item(int v, double hp, String& n));
			Item(Item& i);
			~Item();
	};
}

#endif