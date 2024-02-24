import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2579 {
    static int num;
    static int[] val;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        num = Integer.parseInt(st.nextToken());
        val = new int[num + 1];
        dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            val[i] = Integer.parseInt(st.nextToken());
        }
        if (num == 1) {
            System.out.println(val[1]);
        } else if (num == 2) {
            System.out.println(val[1] + val[2]);
        } else {
            DP();
            System.out.println(dp[num]);
        }
    }

    public static void DP() {
        dp[1] = val[1];
        dp[2] = val[1]+val[2];
        for (int i = 3; i <= num; i++) {
                dp[i]=Math.max(dp[i-2]+val[i],dp[i-3]+val[i-1]+val[i]);
        }
    }

}
