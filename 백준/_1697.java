import java.util.*;

public class _1697 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int first, second;

        first=sc.nextInt();
        second=sc.nextInt();
        if(first==second){
            System.out.println(0);
        }
        else{
            System.out.println(bfs(first, second));
        }

    }
    public static int bfs(int start, int end){
        int count=0;
        boolean[] visited=new boolean[100001];
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        int size=q.size();


       while(true){
           count++;
           size=q.size();
           for(int i=0;i<size;i++){
               int x=q.poll();
               visited[x]=true;
               if(x-1==end||x+1==end||2*x==end){
                   return count;
               }
               if (x-1>=0&&!visited[x-1]) {
                   visited[x-1]=true;
                   q.add(x-1);
               }
               if(x+1<=100000&&!visited[x+1]){
                   visited[x+1]=true;
                   q.add(x+1);
               }
               if(2*x<=100000&&!visited[2*x]){
                   visited[2*x]=true;
                   q.add(2*x);
               }
           }
       }
    }
}
