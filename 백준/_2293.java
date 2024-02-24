import java.util.*;
import java.io.*;
public class _2293 {
    static int n, result;
    static int[] coins, ways;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n=Integer.parseInt(st.nextToken());
        result=Integer.parseInt(st.nextToken());

        coins=new int[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            coins[i]= Integer.parseInt(st.nextToken());
        }
        ways=new int[result+1];
        ways[0]=1;
        Arrays.sort(coins);
        solve();
        System.out.println(ways[result]);
    }
    public static void solve(){
        for(int i=0;i<n;i++){
            for(int j=coins[i];j<=result;j++){
                ways[j]+=ways[j-coins[i]];
            }
        }
    }
}
