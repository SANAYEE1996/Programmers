package ysp_211121;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {
	public int[] solution(String[] names, int[][] homes, double[] grades) {
        int[] answer = new int[names.length];
        String[][] map = new String[names.length][3];
        for(int i = 0; i < names.length; i++) {
        	map[i][0] = String.valueOf(grades[i]).substring(0,1);
        	map[i][1] = String.valueOf((int)Math.pow(homes[i][0], 2) + (int)Math.pow(homes[i][1], 2));
        	map[i][2] = names[i];
        }
        
        Arrays.sort(map, new Comparator<String[]>() {
        	@Override
        	public int compare(String[] o1, String[] o2) {
        		int score1 = Integer.parseInt(o1[0]);
        		int score2 = Integer.parseInt(o2[0]);
        		int dis1 = Integer.parseInt(o1[1]);
        		int dis2 = Integer.parseInt(o2[1]);
        		String name1 = o1[2];
        		String name2 = o2[2];
        		if(score1 == score2) {
        			if(dis1 == dis2) {
        				return name1.compareTo(name2);
        			}
        			else {
        				return dis2 - dis1;
        			}
        		}
        		else {
        			return score2 - score1;
        		}
        		
        	}
        });
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        
        for(int i = 0; i < map.length; i++) {
        	hm.put(map[i][2], i+1);
        }
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = hm.get(names[i]);
        }
        
        return answer;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] names = {"azad","andy","louis","will","edward"};
		int[][] homes = {{3,4},{-1,5},{-4,4},{3,4},{-5,0}};
		double[] grades = {4.19, 3.77, 4.41, 3.65, 3.58};
		String[] names1 = {"clanguage","csharp","java","python"};
		int[][] homes1 = {{3,-3},{-2,7},{-1,-1},{5,4}};
		double[] grades1 = {1.27, 4.31, 4.26, 3.99};
		String[] names2 = {"zzzzzzzzzz"};
		int[][] homes2 = {{9999,-9999}};
		double[] grades2 = {1.0};
		
		System.out.println(Arrays.toString(s.solution(names, homes, grades)));
		System.out.println();
		System.out.println(Arrays.toString(s.solution(names1, homes1, grades1)));
		System.out.println();
		System.out.println(Arrays.toString(s.solution(names2, homes2, grades2)));
	}

}
