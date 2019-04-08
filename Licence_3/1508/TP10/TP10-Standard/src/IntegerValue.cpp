#include "IntegerValue.h"
#include <iostream>

using namespace std;

IntegerValue::IntegerValue(int v){
	this->m_value = v;
	clog << "IntegerValue," << this << ",Constructeur" << std::endl;
}

IntegerValue::IntegerValue(IntegerValue& iv){
	this->m_value = iv.getValue();
	clog << "IntegerValue," << this << ",Constructeur" << std::endl;
}

IntegerValue::~IntegerValue(){
	clog << "IntegerValue," << this << ",Destructeur" << std::endl;
}

int IntegerValue::getValue(){
	return this->m_value;
}

IntegerValue::operator int() const{
	return this->m_value;
}

int IntegerValue::getMaxValue(){
	return this->m_value;
}

int IntegerValue::getMinValue(){
	return this->m_value;
}
