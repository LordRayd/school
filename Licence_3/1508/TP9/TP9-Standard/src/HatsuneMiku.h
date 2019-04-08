#ifndef RPG_HATSUNE_MIKU
#define RPG_HATSUNE_MIKU

#include "String.h"
#include "Race.h"
#include "Creature.h"

namespace rpg{

	class HatsuneMiku : private Creature{
		public:
			HatsuneMiku(Race& r, String& n);
			HatsuneMiku(HatsuneMiku & hm);
			virtual ~HatsuneMiku();
	};

}

#endif
