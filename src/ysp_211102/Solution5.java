package ysp_211102;
 
public class Solution5 {
	public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int[] count = {k};
        for(int i = 0; i < number.length(); i++) {
        	sb.append(answer);
        	sb.append(number.charAt(i));
        	answer = sb.toString();
        	
        	if(answer.length() > 1) {
        		if(	Integer.parseInt(answer.substring(answer.length()-1)) > 
        			Integer.parseInt(answer.substring(answer.length()-2,answer.length()-1))) {
        			
        			count[0]--;
        			answer = gogo(sb.deleteCharAt(answer.length()-2).toString(),count);
        		}
        	}
        	if(count[0] == 0) {
        		answer += number.substring(i+1);
        		break;
        	}
        	sb.setLength(0);
        }
        
        if(answer.length() > number.length()-k) {
        	answer = answer.substring(0,number.length()-k);
        }
        
        return answer;
    }
	
	public static String gogo(String answer,int[] count) {
		StringBuilder sb = new StringBuilder(answer);
		if(answer.length() > 1 && count[0] > 0) {
			if(	Integer.parseInt(answer.substring(answer.length()-1)) > 
			Integer.parseInt(answer.substring(answer.length()-2,answer.length()-1))) {
				count[0]--;
				answer = gogo(sb.deleteCharAt(answer.length()-2).toString(),count);
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Solution5 s = new Solution5();
		System.out.println(s.solution("1924", 2));
		System.out.println(s.solution("1231234", 3));
		System.out.println(s.solution("4177252841", 4));
		System.out.println(s.solution("1000", 1));
		System.out.println(s.solution("77777", 1));
		System.out.println(s.solution("1111117", 5));
	}

}
