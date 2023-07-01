import java.util.*;
class Main {
    public static int Solution(int number, int[] input){

        int answer=1;
        int Max=input[0];
        for(int i=1;i<number;i++){
            if(input[i]>Max) {
                Max=input[i];
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        int[] input=new int[num];
        for(int i=0;i<num;i++){
            input[i]=in.nextInt();
        }
        System.out.println(Solution(num,input));
    }
}