package ysp_211125;

import java.util.Arrays;

public class Solution2 {
	
	public int solution(int n, int m, int k){
        int answer = 0;
        int[] member = new int[n];
        int i = 0;
        
        while(true) {
        	member[i] += 1;
        	System.out.println(Arrays.toString(member));
        	if(member[i] == m) {
        		break;
        	}
        	if(member[i] % 2 == 1) {
        		answer++;
        		i += k;
        		if(i >= n) {
        			i -= n;
        		}
        	}
        	else {
        		answer++;
        		i -= k;
        		if(i < 0) {
        			i += n;
        		}
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println(s.solution(3, 3, 2));
		
		System.out.println(s.solution(5, 9, 3));
		

	}

}
