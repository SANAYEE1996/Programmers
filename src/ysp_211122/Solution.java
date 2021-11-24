package ysp_211122;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sum = 0;
        Queue<Integer> bridge = new LinkedList<>(Arrays.asList(new Integer[bridge_length]));
        Queue<Integer> readyTruck = new LinkedList<>();
        for(int i : truck_weights) {
        	readyTruck.add(i);
        }
        while(true) {
        	time++;
        	if(bridge.peek() != null) {
        		sum -= bridge.poll();
        	}
        	else {
        		bridge.poll();
        	}
        	
        	if(readyTruck.isEmpty()) {
        		time += bridge.size();
        		break;
        	}
        	else {
        		if(sum + readyTruck.peek() <= weight) {
        			sum += readyTruck.peek();
            		bridge.add(readyTruck.poll());
            	}
            	else {
            		bridge.add(null);
            	}
        	}
        }
        
        return time;
    }
	
	public static void main(String[] args) {
		int[] a = {7,4,5,6};
		int[] b = {10};
		int[] c = {10,10,10,10,10,10,10,10,10,10};
		int[] d = new int[10000];
		for(int i = 0; i < d.length; i++) {
			d[i] = 10;
		}
		Solution s = new Solution();
		
		long start;
		long end;
		
		start = System.nanoTime();
		System.out.println(s.solution(2, 10, a));
		end = System.nanoTime();
		System.out.println("소요 시간 : " +(end-start));
		
		start = System.nanoTime();
		System.out.println(s.solution(100, 100, b));
		end = System.nanoTime();
		System.out.println("소요 시간 : " +(end-start));
		
		start = System.nanoTime();
		System.out.println(s.solution(100, 100, c));
		end = System.nanoTime();
		System.out.println("소요 시간 : " +(end-start));
		
		start = System.nanoTime();
		System.out.println(s.solution(10000, 10, d));
		end = System.nanoTime();
		System.out.println("소요 시간 : " +(end-start));
		

	}

}
