package test_220207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
	public int[] solution(int N, int[] coffee_times) {
        int[] answer = new int[coffee_times.length];
        
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Long> list = new ArrayList<>();
        
        int minFlag = 0;
        long min = 450000;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < coffee_times.length; i++) {
        	if(list.size() < N) {
        		list.add((long)coffee_times[i]);
        		if(coffee_times[i] < min) {
        			min = coffee_times[i];
        			minFlag = i;
        		}
        		map.put(list.size()-1, i+1);
        	}
        	else {
        		
        		System.out.println(min +"   " +minFlag);
        	}
        }
        
        
        return answer;
    }
	
	
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		int[] a = {4, 2, 2, 5, 3};
		int[] b = {100, 1, 50, 1, 1};
		
		System.out.println("the answer si : " + Arrays.toString(s.solution(3, a)));
		System.out.println("the answer si : " + Arrays.toString(s.solution(1, b)));

	}

}
