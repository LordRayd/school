#ifndef RPG_INTEGERITEM
#define RPG_INTEGERITEM

namespace rpg{

	class IntegerItem{
		public:
			virtual int getValue()=0;
			virtual int getMaxValue()=0;
			virtual int getMinValue()=0 ;
	};
}


#endif
