import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by priyankvex on 25/1/18.
 */
public class AggressiveCows {

    public static void main(String[] args) throws java.lang.Exception{

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0){

            StringTokenizer st;
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[] a = new int[k];

            for (int i = 0; i < k; i++){
                a[i] = Integer.parseInt(br.readLine());
            }

            AggressiveCows aggressiveCows = new AggressiveCows();

            int temp = aggressiveCows.solve(a, k, c);

            System.out.println(temp);
        }
    }

    private int solve(int[] a, int k, int c){
        Arrays.sort(a);
        // System.out.println(Arrays.toString(a));
        int low = 0, high = a[k-1]-a[0]+1;
        while (high - low > 1){
            int mid = (high+low)>>1;
//            System.out.println("Mid : " + mid);
//            System.out.println("Low : " + low);
//            System.out.println("High : " + high);
            if (isValid(a, mid, c)){
                low=mid;
            }
            else{
                high = mid;
                // System.out.println("high : " + high);
            }
        }
        return low;
    }

    private boolean isValid(int[] a, int d, int c){

        int count = 1, lastCow = a[0];
        for (int i = 1; i < a.length; i++){

            if (a[i]-lastCow >= d){
                count++;
                lastCow = a[i];
            }
        }
        // System.out.println("Count : " + count);
        return count >= c;
    }
}

