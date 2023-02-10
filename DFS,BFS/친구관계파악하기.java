import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 친구관계파악하기 {
    static ArrayList<Integer>[] A;
    static boolean visited[];
    static boolean arrive;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        A=new ArrayList[n];
        visited=new boolean[n];
        for(int i=0;i<n;i++){
            A[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int first=Integer.parseInt(st.nextToken());
            int second=Integer.parseInt(st.nextToken());
            A[first].add(second);
            A[second].add(first);
        }
        arrive=false;
        for(int i=0;i<n;i++){
            DFS(i,1);
            if(arrive)
            {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
    static void DFS(int v, int depth){
        if(depth==5||arrive){
            arrive=true;
            return;
        }
        visited[v]=true;

        for(int i:A[v]){
            if(visited[i]==false){
                DFS(i,depth+1);
            }
        }
        visited[v]=false;
    }
}
