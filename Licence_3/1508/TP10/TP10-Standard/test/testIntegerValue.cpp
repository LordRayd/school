#include "catch2/catch.hpp"
#include "../src/IntegerValue.h"

TEST_CASE( "IntegerValue Test" ) {
	
	IntegerValue iv1(10);
	REQUIRE( iv1.getValue() == 10 );
	REQUIRE( iv1.getMaxValue() == 10 );
	REQUIRE( iv1.getMinValue() == 10 );
    
	IntegerValue iv2(iv1);
	REQUIRE( iv2.getValue() == 10 );
	REQUIRE( iv2.getMaxValue() == 10 );
	REQUIRE( iv2.getMinValue() == 10 );
}
