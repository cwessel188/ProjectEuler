
/*
The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating them in any order the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.

Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
 */

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Prob60PrimePairSets {

    private static final int RANGE = 100;
    public static final int SET_SIZE = 4;

    private static Set<Integer> primeSet;
    private static List<Integer> primeList;
    private static Map<Integer, Boolean> memo = new HashMap<>();

    public static void main(String... args) {

        // generate Primes
        // for the set 0 < n < 1000, need 1,000,000 primes for room concatenating
        primeList = EulerUtils.generatePrimes(RANGE * RANGE);
        primeSet = new HashSet<>(primeList);

        List<Integer> testSet = new ArrayList<>(); // ordered Set idk
        List<Integer> resultlist = new ArrayList<>();
        // iterate over primes
        for (int prime : primeList) {
            testSet.clear();
            testSet.add(prime);
            resultlist = recurse(prime, testSet);
        }


        System.out.print("set: ");
        int sum = 0;
        if (Objects.nonNull(resultlist)) {
            for (int n : resultlist) {
                sum += n;
                System.out.print(n + ", ");
            }
        }


        System.out.println("sum: " + sum);


    }

    // recursive part
    private static List<Integer> recurse(int n, List<Integer> testset) {
        if (testset.size() >= SET_SIZE) {
            // we won
            return testset;
        }


        Iterator<Integer> iter = primeList.stream().iterator();

        // start at idx of n -1
        for (int i = 0; i < primeList.indexOf(n); i++) {
            iter.next();
        }
        // base cases
        if (!iter.hasNext()) {
            // we failed
            return null;
        }
        iter.next();

        ArrayList<Integer> clone = new ArrayList<>(testset);
        boolean stillprime = true;
        int p = 0;

        while (iter.hasNext()) {
            p = iter.next();
            stillprime = true;
            // compare the currPrime to the set
            for (int q : testset) {
                int primeToTest = EulerUtils.concat(p, q);
                if (stillprime && !primeSet.contains(primeToTest)) {
                    // we prime! reverse!
                    stillprime = false;

                }
                primeToTest = EulerUtils.concat(q, p);
                if (stillprime && !primeSet.contains(primeToTest)) {
                    stillprime = false;
                    System.out.println(primeToTest);
                }

                if (stillprime) {
                    clone.add(p);
                    recurse(primeList.get(primeList.indexOf(p) + 1), clone);
                }
            } // for

        }

        return clone;

    }
}
