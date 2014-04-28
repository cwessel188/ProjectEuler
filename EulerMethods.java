import java.util.ArrayList;


public class EulerMethods {
	
	public static void main(String[]args) {
		ArrayList<Integer> primes = generatePrimes(20);
		
		System.out.println(primes);
		
		int test = 120;
		
		System.out.printf("prime factors of %d: %s%n", test, getPrimeFactors(test, primes));
		System.out.printf("Divisors of %d: %s%n", test, getDivisors(test));
	}
	
	/**Generates all primes between 1 and n
	 * 
	 * @param n the maximum number to be returned
	 * @return an ArrayList of all primes below n
	 */
	public static ArrayList<Integer> generatePrimes(int n) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int i;
		boolean[] primeArray = new boolean[n];
		
		primeArray[1] = true; // makes sure 1 isn't listed as a prime number. 
		
		for (i = 2; i< n/2; i++) {
			if (primeArray[i] == false) {
				for ( int j = 2*i; j < n; j+=i) { // starting at 2i, mark each multiple of i as not prime.
					primeArray[j] = true;
				}
			}
		}
		
		for (i = 1; i < n; i++) {
			if (primeArray[i] == false) {
				primes.add(i);
			}
		}
	//	System.out.println(primes);  //optional print statement
		return primes;
	}
	
	/** Returns the number of factors of a given number n
	 * 
	 * @param n the number to factor
	 * @return the number of factors of n
	 */
	public static int findNumDivisors(int n) {
		int factors = 0;
		
		
		if (n%2 == 0) 
			factors++;
		if (n%3 == 0)
			factors++;
			
		// test for factors up to 1/4th the number
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n%i == 0) {
	//			System.out.println(i);  // optional print statement for the factors
				factors+= 2;
			}
		}
	
		return factors;
	}
	
	/** Returns an ArrayList with the factors of an input
	 * 
	 * @param n the number to process
	 * @return an ArrayList with the factors of n
	 */
	public static ArrayList<Integer> getDivisors(int n) {
		
		ArrayList<Integer> factors = new ArrayList<Integer>();
		
		// test for factors up to 1/4th the number
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n%i == 0) {
	//			System.out.println(i);  // optional print statement for the factors
				factors.add(i);
				factors.add(n / i);
			}
		}

		return factors;
	}
	
	/** Returns an ArrayList with the factors of an input
	 * 
	 * @param n the number to process
	 * @param primes an array containing prime numbers to compare to
	 * @return an ArrayList with the factors of n
	 */
	public static ArrayList<Integer> getPrimeFactors(int n, ArrayList<Integer> primes) {
		
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		
		// test for factors up to 1/4th the number
		for (int i = 1; i < n/2+1; i++) {
			if (n%i == 0 && primes.contains(i)) {
	//			System.out.println(i);  // optional print statement for the factors
				multiFactorCheck(n, i, primeFactors);
			}
		}
		
		if (primeFactors.isEmpty())
			primeFactors.add(n);
		
		return primeFactors;
	}
	
     /** Recursive method to find the number of times a prime is a factor of a number 
	  *  each successful recursion adds an integer to primeFactors
	  * 
	  * @param n the number being tested
	  * @param p the prime tested for
	  * @param primeFactors an ArrayList that holds the factors
	  */
	private static void multiFactorCheck(int n, int p, ArrayList<Integer> primeFactors) {
		 if (n % p == 0) {
			 primeFactors.add(p);
			 multiFactorCheck(n / p, p, primeFactors);
		 }
	}
}
