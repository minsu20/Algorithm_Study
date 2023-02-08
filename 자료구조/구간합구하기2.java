import java.util.Scanner;

public class 구간합구하기2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int[][] array=new int[N+1][N+1];
        int[][] sum=new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                array[i][j]=sc.nextInt();
                sum[i][j]=sum[i][j-1]+sum[i-1][j]-sum[i-1][j-1]+array[i][j];
            }
        }
        int[] result=new int[M];
        for(int i=0;i<M;i++){
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            int x2=sc.nextInt();
            int y2=sc.nextInt();
            result[i]=sum[x2][y2]-sum[x1-1][y2]-sum[x2][y1-1]+sum[x1-1][y1-1];
            System.out.println(result[i]);
        }
    }
}
