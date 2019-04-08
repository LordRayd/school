#include "catch2/catch.hpp"
#include "../src/IntegerValue.h"
#include "../src/Race.h"
#include "../src/String.h"
#include "../src/Creature.h"

TEST_CASE( "Creature Test" ) {

	IntegerValue iv1(11);
	IntegerValue iv2(105);
	Race race1(iv1, iv2);
	String *name1 = new String( "TestedCreature" );
	rpg::Creature creature1( race1, *name1 );

	REQUIRE( creature1.getHitPoints() == 11 );
	REQUIRE( creature1.getRace().getPhysicFormula().getValue() == 11 );
	REQUIRE( creature1.getRace().getMentalFormula().getValue() == 105 );
	REQUIRE( creature1.getPhysic() == 11 );
	REQUIRE( creature1.getMental() == 105 );
	REQUIRE( creature1.isDead() == false );
	REQUIRE( strcmp(creature1.getName(), "TestedCreature") == 0 );

	creature1.damage(5);
	REQUIRE( creature1.getHitPoints() == 6 );

	creature1.healRepair(5);
	REQUIRE( creature1.getHitPoints() == 11 );

	creature1.damage(11);
	REQUIRE( creature1.isDead() == true );

	String *name2 = new String("New Name");
	creature1.setName( *name2 );
	REQUIRE( strcmp(creature1.getName(), "New Name") == 0 );

}
