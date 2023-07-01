import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        List<String> card1 = new ArrayList<>(Arrays.asList(cards1));
        List<String> card2= new ArrayList<>(Arrays.asList(cards2));
        String answer = "";
        System.out.println(goal.length);
        for(int i=0;i<goal.length;i++){
            if(!card1.isEmpty()&&card1.get(0).equals(goal[i])){
                card1.remove(0);
            }else if(!card2.isEmpty()&&card2.get(0).equals(goal[i])){
                card2.remove(0);
            }else{
                return "No";
            }
        }
        answer="Yes";
        return answer;
    }
}