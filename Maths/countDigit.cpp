#include<iostream>
#include <cmath>
using namespace std;

void countDigit(int n){
	int count = floor(log10(n) + 1);
	cout<<count;
}

int main(){   
	
	countDigit(2019);

	cout<<endl;
	return 0;
}