package lv2;

import java.util.Arrays;

public class NumberBlock {
	
	public int getMaxFactor(long n) {
		int size = (int) Math.sqrt(n);
		int answer;
		if(n == 1) answer = 0;
		else answer = 1;
		long mot = 0;
		long nam = 0;
		for(int i = 2; i <= size; i++) {
			mot = n/i;
			nam = n%i;
			if(nam == 0) {
				answer = (int)mot;
				break;
			}
		}
		return answer;
	}
	
	
	public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end-begin) + 1];
        NumberBlock s = new NumberBlock();
        int index = 0;
        for(long i = begin; i <= end; i++) {
        	answer[index] = s.getMaxFactor(i);
        	index++;
        }
        return answer;
    }

	public static void main(String[] args) {
		NumberBlock s = new NumberBlock();
		
		System.out.println("the answer is : " +Arrays.toString(s.solution(1, 10)));
		System.out.println("the answer is : " +Arrays.toString(s.solution(13, 30)));
	}

}
