package ysp_211103;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	 
	public int solution(String word) {
		int answer = 0;
		ArrayList<String> list = new ArrayList<>();
		String[] a = {"A","E","I","O","U"};
		for(int i = 1; i <= 5; i++) {
			gogo(a, list, "", i);
		}
		ArrayList<String> kk = new ArrayList<>();
		for(String i : list) {
			if(!kk.contains(i)) {
				kk.add(i);
			}
		}
		Collections.sort(kk);
		for(int i = 0; i < kk.size(); i++) {
			if(kk.get(i).equals(word)) {
				answer = i+1;
				break;
			}
		}
       
        return answer;
    }
	
	public static void gogo(String[] a, ArrayList<String> list,String first,int flag) {
		StringBuilder sb = new StringBuilder();
		int count = flag;
		if(count > 0) {
			for(int i = 0; i < a.length; i++) {
				count = flag;
				sb.append(first);
				sb.append(a[i]);
				list.add(sb.toString());
				count--;
				gogo(a, list, sb.toString(),count);
				sb.setLength(0);
			}
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("AAAAE"));
		System.out.println(s.solution("AAAE"));
		System.out.println(s.solution("I"));
		System.out.println(s.solution("EIO"));

	}

}
