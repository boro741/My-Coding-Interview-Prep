import java.util.Arrays;

class javaTest {

    static int maxAND(int L, int R)  
{  
  
    // If there is only a single value  
    // in the range [L, R]  
    if (L == R)  
        return L;  
  
    // If there are only two values  
    // in the range [L, R]  
    else if ((R - L) == 1)  
        return (R & L);  
    else {  
        if (((R - 1) & R) > ((R - 2) & (R - 1)))  
            return ((R - 1) & R);  
        else
            return ((R - 2) & (R - 1));  
    }  
}  
  
// Driver code  
public static void main(String[] args)  
{  
    int L = 4, R = 8;  
    System.out.println(maxAND(L, R));  
}
}




//https://www.geeksforgeeks.org/maximum-bitwise-and-pair-from-given-range/