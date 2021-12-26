package ysp_211226;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
	public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> aQue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> bQue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : A) aQue.add(i);
        for(int i : B) bQue.add(i);
        int aMax = 0;
        int bMax = 0;
        while(!(aQue.isEmpty() || bQue.isEmpty())) {
        	aMax = aQue.poll();
        	bMax = bQue.poll();
        	if(aMax < bMax) answer++;
        	else bQue.add(bMax);
        }
        return answer;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = {5,1,3,7};
		int[] B = {2,2,6,8};
		int[] A1 = {2,2,2,2};
		int[] B1 = {1,1,1,1};
		System.out.println("the answer is : " +s.solution(A, B));
		System.out.println("the answer is : " +s.solution(A1, B1));
	}

}
