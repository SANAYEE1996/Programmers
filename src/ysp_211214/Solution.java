package ysp_211214;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Solution {
	public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        ArrayList<Integer> clock = new ArrayList<>();
        for(int i = 0; i < weak.length-1; i++) {
        	clock.add(weak[i+1] - weak[i]);
        }
        clock.add(weak[0] + n - weak[weak.length-1]);
        
        
        System.out.println(Arrays.toString(weak));
        System.out.println(clock);
        LinkedList<Integer> people = new LinkedList<>();
        for(int i : dist) people.add(i);
        int max = 0;
        int sum = 0;
        int size = 0;
        int afterSize = 0;
        max = Collections.max(people);
        int mmm = 0;
        int maxFlag = 0;
        for(int i = 0; i < clock.size(); i++) {
        	
        	size = clock.size() - 1 + i; //->3
        	sum = 0;
        	afterSize = 0;
        	if(size> clock.size()) {
        		afterSize = size - clock.size();
        		size = clock.size();
        	}
        	for (int j = i; j < size; j++) {
				sum += clock.get(j);
			}
        	for (int j = 0; j < afterSize; j++) {
        		sum += clock.get(j);
			}
        	System.out.println(weak[i]+" 을 기준으로 시계 : " +sum);
        	if(sum <= max && sum > mmm) {
        		mmm = sum;
        		maxFlag = i;
        	}
        	
        	size = i-1 - (clock.size()-1); //->3
        	sum = 0;
        	afterSize = clock.size();
        	if(size < 0) {
        		afterSize = size + clock.size();
        		size = 0;
        	}
        	for (int j = i-1; j >= size; j--) {
				sum += clock.get(j);
			}
        	for (int j = clock.size()-1; j > afterSize; j--) {
        		sum += clock.get(j);
			}
        	System.out.println(weak[i]+" 을 기준으로 반 시계 : " +sum);
        	
        	System.out.println();
        	if(sum <= max && sum > mmm) {
        		mmm = sum;
        		maxFlag = i;
        	}
        	
        }
        
        System.out.println("가장 이득 취할 수 있는 플래그 :" +maxFlag +" 와 그 길이 : "+ mmm);
        
        
        
        return answer;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		
		int n = 12;
		int[] weak = {1, 5, 6, 10};
		int[] dist = {1, 2, 3, 4};
		int[] weak2 = {1, 3, 4, 9, 10};
		int[] dist2 = {3, 5, 7};
		
		System.out.println("the answer is : " +s.solution(n, weak, dist));
		System.out.println("the answer is : " +s.solution(n, weak2, dist2));
	}

}
