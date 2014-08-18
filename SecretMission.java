/*
 *You are given a function 'secret()' that accepts a single integer parameter and returns an integer. 
 *In a language of your choice, write an application that determines if this function is an additive 
 *function [ secret(x+y) = secret(x) + secret(y) ] for all prime numbers under N where N is a given integer.
 */

import java.util.Arrays;

public class SecretMission{

     public static void main(String []args){
        
        int max= Integer.parseInt(args[0]);
        
        int [] primeNum = optimusPrime(max);
        
        if(testSecret(primeNum))
        System.out.println("Secret() is an additive function");
        else
        System.out.println("Secret() is not an additive function");
        
     }
     
private static int [] optimusPrime (int N) {

        // Initially set all integers to prime
        boolean[] isPrime = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }
    
        //check to see if numbers are prime
        //check to make sure that multiples of any numbers
        //before the max, N, are marked as non-Prime or false
        for (int i = 2; i*i <= N; i++) {

        if (isPrime[i]) {
                for (int j = i; i*j <= N; j++) {
                    isPrime[i*j] = false;
                }
            }
        }

        //Count the primes
       int primes = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) 
            primes++;    
        }
      
      //to add primes to an array
        int [] primeNum = new int [primes];
        int index = 0;
         
         for (int i = 2; i <= N; i++) {
        if (isPrime [i]) 
        primeNum [index++] = i;
        }
        
     return primeNum;
}


private static boolean testSecret(int[] tPrime)
{
  
    //set up two arrays equal to the array with the prime numbers
    int [] oPrime = tPrime;
    int [] sPrime = tPrime;
    
    int additive1 = 0;
    int additive2 = 0;
    
    //for each prime number in the arrays
    //compare additive functions for each number
    for (int a : oPrime){
        
        for (int b : sPrime){ 
        additive1 = secret(a + b);
        additive2 = secret(a) + secret(b);
        }

}

    if (additive1 == additive2)
    {return true;}
    else
    {return false;}
       
    
}

private static int secret (int n){
    return n;
}


}
