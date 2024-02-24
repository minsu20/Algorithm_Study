import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10026 {

    static int m;
    static int redGreenMed, normal;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        String[][] colorMap = new String[m][m];
        String[][] normalMap=new String[m][m];
        String[][] medMap=new String[m][m];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < m; j++) {
                colorMap[i][j] = String.valueOf(str.charAt(j));
                normalMap[i][j] = String.valueOf(str.charAt(j));
                medMap[i][j] = String.valueOf(str.charAt(j));

            }
        }


        solveNormal(normalMap);
        solveMed(medMap);
        System.out.println(normal + " " + redGreenMed);
    }

    public static void solveNormal(String[][] colorMap) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (!colorMap[i][j].equals("O")) {
                    String currentColor = colorMap[i][j];
                    colorMap[i][j] = "O";
                    dfsNormal(i, j, currentColor, colorMap);
                    normal++;
                }
            }
        }
    }

    public static void solveMed(String[][] colorMap) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (!colorMap[i][j].equals("O")) {
                    String currentColor = colorMap[i][j];
                    colorMap[i][j] = "O";
                    dfsMed(i, j, currentColor, colorMap);
                    redGreenMed++;
                }
            }
        }
    }

    public static void dfsNormal(int ny, int nx, String currentColor, String[][] colorMap) {

        for (int i = 0; i < 4; i++) {
            int x = nx + dx[i];
            int y = ny + dy[i];

            if (x >= 0 && y >= 0 && x < m && y < m) {
                if (colorMap[y][x].equals(currentColor)) {
                    colorMap[y][x] = "O";
                    dfsNormal(y, x, currentColor, colorMap);
                }
            }
        }
    }

    public static void dfsMed(int ny, int nx, String currentColor, String[][] colorMap) {

        for (int i = 0; i < 4; i++) {
            int x = nx + dx[i];
            int y = ny + dy[i];

            if (x >= 0 && y >= 0 && x < m && y < m) {
                if (currentColor.equals("G")) {
                    if (colorMap[y][x].equals(currentColor) || colorMap[y][x].equals("R")) {
                        colorMap[y][x] = "O";
                        dfsMed(y, x, currentColor,colorMap);
                    }
                } else if (currentColor.equals("R")) {
                    if (colorMap[y][x].equals(currentColor) || colorMap[y][x].equals("G")) {
                        colorMap[y][x] = "O";
                        dfsMed(y, x, currentColor, colorMap);
                    }
                } else {
                    if (colorMap[y][x].equals(currentColor)) {
                        colorMap[y][x] = "O";
                        dfsMed(y, x, currentColor, colorMap);
                    }
                }
            }
        }
    }
}
