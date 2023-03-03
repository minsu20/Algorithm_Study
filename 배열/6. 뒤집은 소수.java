import java.util.*;

public class Main {
    public static ArrayList<Integer> Solution(int number, String[] input){

        ArrayList<Integer> answer=new ArrayList<>();
        for(int i=0;i<number;i++){
            StringBuilder stringBuilder=new StringBuilder(input[i]);
            String s=stringBuilder.reverse().toString();
            if(isPrime(Integer.parseInt(s))==true)
                answer.add(Integer.parseInt(s));
        }
        return answer;
    }

    public static boolean isPrime(int number){
        if(number==1)
            return false;
        for(int i=2;i<=(int)Math.sqrt(number);i++){
            if(number%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        String[] input=new String[num];
        for(int i=0;i<num;i++){
            input[i]=in.next();
        }

        for(int i=0;i<Solution(num,input).size();i++){
            System.out.print(Solution(num,input).get(i)+" ");
        }

    }
}