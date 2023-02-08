import java.util.Scanner;

public class 구간합구하기 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int input[]=new int[N+1];
        input[0]=0;
        for(int i=1;i<=N;i++){
            input[i]=sc.nextInt();
        }
        int sum[]=new int[N+1];
        sum[0]=0;
        for(int i=1;i<=N;i++){
            sum[i]=sum[i-1]+input[i];
        }
        int result[]=new int[M];
        for(int i=0;i<M;i++){
            int start=sc.nextInt();
            int end=sc.nextInt();
            result[i] =sum[end]-sum[start-1];
        }
        for(int i=0;i<M;i++){
            System.out.println(result[i]);
        }
    }
}
