#ifndef RACE
#define RACE

#include "IntegerItem.h"

class Race{
	private:
		rpg::IntegerItem& physicFormula;
		rpg::IntegerItem& mentalFormula;
	public:
		Race(rpg::IntegerItem& pf, rpg::IntegerItem& mf);
		Race(Race& r);
		virtual ~Race();
		rpg::IntegerItem& getPhysicFormula();
		rpg::IntegerItem& getMentalFormula();
};
#endif
