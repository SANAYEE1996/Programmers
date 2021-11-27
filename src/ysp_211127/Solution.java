package ysp_211127;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	public String solution(String source) {
        String dest = "";
        ArrayList<Character> list = new ArrayList<>();
        gogo(source, dest, list);
        StringBuilder sb = new StringBuilder();
        for (char i : list) {
			sb.append(i);
		}
        return sb.toString();
    }
	
	public static void gogo(String source, String dest, ArrayList<Character> list) {
		ArrayList<Character> copy = new ArrayList<>();
        for (int i = 0; i < source.length(); i++) {
			if(!copy.contains(source.charAt(i))) {
				copy.add(source.charAt(i));
			}
			else {
				dest += source.charAt(i);
			}
		}
        Collections.sort(copy);
        list.addAll(copy);
		if(!dest.equals("")) {
			source = dest;
			dest = "";
			gogo(source, dest, list);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println("the answer is : " +s.solution("execute"));
		System.out.println("the answer is : " +s.solution("cucumber"));
		System.out.println("the answer is : " +s.solution("bbaabd"));

	}

}
