import java.util.*;

public class 전력망둘로나누기 {
    public static void main(String[] args){
        String answer="";
        Scanner in=new Scanner(System.in);
        String str=in.next();
        char[] ch=str.toCharArray();
        int lt=0, rt=str.length()-1;
        while(lt<rt){
            if(!Character.isAlphabetic(ch[lt]))
                lt++;
            else if(!Character.isAlphabetic(ch[rt]))
                rt++;
            else{
                char tmp=ch[lt];
                ch[lt]=ch[rt];
                ch[rt]=tmp;
                lt++;
                rt--;
            }
        }
        answer=String.valueOf(ch);
        System.out.println(answer);
    }
}