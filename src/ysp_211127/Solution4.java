package ysp_211127;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class Solution4 {
	public String[] solution(int[][] line) {
        HashMap<Long, ArrayList<Long>> map = new HashMap<>();
        ArrayList<Long> list = new ArrayList<>();
		long x1 = 0, x2 = 0, y1 = 0, y2 = 0, z1 = 0, z2 = 0;
		long comd = 1;
		double xResult = 0;
		double yResult = 0;
		long x = 0;
		long y = 0;
		BigDecimal bigX;
		BigDecimal bigY;
        for(int i = 0; i < line.length-1; i++) {
        	x1 = line[i][0];
        	y1 = line[i][1];
        	z1 = line[i][2];
        	for(int j = i+1; j < line.length; j++) {
        		x2 = line[j][0];
        		y2 = line[j][1];
        		z2 = line[j][2];
        		comd = (x1*y2 -y1*x2);
        		if(comd != 0) {
        			xResult = (y1*z2-z1*y2)/(double)comd;
        			yResult = (z1*x2-x1*z2)/(double)comd;
        			bigX = new BigDecimal(xResult);
        			bigY = new BigDecimal(yResult);
        			if(!bigX.toString().contains(".") && !bigY.toString().contains(".")) {
        				x = (long)xResult;
        				y = (long)yResult;
        				if(!map.containsKey(y)) {
        					map.put(y, new ArrayList<Long>());
        				}
        				if(!map.get(y).contains(x)) {
        					map.get(y).add(x);
        					list.add(x);
        				}
        			}
        		}
        	}
        }
        long max = Collections.max(list);
        long min = Collections.min(list);
        
        for (long i : map.keySet()) {
			Collections.sort(map.get(i));
		}
        ArrayList<Long> keyList = new ArrayList<>(map.keySet());
        ArrayList<String> str = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i <= max-min; i++) {
			sb.append(".");
		}
        String gonbak = sb.toString();
        keyList.sort(Collections.reverseOrder());
        long beforeHeight = keyList.get(0);
        long height = 0;
        long examMax = max;
        long examMin = min;
        long differ = 0;
        ArrayList<Long> exam;
        for (long key : keyList) {
        	exam = map.get(key);
        	examMax = max;
        	examMin = min;
			sb.setLength(0);
			height = (long)(beforeHeight - key)-1;
			for (long i = 0; i < height; i++) {
				str.add(gonbak);
			}
			for (long i = 0; i < exam.get(0)-examMin; i++) {
				sb.append(".");
			}
			for (int i = 0; i < exam.size(); i++) {
				sb.append("*");
				if(i < exam.size()-1) {
					differ = exam.get(i+1) - exam.get(i)-1;
					for (long j = 0; j < differ; j++) {
						sb.append(".");
					}
				}
			}
			for (long i = 0; i < examMax - exam.get(exam.size()-1); i++) {
				sb.append(".");
			}
			str.add(sb.toString());
			beforeHeight = key;
		}
        String[] answer = new String[str.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = str.get(i);
		}
        return answer;
    }

	public static void main(String[] args) {
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
		
		Solution4 s = new Solution4();
		
		System.out.println("the answer is : "+Arrays.toString(s.solution(a)));
		System.out.println();
		System.out.println("the answer is : "+Arrays.toString(s.solution(b)));
		System.out.println();
		System.out.println("the answer is : "+Arrays.toString(s.solution(c)));
		System.out.println();
		System.out.println("the answer is : "+Arrays.toString(s.solution(d)));
		System.out.println();
		System.out.println("the answer is : "+Arrays.toString(s.solution(e)));
		
	}

}
