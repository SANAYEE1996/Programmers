package ysp_211116;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> truck = new LinkedList<>();
        for(int i : truck_weights) {
        	truck.add(i);
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++) {
        	que.add(0);
        }
        Queue<Integer> complete = new LinkedList<>();
        int sum = 0;
        while(true) {
        	time++;
        	que.poll();
        	if(truck.size() > 0 && sum + truck.peek() <= weight) {
        		que.poll();
        		sum += truck.peek();
	        	que.add(truck.peek());
	        	truck.poll();
        	}
        	else {
        		if(que.size() > 0 ) {
	        		if(que.peek() != 0) {
	        			complete.add(que.peek());
	        			sum -= que.peek();
	        		}
	        		que.poll();
	        		que.add(0);
        		}
        	}
        	System.out.println(que);
        	if(complete.size() == truck_weights.length) {
        		break;
        	}
        }
        
        return time;
    }

	public static void main(String[] args) {
		int[] a = {7,4,5,6};
		int[] b = {10};
		int[] c = {10,10,10,10,10,10,10,10,10,10};
		Solution s = new Solution();
		System.out.println(s.solution(2, 10, a));
		//System.out.println(s.solution(100, 100, b));
		//System.out.println(s.solution(100, 100, c));

	}

}

/*
 * 0	[ , , , ]	[ , ]	[7,4,5,6]
 * 1	[ , , , ]	[ ,7]	[4,5,6]
 * 2	[ , , , ]	[7, ]	[4,5,6]
 * 3	[7, , , ]	[ ,4]	[5,6]
 * 4	[7, , , ]	[4,5]	[6]
 * 5	[7,4, , ]	[5, ]	[6]
 * 6	[7,4,5, ]	[ ,6]	[]
 * 7	[7,4,5, ]	[6, ]	[]
 * 8	[7,4,5,6]	[ , ]	[]
 */