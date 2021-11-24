package ysp_211022;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution5 {
	public int[] solution(int n) {
		int size = 0;
		ArrayList<Integer> list = new ArrayList<>();
		int[][] arr = new int[n][n];
		int[] index = new int[2];
		arr[0][0] = 1;
		if((n+1) % 3 == 0) {
			for(int i = 0; i < (n+1)/3; i++) {
				down(arr,arr[index[0]][index[1]],index[0],index[1],index);
				right(arr,arr[index[0]][index[1]],index[0],index[1],index);
				daegak(arr,arr[index[0]][index[1]],index[0],index[1],index);
			}
		}
		else if((n+1) % 3 == 1) {
			for(int i = 0; i < (n+1)/3; i++) {
				down(arr,arr[index[0]][index[1]],index[0],index[1],index);
				right(arr,arr[index[0]][index[1]],index[0],index[1],index);
				daegak(arr,arr[index[0]][index[1]],index[0],index[1],index);
			}
			down(arr,arr[index[0]][index[1]],index[0],index[1],index);
		}
		else {
			for(int i = 0; i < (n+1)/3; i++) {
				down(arr,arr[index[0]][index[1]],index[0],index[1],index);
				right(arr,arr[index[0]][index[1]],index[0],index[1],index);
				daegak(arr,arr[index[0]][index[1]],index[0],index[1],index);
			}
			down(arr,arr[index[0]][index[1]],index[0],index[1],index);
			right(arr,arr[index[0]][index[1]],index[0],index[1],index);
		}
		if(n % 2 == 0) {
			size = (n+1)*(n/2);
		}
		else {
			size = (n)*(n/2 + 1);
		}
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 0) {
					break;
				}
				else {
					list.add(arr[i][j]);
				}
			}
		}
		int[] answer = new int[size];
		for(int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
	
	public static void down(int[][] arr, int value, int flag, int j,int[] index) {
		for(int i = flag+1; i < arr.length; i++) {
			value++;
			if(arr[i][j] != 0) {
				break;
			}
			arr[i][j] = value;
			index[0] = i;
			index[1] = j;
		}
	}
	
	public static void right(int[][] arr, int value, int flag, int j,int[] index) {
		for(int i = j+1; i < arr[flag].length; i++) {
			value++;
			if(arr[flag][i] != 0) {
				break;
			}
			arr[flag][i] = value;
			index[0] = flag;
			index[1] = i;
		}
	}
	
	
	
	public static void daegak(int[][] arr, int value, int flag, int j,int[] index) {
		for(int i = flag-1; i >= 0; i--) {
			value++;
			j--;
			if(arr[i][j] != 0) {
				break;
			}
			arr[i][j] = value;
			index[0] = i;
			index[1] = j;
		}
	}

	public static void main(String[] args) {
		Solution5 s = new Solution5();
		System.out.println(Arrays.toString(s.solution(1)));
		System.out.println(Arrays.toString(s.solution(2)));
		System.out.println(Arrays.toString(s.solution(3)));
		System.out.println(Arrays.toString(s.solution(4)));
		System.out.println(Arrays.toString(s.solution(5)));
		System.out.println(Arrays.toString(s.solution(6)));
		System.out.println(Arrays.toString(s.solution(7)));

	}

}