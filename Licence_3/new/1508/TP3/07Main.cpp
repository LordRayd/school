#include <string.h>
#include <stdio.h>
#include <cstdlib>
#include "07Array.cpp"

int main(int argc, char * argv[]){
	float *a = (float*) malloc(sizeof(float)*6);
	*a = 5.3;
	a++;
	*a = 1.6;
	a++;
	*a = 5.1;
	a++;
	*a = 4.3;
	a++;
	*a = 6.5;
	a++;
	*a = 6.7;
	//float b[] = copyFromArrayOfPtr(a,2);
	//affichage(b);
	return 0;
}
