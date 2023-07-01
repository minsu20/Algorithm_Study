import java.util.Scanner;

public class 잃어버린괄호 {
    static int answer=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        String[] token=line.split("-");
        for(int i=0;i<token.length;i++){
            int temp=mySum(token[i]);
            if(i==0)
                answer+=temp;
            else
                answer-=temp;
        }
        System.out.println(answer);
    }
    public static int mySum(String str){
        int sum=0;
        String temp[]=str.split("[+]");
        for(int i=0;i<temp.length;i++){
            sum+=Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
