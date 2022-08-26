package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class MakeQueSum {
	public int solution(int[] queue1, int[] queue2) {
		
        Queue<Integer> first = new LinkedList<>();
        Queue<Integer> second = new LinkedList<>();
        long firstSum = 0;
        long secondSum = 0;
        for(int i=0 ; i < queue1.length; i++) {
        	firstSum += (long)queue1[i];
        	first.add(queue1[i]);
        	secondSum += (long)queue2[i];
        	second.add(queue2[i]);
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
	
	void getFirstToSecond(Queue<Integer> first, Queue<Integer> second,
						  long firstSum, long secondSum, int[] chance) {
		if(chance[0] > (first.size()+second.size())*2) {
			chance[0] = -1;
			return;
		}
		int firstPollValue = first.poll();
		//System.out.println("first Poll Value : " +firstPollValue);
		second.add(firstPollValue);
		firstSum -= (long)firstPollValue;
		secondSum += (long)firstPollValue;
		//System.out.println("firstSum : " +firstSum + " secondSum : " +secondSum);
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
	
	void getSecondToFirst(Queue<Integer> first, Queue<Integer> second,
						  long firstSum, long secondSum, int[] chance) {
		if(chance[0] > (first.size()+second.size())*2) {
			chance[0] = -1;
			return;
		}
		int secondPollValue = second.poll();
//		System.out.println("second Poll Value : " +secondPollValue);
		first.add(secondPollValue);
		firstSum += (long)secondPollValue;
		secondSum -= (long)secondPollValue;
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
