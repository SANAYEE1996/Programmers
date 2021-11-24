package ysp_211022;

import java.util.Arrays;

public class Solution3 {
	public int solution(int M, int[] load) {
        int answer = 0;
        Arrays.sort(load);
        int gim = 0;
        for(int i = load.length-1; i >= 0; i--) {
        	gim = 0;
        	for(int j = 0; j < i; j++) {
	        	if(load[i] != 0 && load[j] + load[i] <= M) {
	        		gim = load[i] + load[j];
	        		load[i] = 0;
	        		load[j] = 0;
	        		gogo(load,M,j+1,i,gim);
	        		answer++;
	        	}
	        	else if(load[i] != 0 && j == i-1) {
	        		load[i] = 0;
	        		answer++;
	        	}
        	}
        	if(i == 0 && load[i] != 0) {
        		load[i] = 0;
        		answer++;
        	}
        }
        return answer;
    }
	
	public static void gogo(int[] load, int M, int flag, int max,int gim) {
		if(load[flag] != 0 && gim + load[flag] <= M) {
    		gim += load[flag];
    		load[flag] = 0;
    		gogo(load,M,flag+1,max,gim);
		}
	}
	
	public static void main(String[] args) {
		Solution3 s = new Solution3();
		int[] a = {2,3,7,8};
		int[] b = {2,2,2,2,2};
		int[] c = {16,15,9,17,1,3};
		int[] d = {30,30,30,30,15};
		System.out.println(s.solution(10, a));
		System.out.println(s.solution(5, b));
		System.out.println(s.solution(20, c));
		System.out.println(s.solution(30, d));
	}
}
