import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2060 {

    static int n;
    static int[][] map;
    static int[] ch;
    static int line;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        line = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        ch = new int[n + 1];

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            map[first][second] = 1;
            map[second][first] = 1;
        }

        result = 0;
        ch[1] = 1;
        dfs(1);
        System.out.println(result - 1);
    }

    public static void dfs(int L) {
        result++;
        for (int i = 1; i < n + 1; i++) {
            if (map[L][i] == 1 && ch[i] != 1) {
                ch[i] = 1;
                dfs(i);
            }
        }
    }
}
