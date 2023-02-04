import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {
    class Solution {
        public int solution(int n, int[][] edge) {
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            boolean[] visited;
            visited = new boolean[n + 1];

            for (int i = 0; i <= n; i++) {
                graph.add(i, new ArrayList<>());
            }

            for (int i = 0; i < edge.length; i++) {
                graph.get(edge[i][0]).add(edge[i][1]);
                graph.get(edge[i][1]).add(edge[i][0]);
            }

            int answer;
            answer = bfs(visited, graph);
            return answer;
        }

        public int bfs(boolean[] visited, ArrayList<ArrayList<Integer>> graph) {

            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            visited[1] = true;

            int cnt = 0;

            while (true) {
                Queue<Integer> adj = new LinkedList<>();

                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int adjNode : graph.get(cur)) {
                        if (!visited[adjNode]) {
                            adj.add(adjNode);
                            visited[adjNode] = true;
                        }
                    }
                }

                if (adj.isEmpty())
                    break;
                queue.addAll(adj);
                cnt = adj.size();
            }
            return cnt;
        }
    }
}
