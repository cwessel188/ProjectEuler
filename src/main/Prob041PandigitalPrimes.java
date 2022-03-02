/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 
 * 2143 is a 4-digit pandigital and is also prime.
 *
 * What is the largest n-digit pandigital prime that exists?
 */

import java.util.ArrayList;
import java.util.List;

public class Prob041PandigitalPrimes {
	public static void main(String[] args) {
		// generate all primes below 1x10^7
		// all numbers containing 8 and 9 are multiples of 3: 1+2+3+4+5+6+7+8+9=45, 1+2+3+4+5+6+7+8=36
		List<Integer> primes = EulerUtils.generatePrimes(7654322); // 7654321 being the largest possible answer
		System.out.println("Primes generated.");
		
		ArrayList<Integer> digits = new ArrayList<Integer>();			// array to hold the digits of each primes tested
		int temp;
		
		// starting at the end of the list, start testing primes for the presence of all numbers
		for (int i = primes.size()-1; i > 0; i--) {
			temp = primes.get(i);
			digits.clear();
			// populate the array
			while (temp > 0) {
				digits.add(temp % 10);
				temp /= 10;
			}
			
			if (isPandigital(digits)) {
				System.out.printf("The largest pandigital prime in the range is %d.%n", primes.get(i));
				break;
			}
		}
	}
	
	/**
	 * A method to check to see if an array of length 9 contains each digit exactly once
	 * @param digits the ArrayList to be checked
	 * @return
	 */
	private static boolean isPandigital(ArrayList<Integer> digits){
		
		if (digits.contains(0)) {
			return false;
		}
		
		//check for digits
		for (int j = 1; j < digits.size() + 1; j++) {
			if (!digits.contains(j)) {
				return false;
			}
		}
		return true;
	}
}
