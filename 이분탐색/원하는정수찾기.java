import java.util.Arrays;
import java.util.Scanner;

public class 원하는정수찾기 {
    static int[] A;
    static int n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        A=new int[n];
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }
        Arrays.sort(A);
        int find=sc.nextInt();
        int[] a=new int[find];
        for(int i=0;i<find;i++){
            a[i]=sc.nextInt();
        }
        for(int i=0;i<find;i++){
            if(isExist(a[i])==true)
                System.out.println(1);
            else
                System.out.println(0);
        }

    }

    public static boolean isExist(int v){
        int start=0;
        int end=n-1;
        while(start<=end){
            int midi=(start+end)/2;
            int midv=A[midi];
            if(midv>v){
                end=midi-1;
            }else if(midv<v){
                start=midi+1;
            }else{
                return true;
            }
        }
        return false;
    }
}
