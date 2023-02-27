import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 음료수얼려먹기 {
    static boolean[][] visited;
    static int[][] input;
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    static int count=0;
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        input=new int[n][m];
        visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            String numarray=sc.next();
            for(int j=0;j<m;j++){
                input[i][j]=Integer.parseInt(String.valueOf(numarray.charAt(j)));
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]&&input[i][j]==0) {
                    count++;
                    DFS(i,j);
                }
            }
        }
        System.out.println(count);
    }
    static void DFS(int x, int y){
        if(visited[x][y])
            return;
        visited[x][y]=true;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx<0||nx>=n||ny<0||ny>=m)
                continue;
            if(input[nx][ny]==0){
                DFS(nx,ny);
            }
        }
    }
}
