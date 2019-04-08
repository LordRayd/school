#include <string.h>
#include <stdio.h>

float* copyFromArray(float* a, int n){
	float * ret = new float[n];
	float * pos = ret;
	int i;
	for(i=0; i<n; i++){
		*ret = *a;
		ret++;
		a++;
	}
	ret = pos;
	return ret;
}
void affichage(float* a){
	while(*a){
		printf("%f\n",*a);
		a++;
	}
}

int main(int argc, char * argv[]){
	float a[] = {5.3,1.6,5.1,4.3,6.5,6.7};
	float* b = copyFromArray(a,2);
	affichage(b);
	return 0;
}

