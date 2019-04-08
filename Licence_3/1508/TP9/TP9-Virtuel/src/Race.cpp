#include "Race.h"

using namespace rpg;

Race::Race(IntegerItem& pf, IntegerItem& mf):physicFormula(pf), mentalFormula(mf){
	
}

Race::Race(Race& r):physicFormula(r.physicFormula), mentalFormula(r.mentalFormula){
	
}

Race::~Race(){

}
IntegerItem& Race::getPhysicFormula(){
	return this->physicFormula;
}

IntegerItem& Race::getMentalFormula(){
	return this->mentalFormula;
}
