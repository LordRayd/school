#include "String.h"
#include "Damageable.h"
#include "Creature.h"
#include "Item.h"
#include "Race.h"
#include "Dice.h"
#include "IntegerValue.h"
#include "IntegerItem.h"
#include "Weapon.h"
#include "CraftedWeapon.h"

#include <iostream>

using namespace rpg;

int main(int argc, char * argv[]){
	
	String *name = new String("Knight");
	rpg::Damageable knight(12.0,*name);
	std::cout << "HP : " << knight.getHitPoints() << std::endl;
	
	knight.damage(8.0);
	std::cout << "HP : " << knight.getHitPoints() << std::endl;
	
	knight.healRepair(6);
	std::cout << "HP : " << knight.getHitPoints() << std::endl;
	
	knight.damage(52);
	std::cout << "HP : " << knight.getHitPoints() << std::endl;
	std::cout << "Chevalier mort ?  " << knight.isDead() << std::endl;
	
	knight.healRepair(8);
	std::cout << "HP : " << knight.getHitPoints() << std::endl;
	std::cout << "Chevalier mort ?  " << knight.isDead() << std::endl;
	
    
	//=================== J'ai pas eu le temps de poursuivre désoler
    String un= String("un test");
    String deux=String(" est Un");
    const char* trois=" Test";
    String quatre=un+deux+trois;
    std::cout<<quatre<<"\n";

    Dice d= Dice(6);
    std::cout<<d.getValue()<<" Min :"<<d.getMinValue()<<" Max :"<<d.getMaxValue()<<"\n";
    Dice dd=d+Dice(5);
    std::cout<<dd.getValue()<<" Min :"<<dd.getMinValue()<<" Max :"<<dd.getMaxValue()<<"\n";
    dd=dd+6;
    std::cout<<dd.getValue()<<" Min :"<<dd.getMinValue()<<" Max :"<<dd.getMaxValue()<<"\n";
	
	IntegerValue iv6(6);
	Race humanRace(d+d+d, d+d+d ); // 3d6,   3d6
	Race orcRace(d+d+iv6, d+d);
	std::cout << "HUMAN physics : " << humanRace.getPhysicFormula().getMinValue() << " mental : " << humanRace.getPhysicFormula().getValue() << std::endl;
	std::cout << "ORC physics : " << orcRace.getPhysicFormula().getValue() << " mental : " << orcRace.getPhysicFormula().getValue() << std::endl;
}
