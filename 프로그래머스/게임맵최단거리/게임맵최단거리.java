import java.util.*;

public class 게임맵최단거리 {
    static class Solution {
        int count = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        List<Integer> result = new ArrayList<>();

        public int solution(int[][] maps) {
            int row = maps.length; //행 개수
            int column = maps[0].length; //열 개수
            int[][] visited = new int[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    visited[i][j] = 0;
                }
            }

            int answer = 0;
            bfs(maps, visited);
            answer = visited[maps.length - 1][maps[0].length - 1];
            if (answer == 0)
                answer = -1;

            return answer;
        }

        public void bfs(int[][] maps, int[][] visited) {
            int x = 0;
            int y = 0;
            visited[x][y] = 1;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{x, y});

            while (!queue.isEmpty()) {
                int[] current = queue.remove();
                int cx = current[0];
                int cy = current[1];

                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (nx < 0 || nx > maps.length - 1 || ny < 0 || ny > maps[0].length - 1)
                        continue;

                    if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                        visited[nx][ny] = visited[cx][cy] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}

