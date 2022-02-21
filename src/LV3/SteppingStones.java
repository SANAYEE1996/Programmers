package LV3;

import java.util.ArrayList;
import java.util.HashMap;

public class SteppingStones {
	public int solution(int[] stones, int k) {
        int answer = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < stones.length; i++) {
        	if(!map.containsKey(stones[i])) {
        		map.put(stones[i], new ArrayList<Integer>());
        	}
        	map.get(stones[i]).add(i);
        }
        
        for(int key : map.keySet()) {
        	System.out.println("값 : " +key + " 이 있는 인덱스 들 : " +map.get(key));
        }
        
        
        
        
        return answer;
    }

	public static void main(String[] args) {
		SteppingStones s = new SteppingStones();
		
		System.out.println("the answer is : " 
		+s.solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));

	}

}
