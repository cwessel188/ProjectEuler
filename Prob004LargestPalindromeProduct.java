/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 */


public class Prob004LargestPalindromeProduct {
	
	public static void main(String[] args) {
	
		// All palindromes are multiples of 11. 990 is the largest multiple of 11
		for (int i = 990; i > 99; i-=11) {
			
			// this loop starts at the highest 3-digit number and decrements until it finds a palindrome
			for (int j = 999; j > 99; j--) {
				if (isPalindrome(i * j)) {
					System.out.printf("Here is a palindrome made from the product of two 3-digit numbers is %d = %d * %d%n", i * j, j, i);
					break;
				}
			}
		}
	}
	
	/** Method to test if a query is a palindrome
	 * 
	 * @param query the number to be tested
	 * @return true if the query is a palindrome
	 */
	public static boolean isPalindrome(int query) {
		
		// the number of digits in query
		int numDigits = (int) Math.log10(query);		
		int[] digits = new int[numDigits+1];
		
		// fill the array with the digits of query
		int i = 0;
		while (query > 0) {								
			digits[i] = query % 10;
			query = query / 10;
			i++;
		}

		
		for (int j = 0; j <= digits.length/2; j++){
			// check each digit with the one it should match. if any don't match, return false.
			if (digits[j] != digits[numDigits-j]) {
				return false;
			}
		}
		
		return true;
		
	}
}
