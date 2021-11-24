package ysp_211121;

import java.util.Arrays;

public class Solution3 {
	public int[] solution(int rows, int columns, int[][] connections, int[][] queries) {
        int[] answer = {};
        return answer;
    }

	public static void main(String[] args) {
		int[][] a = {{1,1,2,1},{1,2,1,3},{1,3,2,3},{2,2,2,3},{2,2,3,2},{2,3,3,3},{3,2,3,3},{3,2,4,2},{4,1,4,2}};
		int[][] b = {{1,1,1,2},{2,2,1,2},{2,1,1,1},{2,2,2,1}};
		int[][] c = {{1,1,2,1},{2,1,3,1},{1,2,2,2},{2,2,3,2},{1,3,2,3},{2,3,3,3}};
		int[][] a1 = {{2,2,3,1},{1,2,4,2}};
		int[][] b1 = {{1,1,2,2},{1,1,2,1},{2,1,2,2}};
		int[][] c1 = {{1,1,3,1},{1,2,3,2},{1,3,3,3}};
		
		
		Solution3 s = new Solution3();
		System.out.println(Arrays.toString(s.solution(4, 3, a, a1)));
		System.out.println(Arrays.toString(s.solution(2, 2, b, b1)));
		System.out.println(Arrays.toString(s.solution(3, 3, c, c1)));
	}

}
