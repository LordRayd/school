#include "catch2/catch.hpp"
#include "../src/Damageable.h"
#include "../src/Item.h"

TEST_CASE( "Item Test" ) {
	
	String *name1 = new String("TestedItem");
	rpg::Item item1(21, 10.0 , *name1 );
    REQUIRE( item1.getValue() == 21 );
    REQUIRE( item1.getHitPoints() == 10 );
    REQUIRE( item1.isDead() == false );
    REQUIRE( strcmp(item1.getName(), "TestedItem") == 0 );
    
    item1.damage(5);
    REQUIRE( item1.getHitPoints() == 5 );
    item1.healRepair(5);
    REQUIRE( item1.getHitPoints() == 10 );
    item1.damage(10);
    REQUIRE( item1.isDead() == true );
    String *name2 = new String("New Name");
    item1.setName( *name2 );;
    REQUIRE( strcmp(item1.getName(), "New Name" ) == 0);
    
	rpg::Item item2(item1);
    REQUIRE( item2.getValue() == 21 );
    REQUIRE( item2.getHitPoints() == 0 );
    REQUIRE( item2.isDead() == true );
    REQUIRE( strcmp(item2.getName(), "New Name") == 0 );
}
