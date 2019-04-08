#include "catch2/catch.hpp"
#include "../src/Weapon.h"
#include "../src/IntegerValue.h"

TEST_CASE( "Weapon Test" ) {

	IntegerValue iv1(6);
	rpg::Weapon weapon1(iv1);

  REQUIRE( weapon1.getDamage().getValue() == 6 );
  REQUIRE( weapon1.getDamage().getMinValue() == 6);
  REQUIRE( weapon1.getDamage().getMaxValue() == 6);

  rpg::Weapon weapon2(weapon1);
  REQUIRE( weapon2.getDamage().getValue() == weapon1.getDamage().getValue() );
  REQUIRE( weapon2.getDamage().getValue() == 6 );
  REQUIRE( weapon2.getDamage().getMinValue() == 6);
  REQUIRE( weapon2.getDamage().getMaxValue() == 6);

}
