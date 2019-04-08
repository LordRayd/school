#include <string.h>
#include <stdio.h>
#include <cstdlib>

int main(int argc, char * argv[]){
	
	//============== 1 KBYTE =============
	//Allocation Pile (Stack)
	//int *a = 
	
	//Allocation Tas (Heap)
	int *b = (int*)malloc(1000);
	
	
	//============== 1 MGBYTE =============
	//Allocation Pile (Stack)
	//int *c = 
	
	//Allocation Tas (Heap)
	int *d = (int*)malloc(1000000);
	
	
	//============== 1 GBYTE =============
	//Allocation Pile (Stack)
	//int *e = 
	
	//Allocation Tas (Heap)
	int *f = (int*)malloc(1000000000);
	
	
	//============== 10 GBYTE =============
	//Allocation Pile (Stack)
	//int *g = 
	
	//Allocation Tas (Heap)
	int *h = (int*)malloc(10000000000);
	
	
}
