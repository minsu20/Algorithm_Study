import java.io.BufferedReader;
import java.util.*;

public class 트리의지름구하기 {
    static ArrayList<Edge>[] A;
    static boolean visited[];
    static int distance[];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        A=new ArrayList[N+1]; //첫 번째: 번호, 두 번째: 거리
        for(int i=1;i<=N;i++){
            A[i]=new ArrayList<>();
        }
        for(int i=0;i<N;i++){
            int a=sc.nextInt();
            while(true){
                int S=sc.nextInt();
                if(S==-1)
                    break;
                int E=sc.nextInt();
                A[a].add(new Edge(S,E));
            }
        }
        distance=new int[N+1];
        visited=new boolean[N+1];
        BFS(1);
        int Max=1;
        for(int i=2;i<=N;i++){
            if(distance[Max]<distance[i])
                Max=i;
        }
        distance=new int[N+1];
        visited=new boolean[N+1];
        BFS(Max);
        Arrays.sort(distance);
        System.out.println(distance[N]);

    }
    public static void BFS(int v){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(v);
        visited[v]=true;
        while(!queue.isEmpty()){
            int now=queue.poll();
            for(Edge e:A[now]){
                int i=e.e;
                int va=e.value;
                if(!visited[i]){
                    visited[i]=true;
                    queue.add(i);
                    distance[i]=distance[now]+va;
                }
            }
        }
    }
}
class Edge{
    int e;
    int value;
    public Edge(int e, int value){
        this.e=e;
        this.value=value;
    }
}
