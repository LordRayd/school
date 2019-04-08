#include "IntegerItem.h"

#ifndef INTEGERVALUE_H
#define INTEGERVALUE_H

class IntegerValue : public rpg::IntegerItem{
    private:
        int m_value;
    public:
        IntegerValue(int v);
        IntegerValue(IntegerValue& iv);
        ~IntegerValue();
};

#endif