#ifndef RPG_DICE
#define RPG_DICE

#include "IntegerItem.h"

#include <cstdlib>
#include <ctime>

namespace rpg{

	class Dice : public IntegerItem{
		private:
			int nbFaces;
			int valMin;
		public:
			Dice(int nf);
			Dice(int nf,int valMin);
			Dice(Dice const& d);
			~Dice();
			virtual int getValue();
			virtual int getMaxValue();
			virtual int getMinValue();
			operator int();
			
	};
	        
    inline Dice operator+(Dice& d1, Dice d2){
        Dice ret(d1.getMaxValue()+d2.getMaxValue(), d1.getMinValue()+d2.getMinValue());
        return ret;
    }

    inline Dice operator+(Dice& d,const int nb){
        Dice ret(d.getMaxValue()+nb, d.getMinValue()+nb);
        return ret;
    }

    inline Dice operator+(const int nb,Dice& d){
        Dice ret(d.getMaxValue()+nb, d.getMinValue()+nb);
        return ret;
    }
}

#endif
