import java.util.*;
class Main {	
	public int solution(String s){
		//int answer=0;
		String answer="";
		for(char x : s.toCharArray()){
			if(Character.isDigit(x)) answer+=x;
		}
		return Integer.parseInt(answer);
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
	}
}