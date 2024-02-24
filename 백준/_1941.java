import java.util.*;
import java.io.*;

public class _1941 {
    static char[][] input = new char[5][5];
    static boolean[][] visited;
    static int[] dx={0,-1,0, 1};
    static int[] dy={-1,0,1,0};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            input[i] = str.toCharArray();
        }

        visited=new boolean[5][5];
        combination(visited, 0, 25, 7);
        System.out.println(ans);
    }

    public static void combination(boolean[][] visited, int start, int n, int r){

        if(r==0){
            Queue<Student> s=new LinkedList<>();
            boolean[][] map=new boolean[5][5];
            for(int i = 0; i < visited.length; i++){ // 반복문 + ArrayCopy
                System.arraycopy(visited[i], 0, map[i], 0, map[i].length);
            }

            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(visited[i][j]==true){
                        s.add(new Student(i, j));
                        bfs(s,map);
                        return;
                    }

                }
            }
        }
        for(int i=start;i<n;i++){
            visited[i/5][i%5]=true;
            combination(visited, i+1,n,r-1);
            visited[i/5][i%5]=false;
        }
    }

    public static void bfs(Queue<Student> s, boolean[][] map) {

        int count=0;
        int sNum=0;

        while(!s.isEmpty()){
            Student current=s.poll();
            for(int i=0;i<4;i++){
                int nx=current.x+dx[i];
                int ny=current.y+dy[i];
                if(nx>=0&&ny>=0&&nx<5&&ny<5){
                    if(map[nx][ny]){
                        count++;
                        map[nx][ny]=false;
                        s.add(new Student(nx,ny));
                        if(input[nx][ny]=='S')
                            sNum++;
                    }
                }

            }
        }

        if(count==7){
            if(sNum>=4){
                ans++;
            }
        }
    }
}

class Student {
    int x, y;

    public Student(int x, int y){
        this.x=x;
        this.y=y;
    }
}
