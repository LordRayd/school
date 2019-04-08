#include <stdio.h>

double inverse(double x){
	return 1/x;
}

int main(){
	double res;
	printf("Enter a number \n");
	scanf("%lf",&res);
	printf("%.2lf \n",inverse(res));

}