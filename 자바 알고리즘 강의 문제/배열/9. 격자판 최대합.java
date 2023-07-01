import java.util.*;

public class Main {
   public static int Solution(int number, int[][] input) {
        int answer = 0;
        int sum1, sum2;
        for(int i=0;i<number;i++){ //행과 열의 합 중 최댓값
            sum1=sum2=0;
            for(int j=0;j<number;j++){
                sum1+=input[i][j];
                sum2+=input[j][i];
            }
            answer=Math.max(answer,sum1);
            answer=Math.max(answer,sum2);
        }

        sum1=sum2=0;
        for(int i=0;i<number;i++){ //두 대각선의 합 중 최댓값
            sum1+=input[i][i];
            sum2+=input[i][number-i-1];
        }
        answer=Math.max(answer, sum1);
        answer=Math.max(answer, sum2);
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[][] input = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                input[i][j] = in.nextInt();
            }
        }

        System.out.print(Solution(num, input));

    }
}