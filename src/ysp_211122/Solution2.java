package ysp_211122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution2 {
	public String[] solution(int[][] line) {
        ArrayList<ArrayList<Long>> set = new ArrayList<>();
		long x1 = 0, x2 = 0, y1 = 0, y2 = 0, z1 = 0, z2 = 0;
		double comd = 1;
		double xResult = 0;
		double yResult = 0;
		double xMax = 0;
		double xMin = 0;
        for(int i = 0; i < line.length-1; i++) {
        	x1 = line[i][0];
        	y1 = line[i][1];
        	z1 = line[i][2];
        	for(int j = i+1; j < line.length; j++) {
        		x2 = line[j][0];
        		y2 = line[j][1];
        		z2 = line[j][2];
        		comd = ((long)x1*y2 -(long)y1*x2);
        		if(comd != 0) {
        			xResult = (long)(y1*z2-z1*y2)/comd;
        			yResult = (long)(z1*x2-x1*z2)/comd;
        			if(xResult - (int) xResult == 0.0 && yResult - (int) yResult == 0.0) {
        				ArrayList<Long> list = new ArrayList<>();
        				list.add((long) xResult);
        				list.add( (long) yResult);
        				if(xMax < xResult) {
        					xMax = xResult;
        				}
        				if(xMin > xResult) {
        					xMin = xResult;
        				}
        				if(!set.contains(list)) {
        					set.add(list);
        				}
        			}
        		}
        	}
        }
        Collections.sort(set, new Comparator<ArrayList<Long>>() {
            public int compare(ArrayList<Long> s1,ArrayList<Long> s2) {
                if (s1.get(1) < s2.get(1)) {
                    return 1;
                }
                else if(s1.get(1) == s2.get(1)) {
                	return (int)(s1.get(0) - s2.get(0));
                }
                else {
                	return -1;
                }
            }
        });
        int left = (int) xMin;
        int right = (int) xMax;
        
        int width = right - left + 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < width; i++) {
        	sb.append(".");
        }
        String gonbak = sb.toString();
        sb.setLength(0);
        System.out.println(width);
        System.out.println(set);
        
        
        ArrayList<String> list = new ArrayList<>();
        int differ = 0;
        for(int i = 0; i < set.size()-1; i++) {
        	if(set.get(i).get(1) == set.get(i+1).get(1)) {
        		
        	}
        	else {
    			differ =Math.toIntExact(set.get(i).get(1))
    					- Math.toIntExact(set.get(i+1).get(1))-1;
    			for(int j = 0; j < differ; j++) {
    				list.add(gonbak);
    			}
        		
        	}
        }
        System.out.println(list);
        String[] answer = new String[1];
        return answer;
    }

	public static void main(String[] args) {
		Solution2 s = new Solution2();
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
		int[][] e = {	{100000, 100000, 	0},
				 		{0, 	100000, 	100000}};
		
		System.out.println(Arrays.toString(s.solution(a)));
		System.out.println(Arrays.toString(s.solution(b)));
		System.out.println(Arrays.toString(s.solution(c)));
		System.out.println(Arrays.toString(s.solution(d)));
		System.out.println(Arrays.toString(s.solution(e)));
		
		

	}

}
