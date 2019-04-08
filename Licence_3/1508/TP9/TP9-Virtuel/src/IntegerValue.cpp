#include "IntegerValue.h"


IntegerValue::IntegerValue(int v){
	this->m_value = v;
}

IntegerValue::IntegerValue(IntegerValue& iv){
	this->m_value = iv.getValue();
}

IntegerValue::~IntegerValue(){

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
