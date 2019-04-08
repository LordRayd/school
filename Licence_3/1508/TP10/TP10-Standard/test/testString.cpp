#include "catch2/catch.hpp"
#include "../src/String.h"

TEST_CASE( "String Test" ) {

	String *name1 = new String( "TestedString" );
  REQUIRE( strcmp(*name1, "TestedString") == 0 );

  String *name2 = new String("New String");
  REQUIRE( strcmp(*name1, "New String") != 0 );
  REQUIRE( strcmp(*name2, "New String") == 0 );

  String *name3(name2);
  REQUIRE( strcmp(*name3, "New String") == 0 );
}
