import java.util.Scanner;

public class 블루레이 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int[] A=new int[N];
        int start=0;
        int end=0;
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
            if(start<A[i])
                start=A[i];
            end=end+A[i];
        }
        while(start<=end){
            int middle=(start+end)/2;
            int sum=0;
            int count=0;
            for(int i=0;i<N;i++){
                if(sum+A[i]>middle) {
                    count++;
                    sum = 0;
                }
                sum=sum+A[i];
            }
            if(sum!=0){ //sum이 0이 아니면 마지막 블루레이가 필요하므로 count값 증가시킴
                count++;
            }
            if(count>M){ //중간 인덱스값으로 모든 레슨 저장 불가
                start=middle+1;
            }
            else
                end=middle-1;
        }
        System.out.println(start);
    }
}
