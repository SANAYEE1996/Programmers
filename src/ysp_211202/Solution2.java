package ysp_211202;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Solution2 {
	public int solution(String begin, String target, String[] words) {
		
        LinkedList<String> list = new LinkedList<>();
        for (String word : words) {
			list.add(word);
		}
        String s = "";
        String newBegin = "";
        ArrayList<Integer> stage = new ArrayList<>();
        int length = words.length;
        for (int i = 0; i < words.length; i++) {
			if(differCount(begin, words[i]) == 1) {
				s = list.get(i);
				list.remove(i);
				newBegin = words[i];
				gogo(list, newBegin, target,stage,length);
				list.add(i, s);
			}
		}
        if(stage.size() > 0) {
        	return Collections.min(stage);
        }
        else {
        	return 0;
        }
    }
	
	public static void gogo(LinkedList<String> list, String begin, String target, ArrayList<Integer> stage, int length) {
		ArrayList<String> exam = new ArrayList<>(list);
		String s = "";
		String newBegin = "";
		if(begin.equals(target)) {
			stage.add(length - list.size());
		}
		else {
			for (int i = 0; i < exam.size(); i++) {
				if(differCount(begin, exam.get(i)) == 1) {
					s = exam.get(i);
					list.remove(i);
					newBegin = s;
					gogo(list, newBegin, target,stage,length);
					list.add(i,s);
				}
			}
		}
	}
	
	public static int differCount(String a, String b) {
		int differCount = 0;
		for (int i = 0; i < a.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) {
				differCount++;
			}
		}
		return differCount;
	}

	public static void main(String[] args) {
		String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
		String[] words2 = {"hot", "dot", "dog", "lot", "log"};
		
		Solution2 s = new Solution2();
		
		System.out.println("the answer is : "+s.solution("hit", "cog", words1));
		System.out.println("the answer is : "+s.solution("hit", "cog", words2));

	}

}
