import java.util.*;
import java.io.*;
public class _1463 {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int input = Integer.parseInt(st.nextToken());

        System.out.println(bfs(input));
    }

    public static int bfs(int input){
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(0,input));

        while(!q.isEmpty()){
            Node now=q.poll();
            if(now.getValue()==1)
                return now.getNumber();
            if(now.getValue()%2==0){
                q.add(new Node(now.getNumber()+1,now.getValue()/2));
            }
            if(now.getValue()%3==0){
                q.add(new Node(now.getNumber()+1,now.getValue()/3));
            }
            q.add(new Node(now.getNumber()+1,now.getValue()-1));
        }
        return 0;
    }

    public static class Node {
        private int number; //횟수
        private int value; //값

        public int getNumber(){
            return number;
        }
        public int getValue(){
            return value;
        }

        public Node(int num, int val){
            this.number=num;
            this.value=val;
        }
    }
}
