import java.util.Scanner;

public class 곱하기혹은더하기 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.next();

        int result=0;
        for(char c: S.toCharArray()){
            int addOrMul=c-'0';
            if(addOrMul<=1||result<=1){
                result+=addOrMul;
            }else{
                result*=addOrMul;
            }
        }
        System.out.println(result);
    }
}
