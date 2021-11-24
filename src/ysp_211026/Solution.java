package ysp_211026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
	public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, PriorityQueue<Integer>> map = new Hashtable<>();
        PriorityQueue<Integer> que = new PriorityQueue<>();
		ArrayList<Integer> list = new ArrayList<>();
		String[] arr = new String[5];
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < info.length; i++) {
			arr = info[i].split(" ");
			que.clear();
			sb.setLength(0);
			sb.append(arr[0]);
			sb.append(arr[1]);
			sb.append(arr[2]);
			sb.append(arr[3]);
			if(map.containsKey(sb.toString())) {
				que.addAll(map.get(sb.toString()));
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			else {
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			
			
			sb.setLength(0);
			sb.append("-");
			sb.append(arr[1]);
			sb.append(arr[2]);
			sb.append(arr[3]);
			if(map.containsKey(sb.toString())) {
				que = map.get(sb.toString());
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			else {
				que.clear();
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			
			
			sb.setLength(0);
			sb.append(arr[0]);
			sb.append("-");
			sb.append(arr[2]);
			sb.append(arr[3]);
			if(map.containsKey(sb.toString())) {
				que = map.get(sb.toString());
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			else {
				que.clear();
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			
			
			sb.setLength(0);
			sb.append(arr[0]);
			sb.append(arr[1]);
			sb.append("-");
			sb.append(arr[3]);
			if(map.containsKey(sb.toString())) {
				que = map.get(sb.toString());
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			else {
				que.clear();
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			
			sb.setLength(0);
			sb.append(arr[0]);
			sb.append(arr[1]);
			sb.append(arr[2]);
			sb.append("-");
			if(map.containsKey(sb.toString())) {
				que = map.get(sb.toString());
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			else {
				que.clear();
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			
			sb.setLength(0);
			sb.append("--");
			sb.append(arr[2]);
			sb.append(arr[3]);
			if(map.containsKey(sb.toString())) {
				que = map.get(sb.toString());
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			else {
				que.clear();
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			
			sb.setLength(0);
			sb.append("-");
			sb.append(arr[1]);
			sb.append("-");
			sb.append(arr[3]);
			if(map.containsKey(sb.toString())) {
				que = map.get(sb.toString());
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			else {
				que.clear();
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			
			sb.setLength(0);
			sb.append("-");
			sb.append(arr[1]);
			sb.append(arr[2]);
			sb.append("-");
			if(map.containsKey(sb.toString())) {
				que = map.get(sb.toString());
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			else {
				que.clear();
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			
			sb.setLength(0);
			sb.append(arr[0]);
			sb.append("--");
			sb.append(arr[3]);
			if(map.containsKey(sb.toString())) {
				que = map.get(sb.toString());
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			else {
				que.clear();
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			
			sb.setLength(0);
			sb.append(arr[0]);
			sb.append("-");
			sb.append(arr[2]);
			sb.append("-");
			if(map.containsKey(sb.toString())) {
				que = map.get(sb.toString());
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			else {
				que.clear();
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			
			sb.setLength(0);
			sb.append(arr[0]);
			sb.append(arr[1]);
			sb.append("--");
			if(map.containsKey(sb.toString())) {
				que = map.get(sb.toString());
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			else {
				que.clear();
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			
			sb.setLength(0);
			sb.append("---");
			sb.append(arr[3]);
			if(map.containsKey(sb.toString())) {
				que = map.get(sb.toString());
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			else {
				que.clear();
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			
			sb.setLength(0);
			sb.append("--");
			sb.append(arr[2]);
			sb.append("-");
			if(map.containsKey(sb.toString())) {
				que = map.get(sb.toString());
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			else {
				que.clear();
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			
			sb.setLength(0);
			sb.append("-");
			sb.append(arr[1]);
			sb.append("--");
			if(map.containsKey(sb.toString())) {
				que = map.get(sb.toString());
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			else {
				que.clear();
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			
			sb.setLength(0);
			sb.append(arr[0]);
			sb.append("---");
			if(map.containsKey(sb.toString())) {
				que = map.get(sb.toString());
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			else {
				que.clear();
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			
			sb.setLength(0);
			sb.append("----");
			if(map.containsKey(sb.toString())) {
				que = map.get(sb.toString());
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			else {
				que.clear();
				que.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que);
			}
			
			que.clear();
			sb.setLength(0);
		}
		for(String key : map.keySet()) {
			System.out.println(map.get(key));
		}
		
		String[] sajang = new String[8];
		String key = "";
		int score = 0;
		int count = 0;
		for(int i = 0; i < query.length; i++) {
			count = 0;
			sajang = query[i].split(" ");
			list.clear();
			sb.setLength(0);
			sb.append(sajang[0]);
			sb.append(sajang[2]);
			sb.append(sajang[4]);
			sb.append(sajang[6]);
			key = sb.toString();
			score = Integer.parseInt(sajang[7]);
			System.out.println("키 : "+key +" , 점수 : " + score);
			if(map.containsKey(key)) {
				list.addAll(map.get(key));
				System.out.println(map.get(key));
				for(int j = list.size()-1; j >= 0; j--) {
					if(list.get(j) < score) {
						break;
					}
					count++;
				}
				answer[i] = count;
			}
			else {
				answer[i] = 0;
			}
		}
		
        return answer;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] info = {"java backend junior pizza 150",
				"python frontend senior chicken 210",
				"python frontend senior chicken 150",
				"cpp backend senior pizza 260",
				"java backend junior chicken 80",
				"python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150",
				"- and - and - and chicken 100",
				"- and - and - and - 150"};
		
		System.out.println(Arrays.toString(s.solution(info, query)));

	}

}
