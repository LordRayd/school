#include "catch2/catch.hpp"
#include "../src/Dice.h"

TEST_CASE( "Dice Test" ) {
	
	rpg::Dice dice1(6);
    REQUIRE( 0 <= dice1.getValue() );
    REQUIRE( dice1.getValue() <= 6 );
    REQUIRE( dice1.getMaxValue() == 6 );
    REQUIRE( dice1.getMinValue() == 1 );
    
    rpg::Dice dice2(dice1);
    REQUIRE( 0 <= dice2.getValue() );
    REQUIRE( dice2.getValue() <= 6 );
    REQUIRE( dice2.getMaxValue() == 6 );
    REQUIRE( dice2.getMinValue() == 1 );
    
}
