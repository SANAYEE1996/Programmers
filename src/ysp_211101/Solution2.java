package ysp_211101;

import java.util.Arrays;

public class Solution2 {
	public int[] solution(int m, int n, int[][] picture) {
		int[][] copy = arrayCopy(picture);
		int start = 0;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		for(int i = 0; i < copy.length; i++) {
			for(int j = 0; j < copy[i].length; j++) {
				start = copy[i][j];
				if(start != 0) {
					copy[i][j] = 0;
					if( i + 1 > copy.length && copy[i+1][j] == start) {
						count1 = 1;
						count1 = gogo(copy, i+1, j, count1, start);
					}
					if( j + 1 > copy[i].length && copy[i][j+1] == start) {
						count2 = 1;
						count2 = gogo(copy, i, j+1, count2, start);
					}
					if( i - 1 > 0 && copy[i-1][j] == start) {
						count3 = 1;
						count3 = gogo(copy, i-1, j, count3, start);
					}
					if( j - 1 > 0 && copy[i][j-1] == start) {
						count4 = 1;
						count4 = gogo(copy, i, j-1, count4, start);
					}
					
					break;
				}
			}
			System.out.println(Arrays.toString(copy[i]));
		}
		
		
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
	
	public static int gogo(int[][] copy, int x, int y, int count, int value) {
		int start = 0;
		int count1 = count;
		int count2 = count;
		int count3 = count;
		int count4 = count;
		for(int i = x; i < copy.length; i++) {
			for(int j = y; j < copy[i].length; j++) {
				start = copy[i][j];
				if(start == value) {
					copy[i][j] = 0;
					if( i + 1 > copy.length && copy[i+1][j] == start) {
						count1++;
						count1 = gogo(copy,i+1,j,count1,start);
					}
					if( j + 1 > copy[i].length && copy[i][j+1] == start) {
						count2++;
						count2 = gogo(copy,i,j+1,count2,start);
					}
					if( i - 1 > 0 && copy[i-1][j] == start) {
						count3++;
						count3 = gogo(copy, i-1, j, count3, start);
					}
					if( j - 1 > 0 && copy[i][j-1] == start) {
						count4++;
						count4 = gogo(copy, i, j-1, count4, start);
					}
					
					break;
				}
			}
		}
		System.out.println(value + " " +count1);
		System.out.println(value + " " +count2);
		System.out.println(value + " " +count3);
		System.out.println(value + " " +count4);
		return count1 + count2 + count3 + count4;
	}
	
	public static int[][] arrayCopy(int[][] picture){
		int[][] copy = new int[picture.length][picture[0].length];
		for(int i = 0; i < picture.length; i++) {
			System.arraycopy(picture[i], 0, copy[i], 0, picture[i].length);
		}
		return copy;
		
	}

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int[][] a = {{1, 1, 1, 0}, 
				{1, 2, 2, 0}, 
				{1, 0, 0, 1}, 
				{0, 0, 0, 1}, 
				{0, 0, 0, 3}, 
				{0, 0, 0, 3}};
		
		System.out.println(Arrays.toString(s.solution(3, 3, a)));
		

	}

}
