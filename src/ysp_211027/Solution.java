package ysp_211027;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public String[] solution(int[][] line) {
        String[] answer = {};
        ArrayList<ArrayList<Integer>> set = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		int x1 = 0, x2 = 0, y1 = 0, y2 = 0, z1 = 0, z2 = 0;
		int comd = 1;
		double xResult = 0;
		double yResult = 0;
        for(int i = 0; i < line.length-1; i++) {
        	x1 = line[i][0];
        	y1 = line[i][1];
        	z1 = line[i][2];
        	for(int j = i+1; j < line.length; j++) {
        		x2 = line[j][0];
        		y2 = line[j][1];
        		z2 = line[j][2];
        		comd = x1*y2 - y1*x2;
        		if(comd != 0) {
        			xResult = (double)(y1*z2-z1*y2)/comd;
        			yResult = (double)(z1*x2-x1*z2)/comd;
        			if(xResult - (int) xResult == 0.0 && yResult - (int) yResult == 0.0) {
        				list.add((int) xResult);
        				list.add((int) yResult);
        				System.out.println(list);
        				if(!set.contains(list)) {
        					set.add(list);
        				}
        			}
        		}
        		
        		list.clear();
        	}
        }
        System.out.println(set.size());
        for(int i = 0; i < set.size(); i++) {
        	System.out.println(set.get(i));
        }
        
        return answer;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] a = {	{2, -1, 4},
						{-2, -1, 4},
						{0, -1, 1},
						{5, -8, -12},
						{5, 8, 12}};
		int[][] b = {{0, 1, -1},
					 {1, 0, -1},
					 {1, 0, 1}};
		int[][] c = {{1, -1, 0},
					 {2, -1, 0}};
		int[][] d = {{1, -1, 0},
					 {2, -1, 0},
					 {4, -1, 0}};
		
		System.out.println(Arrays.toString(s.solution(a)));
		System.out.println(Arrays.toString(s.solution(b)));
		System.out.println(Arrays.toString(s.solution(c)));
		System.out.println(Arrays.toString(s.solution(d)));
		
	}

}
