import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {
    class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            String[] numString=new String[numbers.length];
            Boolean zero=true;
            for(int i=0;i<numbers.length;i++){
                numString[i]=String.valueOf(numbers[i]);
                if(numbers[i]!=0) zero=false;
            }
            Arrays.sort(numString, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o2+o1).compareTo(o1+o2);
                }
            });
            for(int i=0;i<numString.length;i++){
                answer+=numString[i];
            }
            if(zero) answer="0";
            return answer;
        }
    }
}
