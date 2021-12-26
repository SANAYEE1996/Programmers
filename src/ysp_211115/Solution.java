package ysp_211115;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
	public int[] solution(int m, int n, int[][] picture) {

        int[] answer = new int[2];
        int[] flag = new int[1];
        int value = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int[][] copy = new int[picture.length][picture[0].length];
        for(int i=0; i<copy.length; i++){
            copy[i] = picture[i].clone();
        }
        for(int i = 0; i < copy.length; i++) {
        	for(int j = 0; j < copy[i].length; j++) {
        		if(copy[i][j] != 0) {
        			flag[0] = 1;
        			value = copy[i][j];
        			copy[i][j] = 0;
        			gogo(copy, i, j, value, flag);
        			list.add(flag[0]);
        		}
        	}
        }
        answer[0] = list.size();
        answer[1] = Collections.max(list);
        return answer;
    }
	 
	public static void gogo(int[][] picture, int x, int y, int value, int[] flag) {
		if(x > 0 && picture[x-1][y] == value) {
			picture[x-1][y] = 0;
			flag[0]++;
			gogo(picture, x-1, y, value, flag);
		}
		if(y > 0 && picture[x][y-1] == value) {
			picture[x][y-1] = 0;
			flag[0]++;
			gogo(picture, x, y-1, value, flag);
		}
		if(x < picture.length-1 && picture[x+1][y] == value) {
			picture[x+1][y] = 0;
			flag[0]++;
			gogo(picture, x+1, y, value, flag);
		}
		if(y < picture[0].length-1 && picture[x][y+1] == value) {
			picture[x][y+1] = 0;
			flag[0]++;
			gogo(picture, x, y+1, value, flag);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] a = {	{1, 1, 1, 0}, 
						{1, 2, 2, 0}, 
						{1, 0, 0, 1}, 
						{0, 0, 0, 1}, 
						{0, 0, 0, 3}, 
						{0, 0, 0, 3}};
		
		System.out.println(Arrays.toString(s.solution(6, 4, a)));
	}

}
