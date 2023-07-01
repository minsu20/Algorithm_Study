import java.util.*;

public class Main {
    public static int Solution(int number){
        int answer=0;
        int[] numArray=new int[number+1];
        for(int i=2;i<number+1;i++){
            if(numArray[i]==0){
                answer++;
                for(int j=1;j<=number/i;j++){
                    numArray[i*j]=1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();

        System.out.print(Solution(num));

    }
}