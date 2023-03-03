import java.util.*;
class Main {
    public static String[] Solution(int number, int[] A, int[] B){
        String[] answer=new String[number];
        for(int i=0;i<number;i++){
            if(Math.abs(A[i]-B[i])==1){
                if(A[i]>B[i])
                    answer[i]="A";
                else
                    answer[i]="B";
            }else if(Math.abs(A[i]-B[i])==2){
                if(A[i]>B[i])
                    answer[i]="B";
                else
                    answer[i]="A";
            }else{
                answer[i]="D";
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        int[] A=new int[num];
        int[] B=new int[num];
        for(int i=0;i<num;i++){
            A[i]=in.nextInt();
        }
        for(int i=0;i<num;i++){
            B[i]=in.nextInt();
        }
        for(int i=0;i<Solution(num,A,B).length;i++){
            System.out.println(Solution(num,A,B)[i]);
        }
    }
}