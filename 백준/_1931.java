import java.util.*;
import java.io.*;
class _1931 {
    static int result;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine(), " ");
        n=Integer.parseInt(st.nextToken());
        ArrayList<Time> timeList=new ArrayList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine(), " ");
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            Time time=new Time(start, end);
            timeList.add(time);
        }
        Collections.sort(timeList);
        result=1;
        solve(timeList);
        System.out.println(result);
    }

    public static void solve(ArrayList<Time> timeList){
        int end=timeList.get(0).end;
        if(n>1) {
            for (int i = 1; i < n; i++) {
                if(timeList.get(i).start>=end){
                    end=timeList.get(i).end;
                    result++;
                }
            }
        }
    }
}

class Time implements Comparable<Time>{
    public int start, end;
    Time(int start, int end){
        this.start=start;
        this.end=end;
    }

    @Override
    public int compareTo(Time t){
        if(this.end==t.end){
            return this.start-t.start;
        }else{
            return this.end-t.end;
        }
    }
}
