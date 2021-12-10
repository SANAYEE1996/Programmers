package ysp_211210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	public int[] solution(String[] gems) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        HashSet<String> ordin = new HashSet<>();
        for(String s : gems) {
        	ordin.add(s);
        }
        int size = ordin.size();
        ordin.clear();
        String key = "";
        ArrayList<Integer> list = new ArrayList<>();
        int[] minSection = new int[1];
        minSection[0] = 100000;
        HashSet<String> next = new HashSet<>();
        for(int i = 0; i < gems.length; i++) {
        	key = gems[i];
        	if(!map.containsKey(key)) {
        		map.put(key, new ArrayList<Integer>());
        	}
        	map.get(key).add(i+1);
        	ordin.add(key);
        	next.add(key);
        	if(next.size() == size && ordin.size() == size) {
        		next.clear();
        		make(list, map, minSection);
        	}
        }
        System.out.println(list);
        int[] answer = new int[2];
        return answer;
    }
	
	public static void make(ArrayList<Integer> list,
			HashMap<String, ArrayList<Integer>> map,
			int[] minSection) {
		int lastIndex = 0;
		ArrayList<Integer> exam = new ArrayList<>();
		for(String key : map.keySet()) {
			lastIndex = map.get(key).size()-1;
			exam.add(map.get(key).get(lastIndex));
		}
		int max = Collections.max(exam);
		int min = Collections.min(exam);
		exam.clear();
		exam.add(min);
		exam.add(max);
		if(max - min < minSection[0]) {
			minSection[0] = max - min;
			list.clear();
			list.addAll(exam);
		}
		else if(max - min == minSection[0]) {
			if(list.get(0) > min) {
				list.clear();
				list.addAll(exam);
			}
		}
	}

	public static void main(String[] args) {
		
		Solution s = new Solution();
		String[] games1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		String[] games2 = {"AA", "AB", "AC", "AA", "AC"};
		String[] games3 = {"XYZ", "XYZ", "XYZ"};
		String[] games4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		
		System.out.println("the answer is : " + Arrays.toString(s.solution(games1)));
		System.out.println("the answer is : " + Arrays.toString(s.solution(games2)));
		System.out.println("the answer is : " + Arrays.toString(s.solution(games3)));
		System.out.println("the answer is : " + Arrays.toString(s.solution(games4)));

	}

}
