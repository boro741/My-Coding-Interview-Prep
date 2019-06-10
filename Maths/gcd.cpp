#include<iostream>

int gcd(int a,int  b)
{
    if (a == 0)
        return b;

    return gcd(b % a, a);
}

int gcdIter(int a,int b){
     while (a != b) { 
        if (a > b)         
            a = a - b;         
        else        
            b = b - a;         
    } 
    return a; 
}

int main(){

    gcd(2,3);

    return 0;
}

/*
    GCD: 30, 42

            GCD: 42 % 30 , 30
                  

*/