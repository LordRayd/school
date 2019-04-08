#include "catch2/catch.hpp"
#include "../src/IntegerValue.h"
#include "../src/Race.h"

TEST_CASE( "Race Test" ) {

	IntegerValue iv1(11);
	IntegerValue iv2(105);
	Race race1(iv1, iv2);
  REQUIRE( race1.getPhysicFormula().getValue() == 11 );
  REQUIRE( race1.getMentalFormula().getValue() == 105 );

  Race race2(race1);
  REQUIRE( race2.getPhysicFormula().getValue() == 11 );
  REQUIRE( race2.getMentalFormula().getValue() == 105 );
}
