package lv3;

import java.util.ArrayList;
import java.util.Collections;

public class Palindrome {
	public int solution(String s){
        int size = s.length();
        int middle = size/2;
        int mid = 0;
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String head = "";
        String tail = "";
        if(size % 2 == 0) {
        	middle--;
        }
        mid = middle;
        
        System.out.println("문자열 크기 : "+size + " 중앙 인덱스 : " +middle);
        System.out.println();
        
        
        System.out.println("홀수로 크기 나눔 : ↓");
        for(int i = 0; i < size; i++) {
        	System.out.print(i + " ");
        	if(i <= middle) {
        		tail = sb.toString();
        		head = s.substring(i+1,i+1+tail.length());
        	}
        	else {
        		tail = sb.toString().substring(0,size-i-1);
        		head = s.substring(i+1,i+1+tail.length());
        	}
        	System.out.println("head : "+head + "	tail : " + tail + "		최대 길이 : " +horse(head, tail));
        	list.add(horse(head, tail));
        	sb.insert(0, s.charAt(i));
        }
        
        System.out.println();
        System.out.println("짝수로 크기 나눔 : ↓");
        if(size % 2 != 0) {
        	middle--;
        }
        sb.setLength(0);
        sb.append(s.charAt(0));
        head = "";
        tail = "";
        System.out.println("0 head : " +head + "	tail : " +tail + "		최대길이 : " +zzaksu(head, tail));
        for(int i = 1; i < size; i++) {
        	System.out.print(i + " ");
        	sb.insert(0, s.charAt(i));
        	if(i <= middle) {
        		tail = sb.toString();
        		head = s.substring(i+1,i+1+tail.length());
        	}
        	else {
        		tail = sb.toString().substring(0,mid);
        		head = s.substring(i+1,i+1+tail.length());
        		mid--;
        	}
        	System.out.println("head : "+head + "	tail : "+tail + "		최대길이 : " +zzaksu(head, tail));
        	list.add(zzaksu(head, tail));
        }
        
        
        
        return Collections.max(list);
    }
	
	public static int horse(String head, String tail) {
		int length = 0;
		if(head.equals(tail)) {
			return head.length()*2 + 1;
		}
		else {
			for(int i = 0; i < head.length(); i++) {
				if(head.charAt(i) != tail.charAt(i)) {
					break;
				}
				length = i;
			}
			return length*2 + 1;
		}
	}
	
	public static int zzaksu(String head, String tail) {
		int length = 0;
		if(head.equals(tail)) {
			return head.length()*2;
		}
		else {
			for(int i = 0; i < head.length(); i++) {
				if(head.charAt(i) != tail.charAt(i)) {
					break;
				}
				length = i+1;
			}
			return length*2;
		}
	}

	public static void main(String[] args) {
		Palindrome s = new Palindrome();
		
		System.out.println("the answer : " +s.solution("abcdcba"));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("the answer : " +s.solution("abacde"));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("the answer : " +s.solution("ABCCBA"));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("the answer : " +s.solution("ecdabbeadc"));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("the answer : " +s.solution("cdaebbadce"));
		
		String str = "abcdef";
		System.out.println(str.substring(0,0));

	}

}
