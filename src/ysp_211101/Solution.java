package ysp_211101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeSet;

public class Solution {
	public int solution(String[][] relation) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        TreeSet<String> set = new TreeSet<>();
        for(int i = 0; i < relation[0].length; i++) {
        	for(int j = 0; j < relation.length; j++) {
        		set.add(relation[j][i]);
        	}
        	if(set.size() == relation.length) {
        		list.add(i);
        	}
        	set.clear();
        }
        String[][] str = new String[relation.length][relation[0].length-list.size()];
        int flag = 0;
        for(int i = 0; i < str.length; i++) {
        	flag = 0;
        	for(int j = 0; j < relation[0].length; j++) {
        		if(!list.contains(j)) {
        			str[i][flag] = relation[i][j];
        			flag++;
        		}
        	}
        }
        
        System.out.println();
        answer = gogo(str) + list.size();
        
        return answer;
    }
	
	public static void gugu(String[] exam, String first,int flag, int count,ArrayList<String> list) {
		StringBuilder sb = new StringBuilder();
		int afterFlag = flag;
		int afterCount = count;
		if(count > 0) {
			for(int i = flag; i < exam.length; i++) {
				afterFlag = i;
				afterCount = count;
				sb.append(first);
				sb.append(exam[i]);
				afterFlag++;
				afterCount--;
				if(afterCount == 0) {
					list.add(sb.toString());
				}
				gugu(exam, sb.toString(), afterFlag, afterCount,list);
				sb.setLength(0);
			}
		}
	}
	
	
	public static int gogo(String[][] str) {
		ArrayList<String> list = new ArrayList<>();
		LinkedList<String> part = new LinkedList<>();
		TreeSet<String> set = new TreeSet<>();
		for(int i = 0; i < str.length; i++) {
			for(int j = 1; j <= str.length; j++) {
				gugu(str[i],"",0,j,list);
			}
		}
		
		int count = (int) Math.pow(2, str[0].length) - 1;
		
		for(int i = 0; i < count; i++) {
			for(int j = i; j < list.size(); j += count) {
				set.add(list.get(j));
			}
			
			if(set.size() == str.length) {
				part.addAll(set);
			}
			set.clear();
		}
		gaboja(part);
		int cnt = 1;
		for (String i : part) {
			System.out.print(i +" ");
			if(cnt % str.length == 0) {
				System.out.println();
			}
			cnt++;
		}
		return part.size()/str.length;
	}
	
	public static void gaboja(LinkedList<String> part) {
		
		String a = "";
		int size = part.size();
		for(int i = 0; i < size; i++) {
			if(i < part.size()) {
				a = part.get(i);
				part.remove(i);
				for(int j = 0; j < part.size(); j++) {
					if(part.get(j).contains(a)) {
						part.remove(j);
						break;
					}
				}
				part.add(i, a);
			}
			else {
				break;
			}
		}
		
		
	}
	
	public static boolean isRight(ArrayList<String> all, ArrayList<String> part) {
		boolean isRight = true;
		END:
		for(int i = 0; i < part.size(); i++) {
			for(int j = 0; j < all.size(); j++) {
				if(part.get(i).contains(all.get(j))) {
					isRight = false;
					break END;
				}
			}			
		}
		return isRight;
	}
	
	public static void main(String[] args) {
		String[][] a = {{"100","ryan","music","2"},
				{"200","apeach","math","2"},
				{"300","tube","computer","3"},
				{"400","con","computer","4"},
				{"500","muzi","music","3"},
				{"600","apeach","music","2"}};
		
		String[][] b = {{"100","ryan","music","2","daegu"},
				{"200","apeach","math","2","busan"},
				{"300","tube","computer","3","jeju"},
				{"400","con","computer","4","seoul"},
				{"500","muzi","music","3","incheon"},
				{"600","apeach","music","2","jeju"}};
		
		String[][] c = { {"a","1","aaa","c","ng"},
						{"a","1","bbb","e","g"},
						{"c","1","aaa","d","ng"},
						{"d","2","bbb","d","ng"}};
		
		Solution s = new Solution();
		
		System.out.println(s.solution(a));
		System.out.println(s.solution(b));
		System.out.println(s.solution(c));
		

	}

}
