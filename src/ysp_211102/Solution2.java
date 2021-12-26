package ysp_211102;

import java.util.ArrayList;

public class Solution2 {
	public String solution(String p) {
        if(isRight(p)) {
        	return p;
        }
        else if(p.equals("")) {
        	return "";
        }
        else {
        	return gogo(p);
        }
    }
	 
	public static String gogo(String p) {
		String u;
		String v;
		StringBuilder sb = new StringBuilder();
		int left = 0;
		int right = 0;
		int flag = 0;
		for(int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == ')') {
				right++;
			}
			else if(p.charAt(i) == '(') {
				left++;
			}
			
			if(left == right) {
				flag = i+1;
				break;
			}
		}
		u = p.substring(0,flag);
		v = p.substring(flag);
		if(isRight(u)) {
			if(!isRight(v)) {
				v = gogo(v);
			}
			sb.append(u);
			sb.append(v);
		}
		else {
			if(!isRight(v)) {
				v = gogo(v);
			}
			u = change(u.substring(1,u.length()-1));
			v = "(" + v + ")";
			sb.append(v);
			sb.append(u);
		}
		
		return sb.toString();
	}
	
	public static String change(String u) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < u.length(); i++) {
			if(u.charAt(i) == '(') {
				sb.append(')');
			}
			else {
				sb.append('(');
			}
		}
		
		return sb.toString();
	}
	
	public static boolean isRight(String s) {
		ArrayList<Character> list = new ArrayList<>();
        list.add('!');
        for(int i = 0; i < s.length(); i++) {
        	if(list.get(list.size()-1) =='(' && s.charAt(i) == ')') {
        		list.remove(list.size()-1);
        	}
        	else {
        		list.add(s.charAt(i));
        	}
        }
        if(list.size() == 1) {
        	return true;
        }
        else {
        	return false;
        }
	}

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println(s.solution("(()())()"));
		System.out.println(s.solution(")("));
		System.out.println(s.solution("()))((()"));
		System.out.println(s.solution(""));
		

	}

}
