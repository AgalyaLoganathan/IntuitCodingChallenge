package Intuit;

/**
 * Created by agalya on 1/23/16.
 */
public class PrimeFinder {
    private boolean isPrime(int candidate) {
        if (candidate <= 1) return false;
        if (candidate == 2 || candidate == 3) return true;
        int upperLimit = (int) Math.sqrt(candidate);
        for (int i = 2; i <= upperLimit; i++) {
            if (candidate % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int findNthPrime(int n) {
        if (n <= 0) return -1; // invalid input
        if (n == 1 || n == 2) return n + 1; // to account for 2 and 3
        int countOfPrimeNumbers = 2; // to account for first 2 prime numbers
        int candidate = 3;

        while (countOfPrimeNumbers < n) {
            candidate += 2; // consider only odd numbers
            if (isPrime(candidate)) {
                countOfPrimeNumbers++;
            }
        }

        return candidate;
    }

    public static void main(String args[]) {
        PrimeFinder primeFinder = new PrimeFinder();
        int[] input = new int[]{1, 2, 3, 58, 98, 100001};
        for (int i = 0; i < input.length; i++) {
            System.out.println("Prime #" + input[i] + " is: " + primeFinder.findNthPrime(input[i]));
        }
    }
}
