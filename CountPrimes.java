package leetcode;

/**
 * @Classname CountPrimes
 * @Description TODO
 * @Date 2020/3/28 15:51
 * @Created by 14241
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {
    public static void main(String[] args) {
        int n=10;
        System.out.println(countPrimes(n));

    }
    public static int countPrimes(int n) {
        int count=0;
        for(int i=1;i<n;i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;

    }

    private static boolean isPrime(int num){
        if(num<=1){
            return false;
        }
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
