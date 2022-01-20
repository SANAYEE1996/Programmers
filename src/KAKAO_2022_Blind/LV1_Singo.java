package KAKAO_2022_Blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LV1_Singo {
	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> map = new HashMap<>(); 
        HashMap<String, ArrayList<String>> singoza = new HashMap<>(); 
        HashMap<String, Integer> gogo = new HashMap<>(); 
        for(String s : id_list) gogo.put(s, 0);
        String[] exam = new String[2];
        for (String s : report) {
			exam = s.split(" ");
			if(!singoza.containsKey(exam[0])) 
				singoza.put(exam[0], new ArrayList<String>());
			if(!map.containsKey(exam[1])) 
				map.put(exam[1], 0);
			
			if(!singoza.get(exam[0]).contains(exam[1])) {
				map.put(exam[1], map.get(exam[1])+1);
				singoza.get(exam[0]).add(exam[1]);
			}
		}
        ArrayList<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
			if(map.get(key) >= k ) {
				list.add(key);
			}
		}
        
        ArrayList<String> fra = new ArrayList<>();
        for (String key : singoza.keySet()) {
        	fra = new ArrayList<>(singoza.get(key));
        	for (String s : fra) {
				if(list.contains(s)) {
					gogo.put(key, gogo.get(key)+1);
				}
			}
		}
        
        for (int i = 0; i < id_list.length; i++) {
			answer[i] = gogo.get(id_list[i]);
		}
        
        
        return answer;
    }

	public static void main(String[] args) {
		LV1_Singo s = new LV1_Singo();
		
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}; 
		int k = 2;
		
		String[] id_list2 = {"con", "ryan"};
		String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"}; 
		int k2 = 3;
		
		System.out.println("the answer is : " +Arrays.toString(s.solution(id_list, report, k)));
		System.out.println("the answer is : " +Arrays.toString(s.solution(id_list2, report2, k2)));

	}

}
