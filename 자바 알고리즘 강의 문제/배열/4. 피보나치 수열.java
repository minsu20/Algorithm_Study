import java.util.Scanner;

public class Main {
    public static int[] Solution(int number){
        int[] answer=new int[number];
        answer[0]=1;
        answer[1]=1;
        for(int i=2;i<number;i++){
            answer[i]=answer[i-1]+answer[i-2];
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        for(int i=0;i<Solution(num).length;i++){
            System.out.print(Solution(num)[i]+" ");
        }
    }
}