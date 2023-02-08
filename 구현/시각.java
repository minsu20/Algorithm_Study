import java.util.Scanner;

public class 시각{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int result=(N+1)*3600-(N)*45*45;
        System.out.println(result);
    }
}