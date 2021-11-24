package ysp_211025;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	public int solution(int k, int[][] dungeons) {
        int answer = 0;
        
        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<Integer> raid = new ArrayList<>();
        for(int i = 0; i < dungeons.length; i++) {
        	if(dungeons[i][0] <= k) {
        		list.add(dungeons[i]);
        	}
        }
        raid.add(0);
        int size = list.size();
        int count = 0;
        int piro;
        for(int i = 0; i < size; i++) {
        	if(Collections.max(raid) == size) {
        		answer = size;
        		break;
        	}
        	piro = k;
        	ArrayList<int[]> copy = new ArrayList<>();
        	copy.addAll(list);
        	count = 0;
        	if(list.get(i)[0] <= k) {
        		count++;
        		piro -= list.get(i)[1];
        		copy.remove(i);
        		gogo(piro,raid,copy,count);
        	}
        }
        answer = Collections.max(raid);
        return answer;
    }
	
	public static void gogo(int piro, ArrayList<Integer> raid, ArrayList<int[]> copy, int count) {
		int cnt = count;
		int pirodo = piro;
		if(copy.size() > 0) {
			for(int i = 0; i < copy.size(); i++) {
				ArrayList<int[]> copycopy = new ArrayList<>();
				copycopy.addAll(copy);
				cnt = count;
				pirodo = piro;
				if(copycopy.get(i)[0] <= pirodo) {
					cnt++;
					pirodo -= copycopy.get(i)[1];
					copycopy.remove(i);
					raid.add(cnt);
					gogo(pirodo, raid,copycopy,cnt);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] a = {{80,20},{50,40},{30,10}};
		int[][] b = {{80,20},{50,40},{30,10},{40,20}};
		Solution s = new Solution();
		System.out.println(s.solution(80, a));
		System.out.println(s.solution(80, b));
	}

}
