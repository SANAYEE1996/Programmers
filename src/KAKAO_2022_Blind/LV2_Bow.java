package KAKAO_2022_Blind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class LV2_Bow {
	public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i : info) list.add(i);
        HashMap<Integer, int[]> map = new HashMap<>();
        return answer;
    }
	
	public static void gogo(HashMap<Integer, int[]> map, LinkedList<Integer> list, int n) {
		
		
		
	}

	public static void main(String[] args) {
		
		LV2_Bow s = new LV2_Bow();
		
		int n = 5;
		int[] info = {2,1,1,1,0,0,0,0,0,0,0};
		
		int n2 = 1;
		int[] info2 = {1,0,0,0,0,0,0,0,0,0,0};
		
		int n3 = 9;
		int[] info3 = {0,0,1,2,0,1,1,1,1,1,1};
		
		int n4 = 10;
		int[] info4 = {0,0,0,0,0,0,0,0,3,4,3};
		
		System.out.println("the answer is : " +Arrays.toString(s.solution(n, info)));
		System.out.println("the answer is : " +Arrays.toString(s.solution(n2, info2)));
		System.out.println("the answer is : " +Arrays.toString(s.solution(n3, info3)));
		System.out.println("the answer is : " +Arrays.toString(s.solution(n4, info4)));

	}

}
