import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1074 {
    static int n, r, c, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);
        result=0;
        solve(r,c, size);

    }

    public static void solve(int r, int c, int size) {
        if(size==1){
            System.out.println(result);
            return;
        }

        //첫 번째 구역
        if(0<=r&&r<size/2&&0<=c&&c<size/2){
            solve(r, c, size/2);
        }
        //두 번째 구역
        if(0<=r&&r<size/2&&size/2<=c){
            result+=(int)Math.pow(size/2,2);
            solve(r,c-size/2,size/2);
        }
        //세 번째 구역
        if(size/2<=r&&0<=c&&c<size/2){
            result+=(int)Math.pow(size/2,2)*2;
            solve(r-size/2, c, size/2);
        }
        //네 번째 구역
        if(size/2<=r&&size/2<=c){
            result+=(int)Math.pow(size/2,2)*3;
            solve(r-size/2, c-size/2, size/2);
        }
    }
}
