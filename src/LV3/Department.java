package LV3;

import java.util.Arrays;
import java.util.LinkedList;

public class Department {
	public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        LinkedList<Integer> list = new LinkedList<>();
        for(int i : times) list.add(i);
        int value = 0;
        while(n > 0) {
        	times[0] *= 2;
        	
        	
        	
        	n--;
        }
        
        
        
        return answer;
    }

	public static void main(String[] args) {
		Department s = new Department();
		
		int n = 6;
		int[] times = {7,10};
		
		System.out.println("the answer is : " +s.solution(n, times));
	}

}
