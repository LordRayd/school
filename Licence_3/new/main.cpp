#include "Dice.h"
#include "Race.h"
#include "Creature.h"
#include "IntegerValue.h"
#include "Item.h"
#include "main.h"
#include <iostream>
using namespace std;
using namespace rpg;
int main(){
    String nomun="Bob";
    String nomdeux="Fred";
    String un= String("bla");
    IntegerValue intval=IntegerValue(10,1);
    IntegerValue intvaldeux=IntegerValue(intval);
    Race r=Race(intval,intvaldeux);
    Creature Bob= Creature(nomun,r);

    String deux=String(un);
    const char* trois="====";
    String quatre=un+trois+deux;
    cout<<quatre<<"\n";
    Dice d= Dice(6);
    cout<<d.getValue()<<" Min :"<<d.getMinValue()<<" Max :"<<d.getMaxValue()<<"\n";
    Dice dd=d+Dice(5);
    cout<<dd.getValue()<<" Min :"<<dd.getMinValue()<<" Max :"<<dd.getMaxValue()<<"\n";
    dd=dd+6;
    cout<<dd.getValue()<<" Min :"<<dd.getMinValue()<<" Max :"<<dd.getMaxValue()<<"\n";
    Bob.dispResult();
    Race r2=Race(dd,dd);
    Creature Fred= Creature(nomdeux,r2);
    Fred.dispResult();
}

