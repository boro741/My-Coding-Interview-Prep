// A C++ program to find the number of digits in 
// a factorial 
/*
    A naive solution would be to calculate the n! first and then calculate the 
    number of digits present in it. However as the value for n! can be very large,
    it would become cumbersome to store them in a variable (Unless you’re working 
    in python!) .
    A better solution would be to use the useful property of logarithms to 
    calculate the required answer.



    BETTER APPROACH::
    ===========================
    We know,
    log(a*b) = log(a) + log(b)
    
    Therefore
    log( n! ) = log(1*2*3....... * n) 
              = log(1) + log(2) + ........ +log(n)
    
    Now, observe that the floor value of log base 
    10 increased by 1, of any number, gives the
    number of digits present in that number.
    
    Hence, output would be : floor(log(n!)) + 1.
*/


#include <iostream> 
#include <cmath>
using namespace std; 

// This function receives an integer n, and returns 
// the number of digits present in n! 
int findDigits(int n) 
{ 
	// factorial exists only for n>=0 
	if (n < 0) 
		return 0; 

	// base case 
	if (n <= 1) 
		return 1; 

	// else iterate through n and calculate the 
	// value 
	double digits = 0; 
	for (int i=2; i<=n; i++) 
		digits += log10(i); 

	return floor(digits) + 1; 
} 

// Driver code 
int main() 
{ 
	cout << findDigits(1) << endl; 
	cout << findDigits(5) << endl; 
	cout << findDigits(10) << endl; 
	cout << findDigits(120) << endl; 
	return 0; 
} 
