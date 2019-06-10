#include<iostream>
using namespace std;


/*
void multiply(int a,int b,int res){
    if(b == 0){
        cout<<res<<endl;
    }else{
        int last = b % 10;
        int rem = b / 10;
        res = res + (a * last);
        multiply(a*10,rem,res);
    }
}*/



void printArr(int i,int arr[]){
    int j = (arr[i+1] == 0 ) ? i : i+1;
    while(j >= 0){
        cout<<arr[j];
        j--;
    }
    
}

void store(int arr[],int res,int i){
    //static int count = 0;
    int carry = 0;
    while(res != 0){
        //count++;
        int last = res % 10;
        int tempVal = arr[i] + last;
        arr[i] = tempVal % 10 + carry;
        carry = ( tempVal >= 10 ) ? 1:0 ;
        res = res / 10;
        i++;
    }
    //cout<<count<<endl;
}

void multiplyIter(int a,int b){
    int i = 0;
    int arr[100] = {0};
    
    while(b != 0){
        int lastB = b % 10;
        int res = a * lastB;
        b = b / 10;
        store(arr,res,i);
        i++;
    }
    
    printArr(i,arr);
}

int main(){
    
    multiplyIter(111,12345678);
    
    cout<<endl;
    
    return 0;
}
