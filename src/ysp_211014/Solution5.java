package ysp_211014;

import java.util.PriorityQueue;

public class Solution5 {
	public String solution(String[] registered_list, String new_id) {
        String answer = "";
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(); 
        for(String item : registered_list) {
        	priorityQueue.add(item);
        }
        StringBuilder sb = new StringBuilder();
        if(!priorityQueue.contains(new_id)) {
        	return new_id;
        }
        else {
        	int flag = 0;
        	for(int i = 0; i < new_id.length(); i++) {
        		if(Character.isDigit(new_id.charAt(i))) {
        			flag = i;
        			break;
        		}
        	}
        	int number = 0;
        	int num = 1;
    		if(flag != 0) {
        		number = Integer.parseInt(new_id.substring(flag));
        		while(true) {
	        		sb.append(new_id.substring(0,flag));
	        		sb.append(number);
	        		if(!priorityQueue.contains(sb.toString())) {
	        			answer = sb.toString();
	        			break;
	        		}
	        		else {
	        			while(!priorityQueue.peek().equals(sb.toString())) {
	        				priorityQueue.remove();
	        			}
	        			number++;
	        			sb.setLength(0);
	        		}
        		}
    		}
    		else {
    			while(true) {
	    			sb.append(new_id);
	    			sb.append(num);
	    			if(!priorityQueue.contains(sb.toString())) {
	    				answer = sb.toString();
	        			break;
	    			}
	    			else {
	    				while(!priorityQueue.peek().equals(sb.toString())) {
	        				priorityQueue.remove();
	        			}
	    				num++;
	        			sb.setLength(0);
	        		}
    			}
    		}
        }
        
        
        return answer;
    }

	public static void main(String[] args) {
		Solution5 s = new Solution5();
		String[] a = {"bird99", "bird98", "bird101", "gotoxy"};
		String a1 = "bird98";
		System.out.println(s.solution(a, a1));
	}

}
