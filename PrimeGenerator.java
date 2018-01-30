import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by priyankvex on 30/1/18.
 */
public class PrimeGenerator {

    public static void main(String[] args) throws Exception{

        PrimeGenerator p = new PrimeGenerator();

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());


        while (t-- > 0) {

            StringTokenizer st;
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            p.segmentedSieve(m, n);

            System.out.print("\n");

        }

    }

    private void segmentedSieve(int m, int n){

        int limit = (int)Math.floor(Math.sqrt(n)) + 1;
        //System.out.println(limit);
        Vector<Integer> basePrimes = getBasePrimes(limit);

        for (int i : basePrimes){
            if (i >= m && i <= n){
                System.out.println(i);
            }
        }


        boolean[] isPrime = new boolean[n-m+1];
        Arrays.fill(isPrime, true);

        for (int prime : basePrimes){

            int lowLimit = (int)Math.floor(m/prime)*prime;
            if (lowLimit < m){
                lowLimit+=prime;
            }
            //System.out.println("Low limit " + lowLimit);
            for (int i = lowLimit; i <= n; i+=prime){
                isPrime[i-m]=false;
            }
        }


        for (int i = m; i <=n ; i++){
            if (isPrime[i-m]){
                if (i != 1 && i != 0){
                    System.out.println(i);
                }
            }
        }
    }

    private Vector<Integer> getBasePrimes(int limit){

        boolean[] isPrime = new boolean[limit+1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i*i < limit; i++){
            if (isPrime[i]){
                for (int j = i*2; j < limit; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        Vector<Integer> primes = new Vector<>();
        for (int i = 2; i < limit; i++){
            if (isPrime[i]){
                primes.add(i);
            }
        }

        return primes;
    }
}

