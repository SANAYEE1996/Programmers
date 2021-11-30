package ysp_211130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
	public int[] solution(String[] operations) {
        int[] answer = new int[2];
        String[] exam = new String[2];
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> list = new ArrayList<>();
        int number = 0;
        for(String s : operations) {
        	exam = s.split(" ");
        	number = Integer.parseInt(exam[1]);
        	if(exam[0].equals("I")) {
        		min.add(number);
        		max.add(number);
        	}
        	else if(exam[0].equals("D")) {
        		if(number == 1 && max.size() > 0) {
        			max.poll();
        			list.clear();
        			list.addAll(min);
        			list.remove(list.size()-1);
        			min.clear();
        			min.addAll(list);
        		}
        		else if(number == -1 && min.size() > 0){
        			min.poll();
        			list.clear();
        			list.addAll(max);
        			list.remove(list.size()-1);
        			max.clear();
        			max.addAll(list);
        		}
        	}
        }
        if(max.size() == 0 || min.size() == 0) {
        	return answer;
        }
        answer[0] = max.peek();
        answer[1] = min.peek();
        
        return answer;
    }

	public static void main(String[] args) {
		String[] operations = {"I 16","D 1"};
		String[] operations1 = {"I 7","I 5","I -5","D -1"};
		String[] operations2 = {"I 4", "I 3", "I 2", 
								"I 1", "D 1", "D 1", 
								"D -1", "D -1", "I 5", "I 6"};
		
		Solution s = new Solution();
		
		System.out.println(Arrays.toString(s.solution(operations)));
		System.out.println(Arrays.toString(s.solution(operations1)));
		System.out.println(Arrays.toString(s.solution(operations2)));
		

	}

}
