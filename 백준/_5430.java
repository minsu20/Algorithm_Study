import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _5430 {

    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            Deque<Integer> deque = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean isReverse = false;
            boolean isError = false;

            for (char command : p.toCharArray()) {
                if (command == 'R') {
                    isReverse = !isReverse;
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReverse) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }
            if(isError)
                System.out.println("error");
            else{
                StringBuilder stringBuilder=new StringBuilder("[");
                int size=deque.size();
                for(int i=0;i<size;i++){
                    if(isReverse) {
                        stringBuilder.append(deque.removeLast());
                    }else{
                        stringBuilder.append(deque.removeFirst());
                    }
                    if(!deque.isEmpty()){
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append("]");
                System.out.println(stringBuilder);
            }
        }
    }
}

