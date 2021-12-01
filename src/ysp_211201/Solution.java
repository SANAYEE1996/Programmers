package ysp_211201;

import java.util.Arrays;

public class Solution {
	public int solution(int[][] triangle) {
        int[] before;
        int[] after;
        for (int i = 0; i < triangle.length-1; i++) {
        	before = triangle[i];
        	after = triangle[i+1];
        	int[] cloneArray = after.clone();
			for (int j = 0; j < before.length; j++) {
				after[j] = Math.max(after[j],cloneArray[j] + before[j]);
				after[j+1] = Math.max(after[j+1], cloneArray[j+1] + before[j]);
			}
		}
        Arrays.sort(triangle[triangle.length-1]);
        
        return triangle[triangle.length-1][triangle[triangle.length-1].length-1];
    }

	public static void main(String[] args) {
		
		int[][] triangle = {    {7},
							   {3,8},
							  {8,1,0},
							 {2,7,4,4},
							{4,5,2,6,5},};
		Solution s = new Solution();
		
		System.out.println("the answer is : " +s.solution(triangle));

	}

}
