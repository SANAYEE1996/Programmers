package ysp_211102;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution4 {
	public String[] solution(int[][] line) {
        String[] answer = {};
        ArrayList<ArrayList<Integer>> set = new ArrayList<>();
        PriorityQueue<Integer> xqueMax = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> yqueMax = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> xqueMin = new PriorityQueue<>();
        PriorityQueue<Integer> yqueMin = new PriorityQueue<>();
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
        				ArrayList<Integer> list = new ArrayList<>();
        				list.add((int) xResult);
        				xqueMax.add((int) xResult);
        				xqueMin.add((int) xResult);
        				list.add((int) yResult);
        				yqueMax.add((int) yResult);
        				yqueMin.add((int) yResult);
        				if(!set.contains(list)) {
        					set.add(list);
        				}
        			}
        		}
        	}
        }
        int sero = yqueMax.peek() - yqueMin.peek()+1;
        int garo = xqueMax.peek() - xqueMin.peek()+1;
        String[][] map = new String[sero][garo];
        for(int i = 0; i < map.length; i++) {
        	System.out.println(Arrays.toString(map[i]));
        }
        return answer;
    }
	
	
	public static void main(String[] args) {
		Solution4 s = new Solution4();
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
