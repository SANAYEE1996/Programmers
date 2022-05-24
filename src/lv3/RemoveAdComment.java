package lv3;

public class RemoveAdComment {
	public String solution(String sentence) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		System.out.println(sentence);
		
		char a = 0;
		
		char RuleOne = 0; //중간중간 들어가는 문자 
		
		char RuleTwo = 0; //단어 앞과 끝에 들어가는 문자
		
		boolean oneValid = false;
		boolean twoValid = false;
		
		for(int i = 0; i < sentence.length(); i++) {
			a = sentence.charAt(i);
			if(a == ' ') {
				answer = "invalid";
				break;
			}
			else {
				if(a >= 97 && a <= 122) {//소문자 이면
					System.out.println(a + " : Small Alphabet");
					if(i == 0) { // 처음부터 소문자 나오는거면 RuleTwo
						RuleTwo = a;
						twoValid = true;
						continue;
					}
					
					if(oneValid && !twoValid) {
						
					}
					else if(!oneValid && twoValid) {
						
					}
					else if(oneValid && twoValid) {
						
					}
					else {
						
					}
					
					
					
					
				}
				else {					//대문자 이면
					System.out.println(a + " : Big Alphabet");
					sb.append(a);
				}
			}
		}
		
        return answer;
    }

	public static void main(String[] args) {
		RemoveAdComment s = new RemoveAdComment();
		
		System.out.println("the answer is : " +s.solution("HaEaLaLaObWORLDb"));
		System.out.println("the answer is : " +s.solution("SpIpGpOpNpGJqOqA"));
		System.out.println("the answer is : " +s.solution("AxAxAxAoBoBoB"));
		System.out.println("the answer is : " +s.solution(" AxAxAxAoBoBoB"));
		System.out.println("the answer is : " +s.solution("AxAxAxAo BoBoB"));
		

	}

}
