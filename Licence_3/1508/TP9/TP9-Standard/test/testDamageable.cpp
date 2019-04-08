#include "catch2/catch.hpp"
#include "../src/Damageable.h"
#include "../src/String.h"

TEST_CASE( "Damageable Test" ) {
	
	String *name1 = new String("TestedDamageable");
	rpg::Damageable damageable1( 10.0 , *name1 );
    REQUIRE( damageable1.getHitPoints() == 10 );
    REQUIRE( damageable1.isDead() == false );
    REQUIRE( strcmp(damageable1.getName(),"TestedDamageable") == 0 );
    
    damageable1.damage(5);
    REQUIRE( damageable1.getHitPoints() == 5 );
    damageable1.healRepair(5);
    REQUIRE( damageable1.getHitPoints() == 10 );
    damageable1.damage(10);
    REQUIRE( damageable1.isDead() == true );
    String *name2 = new String("New Name");
    damageable1.setName( *name2 );
    REQUIRE( strcmp(damageable1.getName(),"New Name") == 0 );
    
	rpg::Damageable damageable2(damageable1);
    REQUIRE( damageable2.getHitPoints() == 0 );
    REQUIRE( damageable2.isDead() == true );
    REQUIRE( strcmp(damageable1.getName(),"New Name") == 0 );
}
