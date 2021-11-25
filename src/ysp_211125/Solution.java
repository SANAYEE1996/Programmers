package ysp_211125;

import java.util.HashMap;

public class Solution {
	
	public int solution(int K, String[] user_scores) {
        int answer = 0;
        String key = "";
        int score = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < user_scores.length; i++) {
        	key = user_scores[i].split(" ")[0];
        	score = Integer.parseInt(user_scores[i].split(" ")[1]);
        	if(map.size() < 3) {
        		map.put(key, score);
        		answer++;
        	}
        	else {
        		if(map.containsKey(key) && map.get(key) < score) {
        			map.put(key, score);
        			answer++;
        		}
        		else if(!map.containsKey(key)){
        			String minKey = "";
        			int min = 0;
        			for (String k : map.keySet()) {
        				min = map.get(k);
						if(min < score) {
							minKey = k;
						}
					}
        		}
        	}
			
		}
        
        
        return answer;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		
		int k1 = 3;
		int k2 = 3;
		int k3 = 2;
		
		String[] a = {"alex111 100", 
				"cheries2 200", 
				"coco 150", 
				"luna 100", 
				"alex111 120", 
				"coco 300", 
				"cheries2 110"};
		String[] b = {"alex111 100", 
				"cheries2 200", 
				"alex111 200", 
				"cheries2 150", 
				"coco 50", 
				"coco 200"};
		String[] c = {"cheries2 200", 
				"alex111 100", 
				"coco 150", 
				"puyo 120"};
		
		System.out.println(s.solution(k1, a));
		System.out.println(s.solution(k2, b));
		System.out.println(s.solution(k3, c));

	}

}
