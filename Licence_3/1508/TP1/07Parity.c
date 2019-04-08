#include <stdio.h>

int main(int argc, char * argv[]){
	int val;
	scanf("%d", &val);
	if( (val % 2) == 0){
		printf("pair\n");
	}else{
		printf("impair\n");
	}
	return 0;
}
