import java.util.*;
import java.io.*;
public class _21608 {
    static int n;
    static int[][] map; //자리
    static HashSet<Integer> [] favoriteList; //각 학생별 좋아하는 친구들
    static int[] student; //학생들 자리 놓는 순서
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        map=new int[n][n];
        favoriteList=new HashSet[n*n+1];
        student=new int[n*n+1];

        for(int i=1;i<=n*n;i++){
            favoriteList[i]=new HashSet<>();
        }

        for(int i=1;i<=n*n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s=Integer.parseInt(st.nextToken());
            student[i]=s;

            for(int j=0;j<4;j++){
                int f=Integer.parseInt(st.nextToken());
                favoriteList[s].add(f);
            }
        }

        map[1][1]=student[1];
        simulate();
        getAns();

    }

    public static void getAns(){
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int cnt=0;
                for(int k=0;k<4;k++){
                    int nx=i+dx[k];
                    int ny=j+dy[k];
                    if(nx>=0&&ny>=0&&nx<n&&ny<n){
                        if(favoriteList[map[i][j]].contains(map[nx][ny]))
                            cnt++;
                    }
                }
                if (cnt == 1) {
                    sum+=1;
                }
                if(cnt==2)
                    sum+=10;
                if(cnt==3)
                    sum+=100;
                if(cnt==4)
                    sum+=1000;
            }
        }
        System.out.println(sum);
    }
    public static void simulate(){
        for(int i=2;i<=n*n;i++){
            setPos(i);
        }
    }

    public static void setPos(int s){
        PriorityQueue<StudentS> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==0){
                    pq.add(getStudent(i,j,s));
                }
            }
        }

        StudentS studentS=pq.poll();
        int x=studentS.x;
        int y=studentS.y;
        map[x][y]=student[s];
    }
    public static StudentS getStudent(int x, int y, int s){
        int nearCnt=0;
        int emptyCnt=0;

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0&&ny>=0&&nx<n&&ny<n){
                if(favoriteList[student[s]].contains(map[nx][ny]))
                    nearCnt++;
                if(map[nx][ny]==0)
                    emptyCnt++;
            }
        }
        return new StudentS(nearCnt, emptyCnt, x, y);
    }
}

class StudentS implements Comparable<StudentS> {
    public int nearCnt;
    public int emptyCnt;
    public int x; //행
    public int y; //열

    public StudentS(int nearCnt, int emptyCn, int x, int y){
        this.nearCnt=nearCnt;
        this.emptyCnt=emptyCn;
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(StudentS s){
        if(s.nearCnt==this.nearCnt){
            if(s.emptyCnt==this.emptyCnt){
                if(this.x==s.x){
                    return this.y-s.y;
                }
                return this.x-s.x;
            }
            return s.emptyCnt-this.emptyCnt;
        }
        return s.nearCnt-this.nearCnt;
    }
}