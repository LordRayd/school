#include "Damageable.cpp"
#include <iostream>

int main(int argc, char * argv[]){
	String *name = new String("Knight");
	rpg:Damageable knight(12.0,*name);
	std::cout << "HP : " << knight.getHitPoints() << std::endl;
	
	knight.damage(8.0);
	std::cout << "HP : " << knight.getHitPoints() << std::endl;
	
	knight.healRepair(6);
	std::cout << "HP : " << knight.getHitPoints() << std::endl;
	
	knight.damage(52);
	std::cout << "HP : " << knight.getHitPoints() << std::endl;
	std::cout << "Chevalier mort ?  " << knight.isDead() << std::endl;
	
	knight.healRepair(8);
	std::cout << "HP : " << knight.getHitPoints() << std::endl;
	std::cout << "Chevalier mort ?  " << knight.isDead() << std::endl;
}
