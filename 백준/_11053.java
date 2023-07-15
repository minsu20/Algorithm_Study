import java.io.*;
import java.util.*;
public class _11053 {

    static int N;
    static int[] seq;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        seq=new int[N];
        dp=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        for(int i=0;i<N;i++){
            seq[i]=Integer.parseInt(st.nextToken());
        }

        System.out.println(DP());
    }

    public static int DP(){
        for(int i=0;i<N;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(seq[j]<seq[i]&&dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
        }

        int max=-1;
        for(int i=0;i<N;i++){
            max=Math.max(max,dp[i]);
        }

        return max;
    }
}
