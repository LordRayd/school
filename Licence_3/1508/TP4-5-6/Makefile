# fichier makefile
RPGSDIR =./src
RPGBDIR =./build

all :  mkbuild Run

RPG : main.o
	$(RPGBDIR)/main.o
main.o	: String.o Damageable.o Item.o Creature.o IntegerItem.o IntegerValue.o Dice.o Race.o Weapon.o CraftedWeapon.o
	g++ $(RPGSDIR)/main.cpp $(RPGBDIR)/String.o $(RPGBDIR)/Damageable.o $(RPGBDIR)/Item.o $(RPGBDIR)/Creature.o $(RPGBDIR)/IntegerItem.o $(RPGBDIR)/IntegerValue.o $(RPGBDIR)/Dice.o $(RPGBDIR)/Race.o $(RPGBDIR)/Weapon.o $(RPGBDIR)/CraftedWeapon.o -o $(RPGBDIR)/main.o
String.o	:
	g++ -c $(RPGSDIR)/String.cpp -o $(RPGBDIR)/String.o
Damageable.o : String.o
	g++ -c  $(RPGSDIR)/Damageable.cpp -o $(RPGBDIR)/Damageable.o
Item.o : String.o Damageable.o
	g++ -c $(RPGSDIR)/Item.cpp -o $(RPGBDIR)/Item.o
Creature.o : String.o Damageable.o
	g++ -c $(RPGSDIR)/Creature.cpp -o $(RPGBDIR)/Creature.o
IntegerItem.o :
	g++ -c $(RPGSDIR)/IntegerItem.cpp -o $(RPGBDIR)/IntegerItem.o
IntegerValue.o : IntegerItem.o
	g++ -c $(RPGSDIR)/IntegerValue.cpp $(RPGBDIR)/IntegerItem.o -o $(RPGBDIR)/IntegerValue.o
Dice.o : IntegerItem.o
	g++ -c $(RPGSDIR)/Dice.cpp $(RPGBDIR)/IntegerItem.o -o $(RPGBDIR)/Dice.o
Race.o : IntegerItem.o
	g++ -c $(RPGSDIR)/Race.cpp $(RPGBDIR)/IntegerItem.o $(RPGBDIR)/IntegerValue.o -o $(RPGBDIR)/Race.o
Weapon.o : IntegerItem.o
	g++ -c $(RPGSDIR)/Weapon.cpp $(RPGBDIR)/IntegerItem.o -o $(RPGBDIR)/Weapon.o
CraftedWeapon.o : Weapon.o Item.o
	g++ -c $(RPGSDIR)/CraftedWeapon.cpp $(RPGBDIR)/Weapon.o $(RPGBDIR)/Item.o -o $(RPGBDIR)/CraftedWeapon.o

mkbuild :
	mkdir -p build;
Run	: RPG
clean	:
	rm -Rf build


