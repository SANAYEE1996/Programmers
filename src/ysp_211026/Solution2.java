package ysp_211026;

import java.util.ArrayList;
import java.util.Collections;

public class Solution2 {
	public int solution(String s) {
        int length = 0;
        if(s.length() % 2 == 0) {
        	length = s.length()/2;
        }
        else {
        	length = s.length()/2 + 1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= length; i++) {
        	list.add(gogo(s,i));
        }
        return Collections.min(list);
    }
	
	public static int gogo(String s, int count) {
		String after = "";
		String before = "";
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		for(int i = 0; i <= s.length()-count; i += count) {
			after = s.substring(i,i+count);
			if(before.equals(after)) {
				cnt++;
				if(i + count > s.length() - count) {
					sb.append(cnt);
					sb.append(after);
				}
			}
			else {
				if(!(i == 0 || cnt == 1)) {
					sb.append(cnt);
				}
				sb.append(before);
				if(i == s.length()-count || i + count > s.length() - count) {
					sb.append(after);
				}
				cnt = 1;
			}
			before = after;
			
			
			if(i + count > s.length() - count) {
				sb.append(s.substring(i+count));
			}
			
		}
		return sb.toString().length();
	}
	
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		
		
		System.out.println(s.solution("aabbaccc"));
		System.out.println(s.solution("ababcdcdababcdcd"));
		System.out.println(s.solution("abcabcdede"));
		System.out.println(s.solution("abcabcabcabcdededededede"));
		System.out.println(s.solution("xababcdcdababcdcd"));
		System.out.println(s.solution("aaaaaaaaaaaaaaaaa"));
		System.out.println(s.solution("abcd"));
		System.out.println(s.solution("ababababab"));
		System.out.println(s.solution("aaaabbbb"));
		
		//System.out.println(gogo("aaaaaaaaaaaaaaaaa",2));
	}
}
