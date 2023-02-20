import java.util.*;

class Solution {
    public int answer=-1;
    public boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited=new boolean[dungeons.length];
        dfs(0,k,dungeons);
        return answer;
    }
    public void dfs(int depth, int k, int[][] dungeongs){
        for(int i=0;i<dungeongs.length;i++){
            if(!visited[i]&&dungeongs[i][0]<=k){
                visited[i]=true;
                dfs(depth+1,k-dungeongs[i][1],dungeongs);
                visited[i]=false;
            }
        }
        answer=Math.max(answer,depth);
    }
}