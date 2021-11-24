package ysp_211121;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution2 {
	public long solution(long[] wave1, long[] wave2) {
        long answer = -1;
        int a = wave1.length;
        int b = wave2.length;
        int max = 0;
        int resMin = 0;
        if(a >= b) {
        	max = a;
        }
        else {
        	max = b;
        }
        for(int i=max; i>=max; i++) {
	    	if(i%a==0 && i%b==0) {
	        	resMin = i;
	        	break; 
	    	}
        }
        boolean right1 = isGogo(wave1);
        boolean right2 = isGogo(wave2);
        long[] angel = new long[resMin];
        long[] devil = new long[resMin];
        LinkedList<Long> ang = new LinkedList<>();
        LinkedList<Long> dev = new LinkedList<>();
        if(angel.length == wave1.length) {
        	for(int i = 0; i < angel.length; i++) {
        		angel[i] = wave1[i];
        		ang.add(angel[i]);
        	}
        }
        else {
        	for(int i = 0; i < angel.length; i++) {
        		for(int j = 0; j < wave1.length; j++) {
        			angel[i] = wave1[j];
        			ang.add(angel[i]);
        			if(j < wave1.length -1) {
        				i++;
        			}
        		}
        	}
        }
        
        if(devil.length == wave2.length) {
        	for(int i = 0; i < devil.length; i++) {
        		devil[i] = wave2[i];
        		dev.add(devil[i]);
        	}
        }
        else {
        	for(int i = 0; i < devil.length; i++) {
        		for(int j = 0; j < wave2.length; j++) {
        			devil[i] = wave2[j];
        			dev.add(devil[i]);
        			if(j < wave2.length -1) {
        				i++;
        			}
        		}
        	}
        }
        PriorityQueue<Long> que = new PriorityQueue<>();
        long[] test = new long[angel.length];
        answer = 0;
        if(right1 && right2) {
        	for(int i = 0; i < angel.length; i++) {
        		gogo(ang, devil, test);
        		if(!isGogo(test)) {
        			que.add((long) 0);
        			break;
        		}
        		que.add(sum(test));
        	}
        	answer = que.peek();
        }
        else if(right1 && !right2) {
        	for(int i = 0; i < wave1.length; i++) {
        		answer += Math.pow(wave1[i] + devil[i],2);
        	}
        }
        else if(!right1 && right2) {
        	for(int i = 0; i < wave2.length; i++) {
        		answer += Math.pow(wave2[i] + angel[i],2);
        	}
        }
        else {
        	answer = 0;
        }
        
        return answer;
    }
	
	public static long sum(long[] test) {
		long sum = 0;
		for (int i = 0; i < test.length; i++) {
			sum += Math.pow(test[i], 2);
		}
		return sum;
	}
	
	public static void gogo(LinkedList<Long> ang,long[] devil, long[] test) {
		long head = ang.get(0);
		ang.remove(0);
		ang.add(head);
		for(int i = 0; i < ang.size(); i++) {
    		test[i] = ang.get(i) + devil[i];
    	}
	}
	
	public static boolean isGogo(long[] wave) {
		boolean isRight = false;
		for(int i = 0; i < wave.length-1; i++) {
			if(wave[i] != wave[i+1]) {
				isRight = true;
				break;
			}
		}
		return isRight;
	}

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		long[] a = {1,2,2,1,1,2};
		long[] b = {-2,-1};
		
		long[] a1 = {2,-1,3};
		long[] b1 = {-1,-1};
		
		long[] a2 = {0,1,1,1,1,1};
		long[] b2 = {0,0,1,0,0,0};
		
		long[] a3 = {2,0,1,1,1,0};
		long[] b3 = {0,0,-1};
		
		System.out.println(s.solution(a, b));
		System.out.println(s.solution(a1, b1));
		System.out.println(s.solution(a2, b2));
		System.out.println(s.solution(a3, b3));

	}

}
