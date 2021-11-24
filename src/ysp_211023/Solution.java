package ysp_211023;

import java.util.Arrays;

public class Solution {
	public String[] solution(int startNumber, int endNumber) {
        String[] answer = new String[Math.abs(startNumber-endNumber)+1];
        StringBuilder sb = new StringBuilder();
        
        if(startNumber <= endNumber) {
        	for(int i = 0; i < answer.length; i++) {
        		sb.setLength(0);
        		for(int j = 0; j < 9-i; j++) {
        			sb.append("0");
        		}
        		for(int j = startNumber; j < i+startNumber+1; j++) {
        			sb.append(j);
        		}
        		answer[i] = sb.toString();
        	}
        }
        else {
        	for(int i = 0; i < answer.length; i++) {
        		sb.setLength(0);
        		for(int j = 0; j < 9-i; j++) {
        			sb.append("0");
        		}
        		for(int j = startNumber; j > startNumber-i-1; j--) {
        			sb.append(j);
        		}
        		answer[i] = sb.toString();
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(Arrays.toString(s.solution(3, 7)));
		System.out.println(Arrays.toString(s.solution(9, 7)));
		System.out.println(Arrays.toString(s.solution(3, 7)));

	}

}
