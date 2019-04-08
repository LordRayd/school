# fichier makefile
all :  Exercice4_t.o testDamageable
testDamageable : testDamageable.o Exercice4_t.o Exercice3_t.o
	g++ -o testDamageable tesDamageable.o Exercice3_t.o Exercice4_t.o
testDamageable.o : testDamageable.cpp Exercice3.h Exercice4_t.o
	g++ -c -o testDamageable.o testDamageable.c
Exercice4_t.o : Exercice3.h Exercice4.cpp Exercice4.h
	g++ -c -o Exercice4_t.o Exercice4.cpp
Exercice3_t.o : Exercice3.cpp Exercice3.h
	g++ -c -o Exercice3_t.o Exercice3.cpp
clean	:
	rm -f *.o

