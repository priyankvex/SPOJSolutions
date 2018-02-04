import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by priyankvex on 4/2/18.
 */
public class BytelandianCoin {

    HashMap<Integer, Long> cache = new HashMap<>();

    public static void main(String[] args) throws Exception{

        BytelandianCoin b = new BytelandianCoin();

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        while (true){
            String s = (br.readLine());
            try{
                int t = Integer.parseInt(s);
                long max = b.solve(t);
                System.out.println(max);
            }
            catch (Exception e){
                break;
            }

        }

    }

    private long solve(int n){

        if (n == 0){
            return n;
        }

        if (cache.get(n) != null){
            return cache.get(n);
        }

        long n1 = solve(n/2);
        long n2 = solve(n/3);
        long n3 = solve(n/4);

        long max = Math.max(n, (n1+n2+n3));
        cache.put(n, max);
        return max;

    }
}

