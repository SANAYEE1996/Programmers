package LV3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

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
        PriorityQueue<Integer> que = new PriorityQueue<>();
        ArrayList<Integer> go = new ArrayList<>();
        
        Object[] keySet = map.keySet().toArray();
        Arrays.sort(keySet);
        
        Object key = 0;
        for(int i = keySet.length-1; i >= 0; i--) {
        	key = keySet[i];
        	ArrayList<Integer> exam = new ArrayList<>();
        	System.out.println("값 : " +key + " 이 있는 인덱스 들 : " +map.get(key));
        	System.out.println("들어가기 전 리스트 : " +go);
        	System.out.println("↑ 여기에 들어갈 리스트 : " +map.get(key));
        	go.addAll(map.get(key));
        	que.addAll(go);
        	
            while(!que.isEmpty()) {
            	exam.add(que.poll());
            }
            System.out.println(exam);
        }
        
        
        
        return answer;
    }
	
	public static void gogo(ArrayList<Integer> go, ArrayList<Integer> mapGet) {
		
		int key = 0;
		int mid = 0;
		int low = 0, high = 0;
		
		for(int i = 0; i < mapGet.size(); i++) {
			
			
			
		}
		
	}

	public static void main(String[] args) {
		SteppingStones s = new SteppingStones();
		
		System.out.println("the answer is : " 
		+s.solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));

	}

}
