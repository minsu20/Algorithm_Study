import java.util.Arrays;

public class 구명보트 {
    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);
            int pSize = people.length;
            int i = 0;
            int j = pSize - i-1;

            while (i <= j && i < pSize && j > 0) {
                if ((people[i] + people[j]) <= limit) {
                    i++;
                    j--;
                    answer += 1;

                } else if ((people[i] + people[j]) > limit) {
                    j--;
                    answer += 1;
                }
            }
            return answer;
        }
    }
}
