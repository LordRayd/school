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
#include "LivingItem.h"
#include "HatsuneMiku.h"

#include <iostream>
#include <fstream>

using namespace rpg;
using namespace std;

int main(){

	ofstream oflog("logs/log.csv");
    clog.rdbuf(oflog.rdbuf());


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

	//======================= TP9-1 =========================================
	String *name911 = new String("TP9-1-1");
	String *name912 = new String("TP9-1-2");
	String *name913 = new String("TP9-1-3");
	IntegerValue iv91(6);
	Race race91(iv91,iv91);
	Damageable damageable91(10,*name911);
	Item item91(15, 20, *name913);
	Creature creature91(race91, *name912);
	LivingItem livingItem91(16,30,race91, *name913);

	//Cast vers Item
	/*Item test1 ((Item) damageable91);
	Item test2 ((Item) item91);
	Item test3 ((Item) creature91);
	Item test4 ((Item) livingItem91);*/


	//======================= TP9-2 =========================================
	IntegerValue iv6(6);
	cout << "\n====Test du Living Item " << endl;
	String *name1 = new String("LivingItem");
	Race race1(iv6,iv6);
	LivingItem li1(10, 100, race1, *name1);

	cout << "\n====Test du Hatsune MIKU " << endl;
	String *name2 = new String("HatsuneMiku");
	HatsuneMiku hm1(race1, *name2);


	//cout << "getPhysic->getValue "<< hm1.getPhysic().getValue() << endl;
	//cout << "getMental->getValue "<< hm1.getMental().getValue() << endl;
	//cout << "getRace->getValue "<< hm1.getRace().getMentalFormula().getValue() << endl;
	//cout << "getRace->getValue "<< hm1.getRace().getPhysicFormula().getValue() << endl;
	//cout << "getName " << hm1.getName() << endl;


	/*Race humanRace(d+d+d, d+d+d ); // 3d6,   3d6
	Race orcRace(d+d+iv6, d+d);
	std::cout << "HUMAN physics : " << humanRace.getPhysicFormula().getMinValue() << " mental : " << humanRace.getPhysicFormula().getValue() << std::endl;
	std::cout << "ORC physics : " << orcRace.getPhysicFormula().getValue() << " mental : " << orcRace.getPhysicFormula().getValue() << std::endl;
	*/
}
