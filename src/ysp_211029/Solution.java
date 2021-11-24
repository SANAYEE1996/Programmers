package ysp_211029;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
	public String[] solution(String[] orders, int[] course) {
		HashMap<String,Integer> map = new HashMap<>();
		char[] a;
		for(int i = 0; i < orders.length; i++) {
			a = orders[i].toCharArray();
			Arrays.sort(a);
			orders[i] = new String(a);
			for(int j = 0; j < orders[i].length(); j++) {
				if(map.containsKey(orders[i].substring(j,j+1))) {
					map.put(orders[i].substring(j,j+1), map.get(orders[i].substring(j,j+1))+1);
				}
				else {
					map.put(orders[i].substring(j,j+1), 1);
				}
				gogo(orders[i].substring(j,j+1),orders[i].substring(j+1),map);
			}
		}
		ArrayList<String> list = new ArrayList<>();
		
		
		for(int i = 0; i < course.length; i++) {
			HashMap<String,Integer> gomap = new HashMap<>();
			for(String key : map.keySet()) {
				if(key.length() == course[i] && map.get(key) >= 2) {
					gomap.put(key, map.get(key));
				}
			}
			if(gomap.size() > 0) {
				Integer max = Collections.max(gomap.values());
				
				for(String key : gomap.keySet()) {
					if(gomap.get(key) == max) {
						list.add(key);
					}
				}
			}
		}
		Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	
	public static void gogo(String first, String order,HashMap<String,Integer> map) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < order.length(); i++) {
			sb.append(first);
			sb.append(order.charAt(i));
			if(map.containsKey(sb.toString())) {
				map.put(sb.toString(), map.get(sb.toString())+1);
			}
			else {
				map.put(sb.toString(), 1);
			}
			gogo(sb.toString(),order.substring(i+1),map);
			sb.setLength(0);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] a = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] a1 = {2,3,4};
		String[] b = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] b1 = {2,3,5};
		String[] c = {"XYZ", "XWY", "WXA"};
		int[] c1 = {2,3,4};
		
		System.out.println(Arrays.toString(s.solution(a, a1)));
		System.out.println(Arrays.toString(s.solution(b, b1)));
		System.out.println(Arrays.toString(s.solution(c, c1)));
		

	}

}
