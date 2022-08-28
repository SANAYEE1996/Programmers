package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class MakeQueSum {
	
	int maxSize = 0;
	
	public int solution(int[] queue1, int[] queue2) {
		System.out.println(Long.MAX_VALUE);
		System.out.println((long)300000*100000000);
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
        if(firstSum < secondSum) {
        	getSecondToFirst(first, second, firstSum, secondSum, chance);
        }
        else {
        	getFirstToSecond(first, second, firstSum, secondSum, chance);
        }
        
        return chance[0];
    }
	
	void getFirstToSecond(Queue<Long> first, Queue<Long> second,
						  long firstSum, long secondSum, int[] chance) {
		if(chance[0] > maxSize) {
			chance[0] = -1;
			return;
		}
		if(first.isEmpty()) {
			getSecondToFirst(first, second, firstSum, secondSum, chance);
			return;
		}
		long firstPollValue = first.poll();
		second.add(firstPollValue);
		firstSum -= firstPollValue;
		secondSum += firstPollValue;
//		System.out.println("first Poll Value : " +firstPollValue);
//		System.out.println("firstSum : " +firstSum + " secondSum : " +secondSum);
		chance[0]++;
		if(firstSum == secondSum) {
			return;
		}
		else if(firstSum < secondSum) {
			getSecondToFirst(first, second, firstSum, secondSum, chance);
		}
		else {
			getFirstToSecond(first, second, firstSum, secondSum, chance);
		}
	}
	
	void getSecondToFirst(Queue<Long> first, Queue<Long> second,
						  long firstSum, long secondSum, int[] chance) {
		if(chance[0] > maxSize) {
			chance[0] = -1;
			return;
		}
		if(second.isEmpty()) {
			getFirstToSecond(first, second, firstSum, secondSum, chance);
			return;
		}
		long secondPollValue = second.poll();
		first.add(secondPollValue);
		firstSum += secondPollValue;
		secondSum -= secondPollValue;
//		System.out.println("second Poll Value : " +secondPollValue);
//		System.out.println("firstSum : " +firstSum + " secondSum : " +secondSum);
		chance[0]++;
		if(firstSum == secondSum) {
			return;
		}
		else if(firstSum < secondSum) {
			getSecondToFirst(first, second, firstSum, secondSum, chance);
		}
		else {
			getFirstToSecond(first, second, firstSum, secondSum, chance);
		}
	}
	
	
}
