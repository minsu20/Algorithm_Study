import java.util.*;
import java.io.*;
public class _2667 {
    static int n;
    static int[][] map, visited;
    static int total;
    static ArrayList<Integer> result;

    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine(), "");
        n=Integer.parseInt(st.nextToken());
        map=new int[n][n];
        visited=new int[n][n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine(), "");
            String str=st.nextToken();
            for(int j=0;j<n;j++){
                map[i][j]=str.charAt(j)-'0';
            }
        }

        total=0;
        result=new ArrayList<>();
        solve();
        System.out.println(total);
        Collections.sort(result);
        for(int i=0;i<total;i++){
            System.out.println(result.get(i));
        }
    }

    public static void solve(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[j][i]==1){
                    map[j][i]=0;
                    result.add(1);
                    dfs(j, i);
                    total++;
                }
            }
        }
    }


    public static void dfs(int y, int x){
        for(int i=0;i<4;i++){
            int ny=y+dy[i];
            int nx=x+dx[i];
            if(nx>=0&&nx<n&&ny>=0&&ny<n&&map[ny][nx]==1){
                map[ny][nx]=0;
                int num=result.get(total);
                result.set(total, num+1);
                dfs(ny, nx);
            }
        }
    }
}
