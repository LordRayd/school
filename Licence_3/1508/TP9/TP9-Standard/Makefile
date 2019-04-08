CC=g++
CFLAGS=-Wall -Wextra -Werror -std=c++11 -fPIC
EXEC_NAME= RPG
EXEC_TEST_NAME= TESTRPG

RPGSDIR=src/
RPGTDIR=test/

RPGBSDIR =build/src/
RPGBTDIR=build/test/

HEADER_FILES= src/String.h src/Damageable.h src/Creature.h src/Item.h src/IntegerItem.h src/IntegerValue.h src/Dice.h src/Race.h src/Weapon.h src/CraftedWeapon.h src/LivingItem.h src/HatsuneMiku.h
OBJ_FILES =  $(RPGBSDIR)String.o $(RPGBSDIR)Damageable.o $(RPGBSDIR)Creature.o $(RPGBSDIR)Item.o $(RPGBSDIR)IntegerItem.o $(RPGBSDIR)IntegerValue.o $(RPGBSDIR)Dice.o $(RPGBSDIR)Race.o $(RPGBSDIR)Weapon.o $(RPGBSDIR)CraftedWeapon.o $(RPGBSDIR)LivingItem.o $(RPGBSDIR)HatsuneMiku.o

HEADER_TEST_FILES =
OBJ_TEST_FILES = $(RPGBTDIR)testMain.o  $(RPGBTDIR)testDamageable.o $(RPGBTDIR)testCraftedWeapon.o $(RPGBTDIR)testCreature.o $(RPGBTDIR)testDice.o $(RPGBTDIR)testIntegerValue.o $(RPGBTDIR)testItem.o $(RPGBTDIR)testRace.o $(RPGBTDIR)testString.o $(RPGBTDIR)testWeapon.o

OBJ_MAIN = $(RPGBSDIR)main.o

all :  $(EXEC_NAME)

$(EXEC_NAME) : $(OBJ_FILES) $(OBJ_MAIN) $(HEADER_FILES)
	$(CC) -o $(EXEC_NAME) $(OBJ_FILES) $(OBJ_MAIN)

$(RPGBSDIR)%.o: $(RPGSDIR)%.cpp $(HEADER_FILES)
	$(CC) -c $< -o $@ $(CFLAGS)

$(RPGBSDIR)%.o: $(RPGSDIR)%.c $(HEADER_FILES)
	$(CC) -c $< -o $@ $(CFLAGS)

clean :
	rm -rf $(OBJ_FILES) $(EXEC_NAME)

RunTest : test
	./$(EXEC_TEST_NAME)
test: $(OBJ_FILES) $(OBJ_TEST_FILES) $(HEADER_FILES) $(HEADER_TEST_FILES)
	$(CC) -o $(EXEC_TEST_NAME) $(OBJ_FILES) $(OBJ_TEST_FILES)

$(RPGBTDIR)%.o: $(RPGTDIR)%.cpp $(HEADER_FILES) $(HEADER_TEST_FILES)
	$(CC) -c $< -o $@ $(CFLAGS)

test-clean :
	rm -rf $(OBJ_TEST_FILES) $(EXEC_TEST_NAME)
