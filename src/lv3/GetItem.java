package lv3;

import java.util.Arrays;

public class GetItem {
	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        return answer;
    }
	
	public int[][] getAllPoint(int[] point) {
		int[][] allPoint = new int[4][2];
		allPoint[0][0] = point[0];
		allPoint[0][1] = point[1];
		allPoint[1][0] = point[0];
		allPoint[1][1] = point[3];
		allPoint[2][0] = point[2];
		allPoint[2][1] = point[1];
		allPoint[3][0] = point[2];
		allPoint[3][1] = point[3];
		for(int[] i : allPoint)
			System.out.println(Arrays.toString(i));
		return allPoint;
	}
	
	public boolean isMeetSquare(int[][] allPoint01, int[][] allPoint02) {
		
		return false;
	}
	
	public boolean isMeetLine(int[] a01, int[] a02, int[] b01, int[] b02) {
		
		return false;
	}
}
