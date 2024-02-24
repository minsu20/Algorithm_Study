import java.util.*;
import java.io.*;

public class _1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] map=new int[n+1][3];
        for(int i=1;i<n+1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<3;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp=new int[n+1][3];
        for(int i=0;i<3;i++){
            dp[1][i]=map[1][i];
        }
        for(int i=2;i<n+1;i++){
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+map[i][0];
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+map[i][1];
            dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+map[i][2];
        }
        int min=dp[n][0];
        for(int i=1;i<3;i++){
            if(dp[n][i]<min){
                min=dp[n][i];
            }
        }
        System.out.println(min);
    }
}
