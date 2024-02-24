import java.util.*;
import java.io.*;
public class _11052 {

    static int n, ans;
    static int[] ps;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ps = new int[n + 1];
        dp=new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            ps[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<i+1;j++){
                dp[i]=Math.max(dp[i], dp[i-j]+ps[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
