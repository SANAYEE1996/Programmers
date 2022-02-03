package KAKAO_2022_Blind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class LV2_Bow {
	public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i : info) list.add(i);
        System.out.println(list);
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


/*
 * 2 1 1 1 0 0 0 0 0 0 0 0
3발로 점수를 얻을 수 있음 : 10점 -> 이렇게 되면 남은 발 : 2발
2발로 점수를 얻을 수 있음 : 9 , 8, 7점 -> 이렇게 되면 각각 3발 남음
1발로 점수를 얻을 수 있음 : 6 ,5, 4, 3, 2, 1 점 -> 이렇게 되면 각각 각각 4발 남음
34 0
34 6
17 23
24 21


0 0 1 2 0 1 1 1 1 1 1
1발로 점수를 얻을 수 있음 : 10, 9, 6점			
2발로 점수를 얻을 수 있음 : 8, 5, 4, 3, 2, 1, 0 점
3발로 점수를 얻을 수 있음 : 7점

지금 저 놈 점수 : 36점
쏴야 할 발 : 9발

1 1 1 2 2 2 -> 10+ 9 + 6 + (8 + 5 + 4) /// 36 -  (8 + 5 + 4) 	-> 44 // 19
1 2 2 2 2    -> 10 + (8 + 5 + 4 + 3) 	 /// 36 - (8 + 5 + 4 + 3)	-> 30 // 16
1 1 2 2 3    -> 10 + 9 + (8 + 5 + 7)	/// 36 - (8 + 5 + 7)		-> 39 // 16
2 2 2 3	   -> (8+5+4 + 7)		/// 36 - (8+5+4 + 7)	-> 24 // 12
 * 
 * */
