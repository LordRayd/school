#include "HatsuneMiku.h"
#include <iostream>
#include <fstream>

using namespace rpg;
using namespace std;

HatsuneMiku::HatsuneMiku(Race& r, String& n):Creature(r,n){
	std::clog << "HatsuneMiku," << this << ",Constructeur" << std::endl;
}

HatsuneMiku::HatsuneMiku(HatsuneMiku & hm): Creature(hm){
	std::clog << "HatsuneMiku," << this << ",Constructeur" << std::endl;
}

HatsuneMiku::~HatsuneMiku(){
	std::clog << "HatsuneMiku," << this << ",Destructeur" << std::endl;
}
