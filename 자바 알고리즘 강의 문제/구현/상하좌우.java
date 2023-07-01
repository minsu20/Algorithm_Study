import java.util.ArrayList;
import java.util.Scanner;

public class 상하좌우 {
    public static void main(String[] args) {
        int[] dx={1, -1, 0, 0};
        int[] dy={0,0,1,-1};
        String[] moveTypes={"R", "L", "D", "U"};
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        sc.nextLine(); //버퍼지우기
        String move=sc.nextLine();
        String[] moveSequences=move.split(" ");
        int nx=1;
        int ny=1;
        int newX=1, newY=1;

        for(String oneMove:moveSequences){
           for(int i=0;i<moveTypes.length;i++){
               if(oneMove.equals(moveTypes[i])){
                   newX=nx+dx[i];
                   newY=ny+dy[i];
               }
           }
           if(newX<1||newX>N||newY<1||newY>N)
               continue;
           nx=newX;
           ny=newY;

        }
        System.out.println(ny+" "+nx);
    }
}
