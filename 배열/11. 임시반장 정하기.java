import java.util.*;
  
public class Main {
public static int[] dx={-1,0,1,0};
    public static int[] dy={0,-1,0,1};
    public static int Solution(int number, int[][] input) {
        int answer=0;
        for(int i=0;i<number;i++){
            for(int j=0;j<number;j++){
                boolean flag=true;
                for(int k=0;k<4;k++){
                    int nx=i+dx[k];
                    int ny=j+dy[k];
                    if(nx>=0&&nx<number&&ny>=0&&ny<number&&input[nx][ny]>=input[i][j]){
                        flag=false;
                        break;
                    }
                }
                if(flag)
                    answer+=1;
            }
        }
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