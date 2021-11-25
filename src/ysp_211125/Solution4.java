package ysp_211125;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

public class Solution4 {
	
	public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, ArrayList<Integer>> map = new Hashtable<>();
		String[] arr = new String[5];
		String[] exam = new String[16];
		int score = 0;
		String key = "";
		for(String i : info) {
			arr = i.split(" ");
			make(arr,exam);
			score = Integer.parseInt(arr[4]);
			for (String j : exam) {
				key = j;
				if(!map.containsKey(key)) {
					map.put(key, new ArrayList<Integer>());
				}
				map.get(key).add(score);
			}
		}
		
		for (String k : map.keySet()) {
			Collections.sort(map.get(k));
		}
		
		key = "";
		score = 0;
		String[] str = new String[2];
		for(int i = 0; i < query.length; i++) {
			str = query[i].replaceAll(" and ", "").split(" ");
			key = str[0];
			score = Integer.parseInt(str[1]);
			answer[i] = lowerBound(map, key, score);
		}		
        return answer;
    }
	
	
	public static int lowerBound(Map<String, ArrayList<Integer>> map,String key,  int score) {
		if(map.containsKey(key)) {
			ArrayList<Integer> list = map.get(key);
	        int start= 0, end = list.size()-1;
			while(start<=end) {
				int mid =(start+end)/2;
				if(list.get(mid) <score) {
					start = mid+1;	
				}else {
					end = mid-1;
				}
			}
	        return list.size()-start;
        }
		else {
			return 0;
		}
    }
	
	public static void make(String[] arr, String[] exam) {
		exam[0] = arr[0] + arr[1] + arr[2] + arr[3];
		exam[1] = "-" + arr[1] + arr[2] + arr[3];
		exam[2] = arr[0] + "-" + arr[2] + arr[3];
		exam[3] = arr[0] + arr[1] + "-" + arr[3];
		exam[4] = arr[0] + arr[1] + arr[2] + "-";
		exam[5] = "--" + arr[2] + arr[3];
		exam[6] = "-" + arr[1] + "-" + arr[3];
		exam[7] = "-" + arr[1] + arr[2] + "-";
		exam[8] = arr[0] + "--" + arr[3];
		exam[9] = arr[0] + "-" + arr[2] + "-";
		exam[10] = arr[0] + arr[1] + "--";
		exam[11] = "---" + arr[3];
		exam[12] = "--" + arr[2] +"-";
		exam[13] = "-" + arr[1] +"--";
		exam[14] = arr[0] + "---";
		exam[15] = "----";
	}
	
	
	
	public static void main(String[] args) {
		Solution4 s = new Solution4();
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
