package ysp_211130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Solution2 {
	public int[] solution(String[] genres, int[] plays) {
		HashMap<String,ArrayList<ArrayList<Integer>>> map = new HashMap<>();
		HashMap<String,Integer> total = new HashMap<>();
		String key = "";
		for (int i = 0; i < plays.length; i++) {
			key = genres[i];
			ArrayList<Integer> list = new ArrayList<>();
			list.add(plays[i]);
			list.add(i);
			if(!map.containsKey(key)) {
				map.put(key, new ArrayList<ArrayList<Integer>>());
				total.put(key, 0);
			}
			map.get(key).add(list);
			total.put(key, total.get(key) + list.get(0));
			
		}
		for(String keySet : map.keySet()) {
			Collections.sort(map.get(keySet), new Comparator<ArrayList<Integer>>() {
	            @Override
	            public int compare(ArrayList<Integer> s1, ArrayList<Integer> s2) {
	                if (s1.get(0) == s2.get(0)) {
	                    return s2.get(1) - s1.get(1);
	                }
	                else {
	                	return s2.get(0) - s1.get(0);
	                }
	            }
	        });
		}
		
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(total.entrySet());

		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
		key = "";
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> solt = new ArrayList<>();
		int size = 0;
		for(Entry<String, Integer> entry : list_entries) {
			key = entry.getKey();
			list = map.get(key);
			size = 0;
			for (int i = 0; i < 2; i++) {
				if(list.size() > size) {
					solt.add(list.get(i).get(1));
				}
				size++;
			}
		}
        int[] answer = new int[solt.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = solt.get(i);
		}
        return answer;
    }

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		String[] genres2 = {"classic", "pop", "classic", "classic", "pop","classic"};
		int[] plays2 = {500, 600, 150, 800, 2500,800};
		String[] genres3 = {"classic", "pop", "classic", "classic", "pop","classic","rock"};
		int[] plays3 = {500, 600, 150, 800, 2500,800,1000};
		Solution2 s = new Solution2();
		System.out.println(Arrays.toString(s.solution(genres, plays)));
		System.out.println(Arrays.toString(s.solution(genres2, plays2)));
		System.out.println(Arrays.toString(s.solution(genres3, plays3)));
		

	}

}
