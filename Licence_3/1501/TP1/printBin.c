#include <stdio.h>  // printf

void printbin(unsigned val){
	int i;
	unsigned un = 1 << sizeof(unsigned)*8-1;
	for(i=0;i < sizeof(unsigned)*8;i++){
		if(un & val)
			printf("1");
		else
			printf("0");
		un >>=1;
	}
	printf("\n");
}

unsigned decalage(unsigned val, int decale){
	return (val << decale) | (val >> sizeof(unsigned)*8-decale);
}

unsigned multiplication(unsigned val1, unsigned val2){
	int i;
	int val = 0;
	unsigned un = 1;
	for(i=0; i < sizeof(unsigned)*8; i++){
		if(un & val2) val += val1;
		val2 >>= 1;
		val1 <<= 1;
	}
	return val;
}

void Complement2(){
	char var = 5;
	var = ~var+1;
	printf("%hhd",var);
}
void main(){
	//unsigned val = 0x3F0E;
	//printBin(val); 
	
	//unsigned U = 0xA2453F0E; //(10100010 010001001 00111111 00001110)
	//printbin(U);
	//int G = 8;
	//printbin(decalage(U,G));
	
	unsigned op1 = 17; //<- 00010001 (17)
	printbin(op1);
	unsigned op2 = 5; //<- 00000101
	printbin(op2);
	printbin(multiplication(op1, op2)); // 01010101
}
