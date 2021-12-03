package ysp_211203;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
	
	
	public int solution(String[] user_id, String[] banned_id) {
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> all = new ArrayList<>();
        for (int i = 0; i < banned_id.length; i++) {
			map.put(i, new ArrayList<String>());
			for (int j = 0; j < user_id.length; j++) {
				if(isCorrect(user_id[j], banned_id[i])) {
					map.get(i).add(user_id[j]);
					if(!all.contains(user_id[j])) all.add(user_id[j]);
				}
			}
		}
        int totalLength = map.size();
    	ArrayList<String> str = new ArrayList<>(map.get(0));
    	ArrayList<ArrayList<String>> list = new ArrayList<>();
    	for (String j : str) {
			ArrayList<String> good = new ArrayList<>();
			good.add(j);
			gogo(map, 1, good, totalLength, list);
		}
        
        return list.size();
    }
	
	public static void gogo(HashMap<Integer, ArrayList<String>> map, int flag, ArrayList<String> good, int totalLength, ArrayList<ArrayList<String>> list) {
		if(flag < totalLength) {
			ArrayList<String> str = new ArrayList<>(map.get(flag));
			for(String j : str) {
				ArrayList<String> gg = new ArrayList<>(good);
				if(!gg.contains(j)) {
					gg.add(j);
					gogo(map, flag+1, gg, totalLength, list);
				}
			}
		}
		else {
			Collections.sort(good);
			if(!list.contains(good)) {
				list.add(good);
			}
		}
	}
	
	
	
	public static boolean isCorrect(String a, String b) {
		boolean isCorrect = true;
		if(a.length() == b.length()) {
			for (int i = 0; i < a.length(); i++) {
				if(b.charAt(i) == '*') continue;
				if(a.charAt(i) != b.charAt(i)) {
					isCorrect = false;
					break;
				}
			}
			return isCorrect;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "abc1**"};
		
		String[] user_id1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id1 = {"*rodo", "*rodo", "******"};
		
		String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id2 = {"fr*d*", "*rodo", "******", "******"};
		
		String[] user_id3 = {"aaaaaaaa", "bbbbbbbb", "cccccccc", "dddddddd", 
								"eeeeeeee", "ffffffff", "gggggggg", "hhhhhhhh"};
		String[] banned_id3 = {"********", "********", "********", "********",
								"********", "********", "********", "********",};
		
		Solution s = new Solution();
		System.out.println("the answer is : " +s.solution(user_id, banned_id) +"\n-----------------------");
		System.out.println("the answer is : " +s.solution(user_id1, banned_id1)+"\n-----------------------");
		System.out.println("the answer is : " +s.solution(user_id2, banned_id2)+"\n-----------------------");
		System.out.println("the answer is : " +s.solution(user_id3, banned_id3)+"\n-----------------------");
		
	

	}

}
