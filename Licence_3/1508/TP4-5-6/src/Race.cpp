#include "Race.h"

using namespace rpg;

Race::Race(IntegerItem pf, IntegerItem mf){
	this->physicFormula = pf;
	this->mentalFormula = mf;
}

Race::Race(Race& r){
	this->physicFormula = r.getPhysicFormula();
	this->mentalFormula = r.getMentalFormula();
}

Race::~Race(){

}
IntegerItem Race::getPhysicFormula(){
	return this->physicFormula;
}
	
IntegerItem Race::getMentalFormula(){
	this->mentalFormula;
}
