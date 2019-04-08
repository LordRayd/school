#include <iostream>
#include <string.h>
#include <stdio.h>

float inverse(int x){
	return 1.0f/x;
}

int main(){
	int n;
    std::cout << "Enter le nombre que vous souhaitez inverser : "; // no flush needed
    std::cin >> n;
	printf("%f",inverse(n));
	return 0;
}
