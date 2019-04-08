#include <iostream>
#include <string.h>
#include <stdio.h>

int divisible(int a, int b){
	return a%b;
}

int divisible(int* a, int* b){
	return *a%*b;
}
void affichage(int a, int b, int x){
	if(x==0){
		printf("%d %s %d\n",a,"est divisible par", b);
	}else{
		printf("%d %s %d\n",a,"n est pas divisible par", b);
	}
}

int main(){
	int a[] = {50};
	int b[] = {3};
	affichage(50, 3,divisible(50,2));
	affichage(50, 3,divisible(a,b));
	return 0;
}

