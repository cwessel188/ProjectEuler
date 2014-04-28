import java.util.ArrayList;
import java.util.Collections;

/**The radical of n, rad(n), is the product of the distinct prime factors of n. For example, 504 = 2^3 × 3^2 × 7, so rad(504) = 2 × 3 × 7 = 42.
 *
 * If we calculate rad(n) for 1 ≤ n ≤ 10, then sort them on rad(n), and sorting on n if the radical values are equal, we get:
 * 
 * 	n	rad(n)	k
 * 	1	  1		1	
 * 	2	  2		2
 * 	4	  2		3
 * 	8	  2 	4
 * 	3	  3		5
 * 	9	  3		6
 * 	5	  5		7
 * 	6	  6		8
 * 	7	  7		9
 * 	10	  10	10	
 * 
 * Let E(k) be the kth element in the sorted n column; for example, E(4) = 8 and E(6) = 9.
 *
 * If rad(n) is sorted for 1 ≤ n ≤ 100000, find E(10000).
 */

public class Prob124OrederedRadicals {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		final int INPUT = 100000;
		final int MOD = 100003;
		int i, tempi;
		long product;
		ArrayList<Integer> temp = new ArrayList<Integer>(); // list to hold the prime factors 
		ArrayList<Integer> inputFactors = new ArrayList<Integer>(); // the  
		ArrayList<Long> pairs = new ArrayList<Long>(); // a list to hold all the n  rad(n) pairs
		
		// find all the primes below INPUT
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes = EulerMethods.generatePrimes(INPUT);
		
		for (int n = 1; n < INPUT+1; n++) {
			 
			// find the prime factors of INPUT
			inputFactors = EulerMethods.getPrimeFactors(n, primes);
	//		System.out.printf("the prime factors of %d are %s%n", n, inputFactors);
			
			// find the the discrete prime factors, given the List of prime factors
			for (i = 0; i < inputFactors.size(); i++) {
				tempi = inputFactors.get(i);
				while (i < inputFactors.size()-1 && tempi == inputFactors.get(i+1)) {
					inputFactors.remove(i+1);
				}
			}
			
	//		System.out.printf("the discrete prime factors of %d are %s%n", n, inputFactors);
			
			// generate rad(n) value
			product = 1;
			for (i = 0; i < inputFactors.size(); i++) {
				product *= inputFactors.get(i);
			}
			
			// add the pair rad(n), n, to an ArrayList
			long pair = (product * MOD) + n;
			pairs.add(pair);
			
			// INPUT is pair%mod, product is pair/mod
	//		System.out.printf("%d, %d%n", pair%MOD, pair / MOD);
		
			inputFactors.clear();
		}
		
	//	System.out.println(pairs);
		Collections.sort(pairs);
		System.out.println(pairs);
		
	//	System.out.printf("the %dth k is %d%n", 10000, pairs.get(9999) %MOD );
		System.out.println(pairs.get(9999) %MOD );
		
		

	}
}
