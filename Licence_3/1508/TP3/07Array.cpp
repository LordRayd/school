#include <string.h>
#include <stdio.h>
float* copyFromArrayOfPtr(float* a, int n){
	float ret[n];
	int i;
	for(i=0; i<n; i++){
		ret[i] = *a;
		a++;
	}
	return ret;
}

void affichage(float* a){
	while(*a){
		printf("%f\n",*a);
		a++;
	}
}
