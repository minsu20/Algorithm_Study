import java.util.*;

public class Main {
    public static int[] Solution(int number, int[] input){
        int[] answer=new int[number];
        for(int i=0;i<number;i++){
            answer[i]=1;
            for(int j=0;j<number;j++){
                if(input[i]<input[j])
                    answer[i]++;
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
        for(int i=0;i<num;i++){
            System.out.print(Solution(num, input)[i]+" ");
        };
    }
}