package lv3;

import java.util.Arrays;

public class GetAvgScore {
	public int solution(String[] scores) {
        int answer = 0;
        
        char[] charArray;
        String flag = "";
        String exam = "";
        
        for(String s : scores) {
        	
        	charArray = s.toCharArray();
        	Arrays.sort(charArray);
        	flag = new String(charArray);
        	
        	if(!check1(flag)) {
        		if(check2(flag)) {
        			answer++;
        		}
        		else {
        			exam = flag.substring(1,flag.length()-1);
        			if(getScore(exam) >= 3) {
        				answer++;
        			}
        		}
        	}
        }
        
        
        
        return answer;
    }
	
	public static boolean check1(String score) {
		int count = 0;
		boolean isCheck = false;
		for(int i = score.length()-1; i >= 0; i--) {
			if(score.charAt(i) == 'F') {
				count++;
			}
			else {
				if(count >= 2) {
					isCheck = true;
				}
				break;
			}
		}
		return isCheck;
	}
	
	public static boolean check2(String score) {
		int count = 0;
		boolean isCheck = false;
		for(int i = 0; i < score.length(); i++) {
			if(score.charAt(i) == 'A') {
				count++;
			}
			else {
				if(count >= 2) {
					isCheck = true;
				}
				break;
			}
			
		}
		return isCheck;
	}
	
	public static double getScore(String exam) {
		double score = 0;
		
		for(int i = 0; i < exam.length(); i++) {
			if(exam.charAt(i) == 'A') {
				score += 5;
			}
			else if(exam.charAt(i) == 'B') {
				score += 4;
			}
			else if(exam.charAt(i) == 'C') {
				score += 3;
			}
			else if(exam.charAt(i) == 'D') {
				score += 2;
			}
			else if(exam.charAt(i) == 'E') {
				score += 1;
			}
		}
		
		return score/exam.length();
	}

	public static void main(String[] args) {
		GetAvgScore s = new GetAvgScore();
		
		String[] a = {"AAFAFA", "FEECAA", "FABBCB", "CBEDEE", "CCCCCC"};
		String[] b = {"BCD","ABB","FEE"};
		
		System.out.println("the answer is : " +s.solution(a));
		System.out.println("the answer is : " +s.solution(b));

	}

}
