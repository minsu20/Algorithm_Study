import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 문자열재정렬 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String[] strArr=str.split("");
        String resultStr="";
        int resultInt=0;
        for(String oneString:strArr){
            try{
                int addInt=Integer.parseInt(oneString);
                resultInt+=addInt;
            }catch(NumberFormatException ex){
                resultStr+=oneString;
            }
        }
        resultStr= Stream.of(resultStr.split(""))
                .sorted().collect(Collectors.joining());
        resultStr+=Integer.toString(resultInt);
        System.out.println(resultStr);
    }

}
