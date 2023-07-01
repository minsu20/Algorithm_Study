import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 모험가길드 {
    public static int N;
    public static ArrayList<Integer> arrayList=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        for(int i=0;i<N;i++){
            arrayList.add(sc.nextInt());
        }
        Collections.sort(arrayList);

        int result=0;
        int count=0;
        for(int i=0;i<N;i++){
            count+=1;
            if(count>=arrayList.get(i)){
                result+=1;
                count=0;
            }
        }
        System.out.println(result);
    }
}
