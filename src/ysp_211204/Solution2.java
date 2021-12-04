package ysp_211204;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution2 {
	
	public int solution(int n, String[] recipes, String[] orders) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] str = new String[2];
        for(String s : recipes) {
        	str = s.split(" ");
        	map.put(str[0], Integer.parseInt(str[1]));
        }
        ArrayList<Integer> hwagu = new ArrayList<>();
        for(int i = 0; i < n; i++) {
        	hwagu.add(0);
        }
        int minIndex = 0;
        int min = 0;
        int cookTime = 0;
        int startTime = 0;
        String key = "";
        String[] exam = new String[2];
        int answerIndex = 0;
        for(int i = 0; i < orders.length; i++) {
        	exam = orders[i].split(" ");
        	startTime = Integer.parseInt(exam[1]);
        	key = exam[0];
        	cookTime = map.get(key);
        	min = Collections.min(hwagu);
        	minIndex = hwagu.indexOf(min);
        	if(min <= startTime) {
        		hwagu.set(minIndex, startTime+cookTime);
        	}
        	else {
        		hwagu.set(minIndex, min+cookTime);
        	}
        	
        	if(i == orders.length-1) {
    			answerIndex = minIndex;
    		}
        }
        
        return hwagu.get(answerIndex);
    }

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		
		String[] a = {"A 3","B 2"};
		String[] a1 = {"A 1","A 2","B 3","B 4"};
		String[] b = {"SPAGHETTI 3", "FRIEDRICE 2", "PIZZA 8"};
		String[] b1 = {"PIZZA 1", "FRIEDRICE 2", "SPAGHETTI 4", "SPAGHETTI 6", "PIZZA 7", "SPAGHETTI 8"};
		String[] c = {"COOKIE 10000"};
		String[] c1 = {"COOKIE 300000"};
		
		System.out.println("the answer is : " +s.solution(2, a, a1));
		System.out.println("the answer is : " +s.solution(3, b, b1));
		System.out.println("the answer is : " +s.solution(1, c, c1));

	}

}
