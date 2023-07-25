import java.util.*;
import java.io.*;
public class _1003 {
    static int[][] result=new int[41][2];
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Integer T=Integer.parseInt(br.readLine());
        input=new int[T];
        int max=-1;
        for(int i=0;i<T;i++){
            input[i]=Integer.parseInt(br.readLine());
            max=Math.max(input[i],max);
        }

        for(int i=0;i<T;i++){
            fibonacci(max);
            System.out.println(result[input[i]][0]+" "+result[input[i]][1]);
        }
    }

    public static void fibonacci(int n){
        result[0][0]=1;
        result[0][1]=0;

        result[1][0]=0;
        result[1][1]=1;

        if(n>1){
            int index=2;
            while(true){
                result[index][0]=result[index-1][0]+result[index-2][0];
                result[index][1]=result[index-1][1]+result[index-2][1];

                if(index==n)
                    break;
                index++;
            }
        }
    }
}
