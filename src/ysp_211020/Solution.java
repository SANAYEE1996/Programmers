package ysp_211020;

import java.util.Arrays;

public class Solution {
	public int solution(String word) {
        int answer = 0;
        for(int i = 0; i < word.length(); i++) {
        	
        }
        return answer;
    }
	
	public int solution2(int[][] board) {
		int answer = 0;
		
		
		return answer;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("AAAAE"));
		System.out.println(s.solution("AAAE"));
		System.out.println(s.solution("I"));
		System.out.println(s.solution("EIO"));
		
		String[] gogo = {"AA","A","AAA","AAAAA","AAAA","AAAAE"};
		Arrays.sort(gogo);
		System.out.println(Arrays.toString(gogo));
		
	}

}


/*
 * 
 * 4 10 16 
 * 
 * 
 * 
 * 
 * 
 */