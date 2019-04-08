#include "catch2/catch.hpp"
#include "../src/CraftedWeapon.h"
#include "../src/Weapon.h"
#include "../src/Dice.h"
#include "../src/String.h"

TEST_CASE( "CraftedWeapon Test" ) {

	using namespace rpg;

	rpg::Dice dice1(6);
	String *name1 = new String("TestedCraftedWeapon");
	rpg::CraftedWeapon cw1(dice1, 1000, 104.0, *name1);

	CraftedWeapon* ptr(0);  //Un pointeur sur un véhicule
    //Voiture caisse(20000,5);
    //On crée une voiture
    //Ceci est autorisé puisque toutes les fonctions ont un corps
    ptr = &cw1;
	REQUIRE( 1 <= ptr->getDamage().getValue() );
    
	REQUIRE( cw1.getDamage().getValue() <= 6 );
	REQUIRE( 1 <= cw1.getDamage().getValue() );
	REQUIRE( cw1.getDamage().getMaxValue() == 6 );
	REQUIRE( cw1.getDamage().getMinValue() == 1 );

	REQUIRE( cw1.getValue() == 1000 );
	REQUIRE( cw1.getHitPoints() == 104 );
  REQUIRE( cw1.isDead() == false );
  REQUIRE( strcmp(cw1.getName(),"TestedCraftedWeapon") == 0 );

  cw1.rpg::Item::damage(5);
  REQUIRE( cw1.getHitPoints() == 99 );
  cw1.healRepair(5);
  REQUIRE( cw1.getHitPoints() == 104 );
  cw1.rpg::Item::damage(104);
  REQUIRE( cw1.getHitPoints() == 0 );
  REQUIRE( cw1.isDead() == true );

  String *name2 = new String("New Name");
  cw1.setName( *name2 );
  REQUIRE( strcmp(cw1.getName(),"New Name") == 0 );
}
