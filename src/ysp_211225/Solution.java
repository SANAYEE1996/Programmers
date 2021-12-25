package ysp_211225;

import java.util.Arrays;

public class Solution {
	public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] map = new int[n][n];
        for(int[] a : results) {
        	map[a[0]-1][a[1]-1] = 1;
        	map[a[1]-1][a[0]-1] = -1;
        }
        for(int j = 0; j < n; j++) {
        	for(int[] a : map) {
            	for(int i = 0; i < a.length; i++) {
            		if(a[i] == 1) {
            			gogo(a, map[i], 1);
            		}
            		else if(a[i] == -1) {
            			gogo(a, map[i], -1);
            		}
            	}
            }
        }
        int cnt = 0;
        for(int[] a : map) {
        	cnt = 0;
        	for(int i : a) {
        		if(i == 0) cnt++;
        	}
        	if(cnt == 1) answer++;
        	System.out.println(Arrays.toString(a));
        }
        return answer;
    }
	
	public static void gogo(int[] a, int[] target, int isWin) {
		if(isWin == 1) {
			for(int i = 0; i < target.length; i++) {
				if(target[i] == 1) a[i] = 1;
			}
		}
		else {
			for(int i = 0; i < target.length; i++) {
				if(target[i] == -1) a[i] = -1;
			}
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		
		int n = 5;
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		
		System.out.println("the answer is : " +s.solution(n, results));
		

	}

}
