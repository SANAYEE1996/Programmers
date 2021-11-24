package ysp_211014;

import java.util.ArrayList;
import java.util.Collections;

public class Solution6 {
	
	public int solution(int leave, String day, int[] holidays) {
        int answer = -1;
        String[] week = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : holidays) {
        	list.add(i);
        }
        int sat = 0;
        int sun = 0;
        for(int i = 0; i < week.length; i++) {
        	if(day.equals(week[i])) {
        		if(i != 0) {
        			sat = 7-i;
        			sun = 7-i+1;
        			for(int j = sat; j <= 30; j += 7) {
        				list.add(j);
        				if(j != 30) {
        					list.add(sun);
        				}
        				sun += 7;
        			}
        		}
        		else {
        			sun = 1;
        			sat = 7-i;
        			for(int j = sun; j <= 30; j += 7) {
        				list.add(j);
        				if(sat <= 30) {
        					list.add(sat);
        				}
        				sat += 7;
        			}
        		}
        		break;
        	}
        }
        ArrayList<Integer> vaca = new ArrayList<>();
        for(int i : list) {
        	if(!vaca.contains(i)) {
        		vaca.add(i);
        	}
        }
        Collections.sort(vaca);
        System.out.println(vaca);
        while(true) {
        	
        	if(vaca.size() == 30) {
        		answer = 30;
        		break;
        	}
        	else if(leave == 0) {
        		break;
        	}
        	leave--;
        }
        return answer;
    }

	public static void main(String[] args) {
		Solution6 s = new Solution6();
		int[] a = {6, 21, 23, 27, 28};
		int[] b = {2, 6, 17, 29};
		int[] c = {1, 2, 3, 4, 28, 29, 30};
		System.out.println(s.solution(4, "FRI", a));
		System.out.println(s.solution(4, "SUN", b));
		System.out.println(s.solution(4, "MON", c));

	}

}

/*
 * [2, 3, 6, 9, 10, 16, 17, 21, 23, 24, 27, 28, 30]
 *    2   1    2       2     1    2        2     1    
 * 1     2  2      5      3    1      2       1     
 * 
 * 21221221
 * 12243121
 * */
