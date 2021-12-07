package ysp_211207;

import java.util.Arrays;



public class Solution {
	public int[] solution(int n, int s) {
		if(s / n > 0){
			int[] answer = new int[n];
			int mot = s/n;
			int garbage = s%n;
			if(s % n == 0) {
				for(int i = 0; i < n; i++) {
					answer[i] = mot;
				}
			}
			else {
				for(int i = 0; i < n- garbage; i++) {
					answer[i] = mot;
				}
				for(int i = n - garbage; i < n; i++) {
					answer[i] = mot + 1;
				}
			}
	        return answer;
		}
		else {
			int[] answer = {-1};
	        return answer;
		}
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		
		
		System.out.println("the answer is : " +Arrays.toString(s.solution(2,9)) +"\n");
		System.out.println("the answer is : " +Arrays.toString(s.solution(2,2)) +"\n");
		System.out.println("the answer is : " +Arrays.toString(s.solution(2,1)) +"\n");
		System.out.println("the answer is : " +Arrays.toString(s.solution(2,8)) +"\n");
		System.out.println("the answer is : " +Arrays.toString(s.solution(7,100)) +"\n");
		System.out.println("the answer is : " +Arrays.toString(s.solution(19,100)) +"\n");
		

	}

}

/*
 * 
 *  String[] games1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
	String[] games2 = {"AA", "AB", "AC", "AA", "AC"};
	String[] games3 = {"XYZ", "XYZ", "XYZ"};
	String[] games4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
 * 
 * 
 * */
