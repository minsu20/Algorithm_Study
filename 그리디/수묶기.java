import java.util.*;

public class 수묶기{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        PriorityQueue<Integer> plus=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus=new PriorityQueue<>();
        int oneNum=0;
        int zeroNum=0;
        for(int i=0;i<N;i++){
            int num=sc.nextInt();
            if(num>1)
                plus.add(num);
            if(num==0)
                zeroNum++;
            if(num==1)
                oneNum++;
            if(num<0)
                minus.add(num);
        }
        int result=0;
        while(plus.size()>1){
            int first=plus.poll();
            int second=plus.poll();
            result+=first*second;
        }
        if(!plus.isEmpty()){
            result+=plus.poll();
        }
        while(minus.size()>1){
            int first=minus.poll();
            int second=minus.poll();
            result+=first*second;
        }
        if(!minus.isEmpty()){
            if(zeroNum==0){
                result+=minus.poll();
            }
        }
        result+=oneNum;
        System.out.println(result);
    }
}
