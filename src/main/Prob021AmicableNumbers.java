import java.util.ArrayList;
import java.util.List;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 *
 */

public class Prob021AmicableNumbers {
	
	 		
	// ArrayLists to hold the dividends
	private static ArrayList<Integer> divA = new ArrayList<Integer>();
	private static ArrayList<Integer> divB = new ArrayList<Integer>();
	
	public static void main(String[] args) {

		final int MAX = 10000;
		int sum = 0;
		
		for (int i = 1; i < MAX; i++) {
			
			divA = EulerUtils.getDivisors(i);			// calculates divA once per i instead of once per j.
			for (int j = i+1; j < MAX; j++) {
				if (j == i + 1 && i % 100 == 0) {
//					System.out.println(i); 				// primitive progress bar
				}
				if (isAmicable(i, j)) {
					System.out.printf("(%d, %d) is an amicable pair.%n", i, j);
					sum += i;
					sum += j;
				}
			}
		}
		System.out.printf("The sum of all amicable numbers below %d is %d", MAX, sum);
		
	}
	/**
	 * Compares two integers and returns true if they are amicable
	 * @param a
	 * @param b
	 * @return true if a and b are amicable
	 */
	public static boolean isAmicable(int a, int b) {
		if (a == b) {
			return false;
		}

		divB = EulerUtils.getDivisors(b);
		
		return (sumList(divA) == b && sumList(divB) == a);
	}
/**
 * Returns the sum of all terms in an ArrayList
 * @param list the ArrayList to be summed
 * @return the sum
 */
	public static int sumList(List<Integer> list) {
		int sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}
		
		return sum;
	}
}
