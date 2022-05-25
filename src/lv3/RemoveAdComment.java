package lv3;

import java.util.ArrayList;

public class RemoveAdComment {
	public String solution(String sentence) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		System.out.println("받은 값 : "+sentence);
		ArrayList<Character> list = new ArrayList<>();
		
		char nowChar = 0;
		char beforeChar = '!';
		int beforeCharIndex = 0;
		int nowCharIndex = 0;
		int distance = 0;
		
		for(int i = 0; i < sentence.length(); i++) {
			nowChar = sentence.charAt(i);
			nowCharIndex = i;
			if(nowChar == ' ') {
				System.out.println("공백 있으면 안됌!");
				answer = "invalid";
				break;
			}
			else {
				if(nowChar >= 97 && nowChar <= 122) {
					distance = nowCharIndex - beforeCharIndex;
					if(distance == 2) {
						System.out.println("거리 : " +distance + " 현재 Char : " 
											+nowChar + " 이전 Char : " +beforeChar);
						
					}
					else if(distance > 2) {
						System.out.println("거리 : " +distance + " 현재 Char : " 
								+nowChar + " 이전 Char : " +beforeChar);
					}
					else if(distance == 1) {
						if(beforeChar != ' ') {
							System.out.println("앞에 소문자가 있는데 뒤에 바로 소문자가 온 거");
							answer = "invalid";
							break;
						}
						System.out.println("거리 : " +distance + " 현재 Char : " 
								+nowChar + " 이전 Char : " +beforeChar);
					}
					else {
						System.out.println("거리 : " +distance + " 현재 Char : " 
								+nowChar + " 이전 Char : " +beforeChar);
					}
					beforeCharIndex = i;
					beforeChar = nowChar;
				}
			}
		}
		
		
		
		//System.out.println(sb.toString());
		
        return answer;
    }

	public static void main(String[] args) {
		RemoveAdComment s = new RemoveAdComment();
		
		System.out.println("the answer is : " +s.solution("HaEaLaLaObWORLDb") + "\n");
		System.out.println("the answer is : " +s.solution("SpIpGpOpNpGJqOqA") + "\n");
		System.out.println("the answer is : " +s.solution("AxAxAxAoBoBoB") + "\n");
		System.out.println("the answer is : " +s.solution("aHELLOa bWORLDb") + "\n");
		System.out.println("the answer is : " +s.solution("HaEaLaLObWORLDb") + "\n");
		System.out.println("the answer is : " +s.solution("aHELLOWORLDa") + "\n");
		System.out.println("the answer is : " +s.solution("HaEaLaLaOWaOaRaLaD") + "\n");
		System.out.println("the answer is : " +s.solution("abHELLObaWORLD") + "\n");
		

	}

}
