#ifndef RPG_INTEGERITEM
#define RPG_INTEGERITEM

namespace rpg{

	class IntegerItem{
		public:
			virtual int getValue();
			virtual int getMaxValue();
			virtual int getMinValue();
	};
}


#endif
