import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1748 {
    public static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        System.out.println(solve());
    }

    public static int solve() {
        int result = 0;
        int length = input.length();
        double closeNum = Math.pow(10, length - 1);
        for (int i = 1; i < length; i++) {
            result += i * (Math.pow(10, i) - Math.pow(10, i - 1));
        }
        result += length * (Integer.parseInt(input) - closeNum + 1);
        return result;
    }
}
