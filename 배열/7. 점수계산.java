import java.util.*;

public class Main {
    public static int Solution(int number, int[] input){
        int answer=0, cnt=0;
        for(int i=0;i<number;i++){
            if(input[i]==1){
                cnt++;
                answer+=cnt;
            }else{
                cnt=0;
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
        System.out.println(Solution(num, input));
    }
}