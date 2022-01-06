package ysp_220106;

import java.util.Arrays;

public class Solution {
	public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][7];
        return answer;
    }

	public static void main(String[] args) {
		int[][] nodeinfo = {{5,3},
							{11,5},
							{13,3},
							{3,5},
							{6,1},
							{1,3},
							{8,6},
							{7,2},
							{2,2}};
		
		Solution s = new Solution();
		int[][] answer = s.solution(nodeinfo);
		for (int[] i : answer) {
			System.out.println(Arrays.toString(i));
		}

	}

}
