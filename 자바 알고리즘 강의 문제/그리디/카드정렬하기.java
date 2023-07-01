import java.util.*;
public class 카드정렬하기 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<N;i++){
            pq.add(sc.nextInt());
        }
        int num=0;
        while(pq.size()>1){
            int first=pq.poll();
            int second=pq.poll();
            num+=first+second;
            pq.add(first+second);
        }
        System.out.println(num);
    }
}
