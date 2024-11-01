/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prime;

/**
 *
 * @author Lam Tan Phat - CE181023
 */
public class Prime {
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true; 
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false; 
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int[] testNumbers = {1, 2, 3, 4, 5, 16, 17, 19, 23, 24, 29, 97};

        for (int number : testNumbers) {
            if (isPrime(number)) {
            } else {
            }
        }
    }
}

