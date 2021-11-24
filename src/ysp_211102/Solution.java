package ysp_211102;

import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
	public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        Map<String, PriorityQueue<Integer>> map = new Hashtable<>();
        PriorityQueue<Integer> list = new PriorityQueue<Integer>(Collections.reverseOrder());
		String[] arr = new String[5];
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < info.length; i++) {
			arr = info[i].split(" ");
			sb.setLength(0);
			sb.append(arr[0]);
			sb.append(arr[1]);
			sb.append(arr[2]);
			sb.append(arr[3]);
			if(map.containsKey(sb.toString())) {
				PriorityQueue<Integer> que2 = map.get(sb.toString());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			else {
				PriorityQueue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			
			sb.setLength(0);
			sb.append("-");
			sb.append(arr[1]);
			sb.append(arr[2]);
			sb.append(arr[3]);
			if(map.containsKey(sb.toString())) {
				PriorityQueue<Integer> que2 = map.get(sb.toString());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			else {
				PriorityQueue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			
			sb.setLength(0);
			sb.append(arr[0]);
			sb.append("-");
			sb.append(arr[2]);
			sb.append(arr[3]);
			if(map.containsKey(sb.toString())) {
				PriorityQueue<Integer> que2 = map.get(sb.toString());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			else {
				PriorityQueue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			
			sb.setLength(0);
			sb.append(arr[0]);
			sb.append(arr[1]);
			sb.append("-");
			sb.append(arr[3]);
			if(map.containsKey(sb.toString())) {
				PriorityQueue<Integer> que2 = map.get(sb.toString());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			else {
				PriorityQueue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			
			sb.setLength(0);
			sb.append(arr[0]);
			sb.append(arr[1]);
			sb.append(arr[2]);
			sb.append("-");
			que.clear();
			if(map.containsKey(sb.toString())) {
				PriorityQueue<Integer> que2 = map.get(sb.toString());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			else {
				PriorityQueue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			
			sb.setLength(0);
			sb.append("-");
			sb.append("-");
			sb.append(arr[2]);
			sb.append(arr[3]);
			que.clear();
			if(map.containsKey(sb.toString())) {
				PriorityQueue<Integer> que2 = map.get(sb.toString());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			else {
				PriorityQueue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			
			sb.setLength(0);
			sb.append("-");
			sb.append(arr[1]);
			sb.append("-");
			sb.append(arr[3]);
			que.clear();
			if(map.containsKey(sb.toString())) {
				PriorityQueue<Integer> que2 = map.get(sb.toString());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			else {
				PriorityQueue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			
			sb.setLength(0);
			sb.append("-");
			sb.append(arr[1]);
			sb.append(arr[2]);
			sb.append("-");
			que.clear();
			if(map.containsKey(sb.toString())) {
				PriorityQueue<Integer> que2 = map.get(sb.toString());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			else {
				PriorityQueue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			
			sb.setLength(0);
			sb.append(arr[0]);
			sb.append("-");
			sb.append("-");
			sb.append(arr[3]);
			que.clear();
			if(map.containsKey(sb.toString())) {
				PriorityQueue<Integer> que2 = map.get(sb.toString());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			else {
				PriorityQueue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			
			sb.setLength(0);
			sb.append(arr[0]);
			sb.append("-");
			sb.append(arr[2]);
			sb.append("-");
			que.clear();
			if(map.containsKey(sb.toString())) {
				PriorityQueue<Integer> que2 = map.get(sb.toString());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			else {
				PriorityQueue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			
			sb.setLength(0);
			sb.append(arr[0]);
			sb.append(arr[1]);
			sb.append("-");
			sb.append("-");
			que.clear();
			if(map.containsKey(sb.toString())) {
				PriorityQueue<Integer> que2 = map.get(sb.toString());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			else {
				PriorityQueue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			
			sb.setLength(0);
			sb.append("-");
			sb.append("-");
			sb.append("-");
			sb.append(arr[3]);
			que.clear();
			if(map.containsKey(sb.toString())) {
				PriorityQueue<Integer> que2 = map.get(sb.toString());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			else {
				PriorityQueue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			
			sb.setLength(0);
			sb.append("-");
			sb.append("-");
			sb.append(arr[2]);
			sb.append("-");
			que.clear();
			if(map.containsKey(sb.toString())) {
				PriorityQueue<Integer> que2 = map.get(sb.toString());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			else {
				PriorityQueue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			
			sb.setLength(0);
			sb.append("-");
			sb.append(arr[1]);
			sb.append("-");
			sb.append("-");
			que.clear();
			if(map.containsKey(sb.toString())) {
				PriorityQueue<Integer> que2 = map.get(sb.toString());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			else {
				PriorityQueue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			
			sb.setLength(0);
			sb.append(arr[0]);
			sb.append("-");
			sb.append("-");
			sb.append("-");
			que.clear();
			if(map.containsKey(sb.toString())) {
				PriorityQueue<Integer> que2 = map.get(sb.toString());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			else {
				PriorityQueue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			
			sb.setLength(0);
			sb.append("-");
			sb.append("-");
			sb.append("-");
			sb.append("-");
			que.clear();
			if(map.containsKey(sb.toString())) {
				PriorityQueue<Integer> que2 = map.get(sb.toString());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			else {
				PriorityQueue<Integer> que2 = new PriorityQueue<Integer>(Collections.reverseOrder());
				que2.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), que2);
			}
			
			sb.setLength(0);
		}
		
		String[] sajang = new String[8];
		String key = "";
		int score = 0;
		int count = 0;
		for(int i = 0; i < query.length; i++) {
			count = 0;
			sajang = query[i].split(" ");
			sb.setLength(0);
			sb.append(sajang[0]);
			sb.append(sajang[2]);
			sb.append(sajang[4]);
			sb.append(sajang[6]);
			key = sb.toString();
			score = Integer.parseInt(sajang[7]);
			if(map.containsKey(key)) {
				list.addAll(map.get(key));
				for(int j = list.size()-1; j >= 0; j--) {
					if(list.peek() < score) {
						break;
					}
					list.poll();
					count++;
				}
				answer[i] = count;
				list.clear();
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
