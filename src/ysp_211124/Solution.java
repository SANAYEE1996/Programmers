package ysp_211124;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
 
public class Solution {
	public String[] solution(String[] record) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        String[] exam;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < record.length; i++) {
        	exam = record[i].split(" ");
        	sb.setLength(0);
        	if(exam.length == 3) {
        		if(exam[0].equals("Enter")) {
        			if(!map.containsKey(exam[1])) {
        				ArrayList<Integer> small = new ArrayList<>();
        				sb.append(exam[2]);
        				sb.append("님이 들어왔습니다.");
        				list.add(sb.toString());
        				small.add(list.size()-1);
        				map.put(exam[1], small);
        			}
        			else {
        				sb.append(exam[2]);
        				sb.append("님이 들어왔습니다.");
        				ArrayList<Integer> small = map.get(exam[1]);
        				int index = 0;
        				String beforeModify = "";
        				for (int j = 0; j < small.size(); j++) {
        					index = small.get(j);
        					beforeModify = list.get(index).substring(0,list.get(index).indexOf("님"));
							list.set(index, list.get(index).replace(beforeModify, exam[2]));
						}
        				list.add(sb.toString());
        				small.add(list.size()-1);
        				map.put(exam[1], small);
        			}
        		}
        		else {
    				ArrayList<Integer> small = map.get(exam[1]);
    				int index = 0;
    				String beforeModify = "";
    				for (int j = 0; j < small.size(); j++) {
    					index = small.get(j);
    					beforeModify = list.get(index).substring(0,list.get(index).indexOf("님"));
						list.set(index, list.get(index).replace(beforeModify, exam[2]));
					}        			
        		}
        	}
        	else {
        		ArrayList<Integer> small = map.get(exam[1]);
        		String name = list.get(small.get(0));
        		name = name.substring(0,name.indexOf("님"));
				sb.append(name);
				sb.append("님이 나갔습니다.");
				list.add(sb.toString());
				small.add(list.size()-1);
				map.put(exam[1], small);
        	}
        }
        
        String[] answer = new String[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] record = {	"Enter uid1234 Muzi", 
							"Enter uid4567 Prodo",
							"Leave uid1234",
							"Enter uid1234 Prodo",
							"Change uid4567 Ryan"};
		
		System.out.println(Arrays.toString(s.solution(record)));

	}

}
