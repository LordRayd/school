#include "Race.h"
#include <iostream>

using namespace rpg;
using namespace std;

Race::Race(IntegerItem& pf, IntegerItem& mf):physicFormula(pf), mentalFormula(mf){
	clog << "Race," << this << ",Constructeur" << std::endl;
}

Race::Race(Race& r):physicFormula(r.physicFormula), mentalFormula(r.mentalFormula){
	clog << "Race," << this << ",Constructeur" << std::endl;
}

Race::~Race(){
	clog << "Race," << this << ",Destructeur" << std::endl;
}

IntegerItem& Race::getPhysicFormula(){
	return this->physicFormula;
}

IntegerItem& Race::getMentalFormula(){
	return this->mentalFormula;
}
