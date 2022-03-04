
/* The Fibonacci sequence is defined by the recurrence relation:

        Fn = Fn?1 + Fn?2, where F1 = 1 and F2 = 1.
        Hence the first 12 terms will be:

        F1 = 1
        F2 = 1
        F3 = 2
        F4 = 3
        F5 = 5
        F6 = 8
        F7 = 13
        F8 = 21
        F9 = 34
        F10 = 55
        F11 = 89
        F12 = 144
        The 12th term, F12, is the first term to contain three digits.

        What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
*/


import java.math.BigInteger;
import java.util.List;

public class Prob25ThousandDigitFibo {

    private static final int DIGITS = 1000;

    public static void main(String... args) {

        int result = -1;

        // The brutest of force
        List<BigInteger> fibonacciNumbers = EulerUtils.generateFibosUpToMax(BigInteger.TEN.pow(DIGITS));

        for (BigInteger i : fibonacciNumbers) {
            if (countDigits(i) == DIGITS) {
                result = fibonacciNumbers.indexOf(i);
                result++; // change 0-index to 1-index
                break;
            }
        }

        System.out.println(result);
        // return

    }

    public static int countDigits(BigInteger n) {
        int count = 0;        // make n positive

        while (n.compareTo(BigInteger.ZERO) > 0) {
            count++;
            n = n.divide(BigInteger.TEN);
        }

        return count;
    }
}
