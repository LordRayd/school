#ifndef INTEGERVALUE
#define INTEGERVALUE

#include "IntegerItem.h"

class IntegerValue : public rpg::IntegerItem{
    private:
        int m_value;
    public:
        IntegerValue(int v);
        IntegerValue(IntegerValue& iv);
        ~IntegerValue();
        int getValue();
		int getMaxValue();
		int getMinValue();
        operator int() const;
};

        
inline IntegerValue operator+(IntegerValue& d1, IntegerValue d2){
    IntegerValue ret(d1.getMaxValue()+d2.getMaxValue());
    return ret;
}

inline IntegerValue operator+(IntegerValue& d,const int nb){
    IntegerValue ret(d.getMaxValue()+nb);
    return ret;
}

inline IntegerValue operator+(const int nb,IntegerValue& d){
    IntegerValue ret(d.getMaxValue()+nb);
    return ret;
}

#endif
