#ifndef RPG_LIVING_ITEM
#define RPG_LIVING_ITEM

#include "Item.h"
#include "Creature.h"

namespace rpg{

	class LivingItem : public Creature, public Item{
    public:
        LivingItem(int v, double hp, Race& r, String& n);
        LivingItem(LivingItem& li);
        virtual ~LivingItem();
	};
}

#endif
