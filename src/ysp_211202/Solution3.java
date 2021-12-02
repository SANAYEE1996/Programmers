package ysp_211202;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Solution3 {
	public String[] solution(String[][] tickets) {
        String start = "ICN";
        
        LinkedList<String[]> route = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        for(String[] s : tickets) {
        	route.add(s);
        }
        String now = "";
        String target = "";
        String[] exam = new String[2];
        String sb = "ICN";
        for (int i = 0; i < tickets.length; i++) {
        	exam = tickets[i];
			now = tickets[i][0];
			target = tickets[i][1];
			sb = "ICN";
			if(start.equals(now)) {
				route.remove(i);
				sb += target;
				gogo(route, target, list, sb);
				route.add(i, exam);
			}
		}
        Collections.sort(list);
        String ans = list.get(0);
        String[] answer = new String[ans.length()/3];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = ans.substring(i*3,i*3+3);
		}
        return answer;
    }
	
	public static void gogo(LinkedList<String[]> route, String now, ArrayList<String> list, String sb) {
		if(route.size() == 0) {
			list.add(sb);
		}
		else {
			ArrayList<String[]> arr = new ArrayList<>(route);
			String orgin = sb;
			String[] exam = new String[2];
			String a = "";
			String target = "";
			for (int i = 0; i < arr.size(); i++) {
				exam = arr.get(i);
				a = exam[0];
				target = exam[1];
				orgin = sb;
				if(a.equals(now)) {
					route.remove(i);
					orgin += target;
					gogo(route, target, list, orgin);
					route.add(i, exam);
				}
			}
		}
	}

	public static void main(String[] args) {
		String[][] tickets1 = {	{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets2 = {	{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, 
								{"ATL", "ICN"}, {"ATL","SFO"}};
		
		Solution3 s = new Solution3();
		System.out.println("the answer is : " +Arrays.toString(s.solution(tickets1)));
		System.out.println("the answer is : " +Arrays.toString(s.solution(tickets2)));

	}

}
