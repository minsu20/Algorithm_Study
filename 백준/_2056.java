import java.util.*;
import java.io.*;

public class _2056 {

    static int n;

    static int[] endTime;
    static PriorityQueue<Work> works;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        endTime=new int[n+1];
        works=new PriorityQueue<>();

        for(int i=1;i<=n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int time=Integer.parseInt(st.nextToken());
            int num=Integer.parseInt(st.nextToken());
            endTime[i]=time;
            PriorityQueue<Work> subWork=new PriorityQueue<>();
            for(int j=0;j<num;j++){
                int pre=Integer.parseInt(st.nextToken());
                subWork.add(new Work(endTime[pre],pre));
            }
            if(num>0){
                endTime[i]=subWork.peek().end+time;
            }
            works.add(new Work(endTime[i],i));
        }
        System.out.println(works.peek().end);
    }



}

class Work implements Comparable<Work>{

    public int end;

    public int index;

    public Work(int end, int index){
        this.end=end;
        this.index=index;
    }

    @Override
    public int compareTo(Work work){
        return work.end-this.end;
    }
}