package ysp_211014;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution4 {
	
	public int[] solution(int n, long left, long right) {
        int[] answer = new int[Math.toIntExact(right-left)+1];
        int leftmot = Math.toIntExact(left/n) + 1;
        int leftnam = Math.toIntExact(left%n);
        ArrayList<Integer> list = new ArrayList<>();
        while(true) {
        	int k = leftmot;
        	for(int i = 0; i < leftmot; i++) {
        		list.add(leftmot);
        		if(list.size()-leftnam == answer.length) {
            		break;
            	}
        	}
        	if(list.size()-leftnam == answer.length) {
        		break;
        	}
        	for(int i = 0; i < n-leftmot; i++) {
        		k++;
        		list.add(k);
        		if(list.size()-leftnam == answer.length) {
            		break;
            	}
        	}
        	if(list.size()-leftnam == answer.length) {
        		break;
        	}
        	leftmot++;
        }
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i+leftnam);
        }
        return answer;
    }

	public static void main(String[] args) {
		Solution4 s = new Solution4();
		System.out.println(Arrays.toString(s.solution(3, 2, 5)));
		System.out.println(Arrays.toString(s.solution(4, 7, 14)));
		//System.out.println(Arrays.toString(s.solution((int)Math.pow(10, 7), (long)Math.pow(10, 7), (long)Math.pow(10, 7) )));

	}

}
