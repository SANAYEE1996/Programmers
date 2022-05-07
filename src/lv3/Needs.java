package lv3;

import java.util.ArrayList;
import java.util.HashMap;

public class Needs {
	
	public int solution(int[][] needs, int r) {
		if(r == needs[0].length) {
			return needs.length;
		}
		
        int answer = 0;
        
        HashMap<ArrayList<Integer>, ArrayList<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < needs.length; i++) {
        	ArrayList<Integer> list = new ArrayList<>();
        	for(int j = 0; j < needs[i].length; j++) {
        		if(needs[i][j] == 1) {
        			list.add(j);
        		}
        	}
        	count.put(i, list.size());
        	if(!map.containsKey(list)) {
        		map.put(list, new ArrayList<Integer>());
        	}
        	map.get(list).add(i);
        }
        
        
        int max = 0;
        ArrayList<Integer> per = new ArrayList<>();
        for(ArrayList<Integer> key : map.keySet()) {
        	if(max < map.get(key).size() && key.size() == r) {
        		per = key;
        		max = map.get(key).size();
        	}
        }
        System.out.println("오케이! : "+per);
        
        for(int i = 0; i < needs.length; i++) {
        	if(count.get(i) == 1) {
        		for(int j = 0; j < needs[i].length; j++) {
            		if(needs[i][j] == 1 && per.contains(j)) {
            			answer++;
            			System.out.println("?");
            			break;
            		}
            	}
        	}
        	else if(count.get(i) == r && isRight(needs[i], per , r)) {
        		answer++;
        	}
        }
        
        
        return answer;
    }
	
	public static boolean isRight(int[] needs, ArrayList<Integer> per, int r) {
		int count = 0;
		for(int i = 0; i < needs.length; i++) {
			if(needs[i] == 1 && per.contains(i)) {
				count++;
			}
		}
		if(count == r) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		int[][] needs = { 	{1, 0, 0}, 
				{1, 1, 0}, 
				{1, 1, 0}, 
				{1, 0, 1}, 
				{1, 1, 0}, 
				{0, 1, 1} };
		int r = 2;
		
		Needs s = new Needs();
		System.out.println("the answer is : " +s.solution(needs, r));

	}

}
