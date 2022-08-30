package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class MakeQueSum {
	
	int maxSize = 0;
	
	public int solution(int[] queue1, int[] queue2) {
		maxSize = (queue1.length+queue2.length)*2;
        Queue<Long> first = new LinkedList<>();
        Queue<Long> second = new LinkedList<>();
        long firstSum = 0;
        long secondSum = 0;
        for(int i=0 ; i < queue1.length; i++) {
        	firstSum += (long)queue1[i];
        	first.add((long)queue1[i]);
        	secondSum += (long)queue2[i];
        	second.add((long)queue2[i]);
        }
        if(firstSum == secondSum) {
        	return 0;
        }
        int[] chance = {0};
        caculate(chance, first, second, firstSum, secondSum);
        
        return chance[0];
    }
	
	void caculate(int[] chance, 
				  Queue<Long> first, Queue<Long> second,
				  long firstSum, long secondSum) {
		long pollValue = 0;
		while(maxSize > 0) {
			if(firstSum == secondSum) {
				return;
			}
			else if(firstSum < secondSum) {
				pollValue = second.poll();
				first.add(pollValue);
				firstSum += pollValue;
				secondSum -= pollValue;
			}
			else {
				pollValue = first.poll();
				second.add(pollValue);
				firstSum -= pollValue;
				secondSum += pollValue;
			}
			chance[0]++;
			maxSize--;
		}
		if(firstSum != secondSum) {
			chance[0] = -1;
		}
	}
	
	
}
