package LV3;

import java.util.ArrayList;
import java.util.Arrays;

public class LV3_DP_N {
	public int solution(int N, int number) {
        int answer = 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(N);
        while(answer < 9) {
        	if(list.contains(number)) {
        		break;
        	}
        	
        	
        	
        	answer++;
        }
        
        return answer;
    }
	
	public long solution(int n, int[] works) {
        long answer = 0;
        int sum = 0;
        for(int i : works) sum += i;
        
        double divide = (sum-n)/(double)works.length;
        
        if(divide <= 0) return 0;
        
        long gain = (long) divide;
        if(divide - (int)divide == 0) {
        	for(int i = 0; i < works.length; i++) {
        		answer += Math.pow(gain, 2);
        	}
        }
        else {
        	for(int i = 0; i < works.length; i++) {
        		if(n <= 0) break;
        		
        		if(works[i] > gain) {
        			n -= works[i] - gain;
        			works[i] = (int)gain;
        		}
        	}
        	for(int i : works) {
        		answer += Math.pow(i, 2);
        	}
        }
        System.out.println(Arrays.toString(works));
        return answer;
    }
	
	
	public static void main(String[] args) {
		
		LV3_DP_N s = new LV3_DP_N();
		
		System.out.println("the answer is : " +s.solution(5, 12));
		System.out.println("the answer is : " +s.solution(2, 11));
		
		System.out.println();
		int[] works = {4,3,3};
		int[] works2 = {2,1,2};
		int[] works3 = {1,1};
		int[] works4 = {2, 15, 22, 55, 55};
		
		System.out.println("the answer is : " +s.solution(4, works));
		System.out.println("the answer is : " +s.solution(1, works2));
		System.out.println("the answer is : " +s.solution(3, works3));
		System.out.println("the answer is : " +s.solution(99, works4));

	}
}

