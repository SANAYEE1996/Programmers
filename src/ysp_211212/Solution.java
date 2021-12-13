package ysp_211212;

import java.util.ArrayList;

public class Solution {
	
	public int solution(int[][] board) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        a.add(0);
        a.add(0);
        b.add(0);
        b.add(1);
        c.add(1);
        c.add(0);
        list.add(a);
        list.add(c);
        list2.add(a);
        list2.add(b);
        ArrayList<Integer> all = new ArrayList<>();
        if(board[1][0] == 0) gogo(board, 1, 0, "down", 100, list, all);
        if(board[0][1] == 0) gogo(board, 0, 1, "right", 100, list2, all);
        System.out.println(all.size());
        return 0;
    }
	
	public static void gogo(int[][] board, int i, int j, String vector, int cost,
							ArrayList<ArrayList<Integer>> list, ArrayList<Integer> all) {
		//System.out.println("x 좌표 : "+i +" y 좌표 : " +j+" 값 : "+ cost +" 방향 : " +vector);
		if(i == board.length -1 && j == board.length - 1) {
			/*
			System.out.println("값인가 ? : "+cost);
			System.out.println("걸어왔던 길 ↓");
			for (int k = 0; k < list.size(); k++) {
				System.out.println(list.get(k));
			}
			*/
			all.add(cost);
		}
		else {
			if(vector.equals("down")) {
            	if(i < board.length-1 && board[i+1][j] == 0) {
            		ArrayList<ArrayList<Integer>> copy = new ArrayList<>(list);
            		ArrayList<Integer> exam = new ArrayList<>();
            		exam.add(i+1);
            		exam.add(j);
            		if(!copy.contains(exam)) {
            			copy.add(exam);
            			gogo(board, i+1, j, "down", cost + 100, copy, all);
            		}
            	}
            	if(j > 0 && board[i][j-1] == 0) {
            		ArrayList<ArrayList<Integer>> copy = new ArrayList<>(list);
            		ArrayList<Integer> exam = new ArrayList<>();
            		exam.add(i);
            		exam.add(j-1);
            		if(!copy.contains(exam)) {
            			copy.add(exam);
            			gogo(board, i, j-1, "left", cost + 600, copy, all);
            		}
            	}
            	if(j < board.length-1 && board[i][j+1] == 0) {
            		ArrayList<ArrayList<Integer>> copy = new ArrayList<>(list);
            		ArrayList<Integer> exam = new ArrayList<>();
            		exam.add(i);
            		exam.add(j+1);
            		if(!copy.contains(exam)) {
            			copy.add(exam);
            			gogo(board, i, j+1, "right", cost + 600, copy, all);
            		}
            	}
            	
            }
            else if(vector.equals("up")) {
            	if(i > 0 && board[i-1][j] == 0) {
            		ArrayList<ArrayList<Integer>> copy = new ArrayList<>(list);
            		ArrayList<Integer> exam = new ArrayList<>();
            		exam.add(i-1);
            		exam.add(j);
            		if(!copy.contains(exam)) {
            			copy.add(exam);
            			gogo(board, i-1, j, "up", cost + 100, copy, all);
            		}
            	}
            	if(j > 0 && board[i][j-1] == 0) {
            		ArrayList<ArrayList<Integer>> copy = new ArrayList<>(list);
            		ArrayList<Integer> exam = new ArrayList<>();
            		exam.add(i);
            		exam.add(j-1);
            		if(!copy.contains(exam)) {
            			copy.add(exam);
            			gogo(board, i, j-1, "left", cost + 600, copy, all);
            		}
            	}
            	if(j < board.length-1 && board[i][j+1] == 0) {
            		ArrayList<ArrayList<Integer>> copy = new ArrayList<>(list);
            		ArrayList<Integer> exam = new ArrayList<>();
            		exam.add(i);
            		exam.add(j+1);
            		if(!copy.contains(exam)) {
            			copy.add(exam);
            			gogo(board, i, j+1, "right", cost + 600, copy, all);
            		}
            	}
            }
            else if(vector.equals("right")) {
            	if(j < board.length-1 && board[i][j+1] == 0) {
            		ArrayList<ArrayList<Integer>> copy = new ArrayList<>(list);
            		ArrayList<Integer> exam = new ArrayList<>();
            		exam.add(i);
            		exam.add(j+1);
            		if(!copy.contains(exam)) {
            			copy.add(exam);
            			gogo(board, i, j+1, "right", cost + 100, copy, all);
            		}
            	} 
            	
            	if(i < board.length-1 && board[i+1][j] == 0) {
            		ArrayList<ArrayList<Integer>> copy = new ArrayList<>(list);
            		ArrayList<Integer> exam = new ArrayList<>();
            		exam.add(i+1);
            		exam.add(j);
            		if(!copy.contains(exam)) {
            			copy.add(exam);
            			gogo(board, i+1, j, "down", cost + 600, copy, all);
            		}
            	}
            	
            	if(i > 0 && board[i-1][j] == 0) {
            		ArrayList<ArrayList<Integer>> copy = new ArrayList<>(list);
            		ArrayList<Integer> exam = new ArrayList<>();
            		exam.add(i-1);
            		exam.add(j);
            		if(!copy.contains(exam)) {
            			copy.add(exam);
            			gogo(board, i-1, j, "up", cost + 600, copy, all);
            		}
            	}
            	
			}
            else if(vector.equals("left")) {
            	
            	if(i > 0 && board[i-1][j] == 0) {
            		ArrayList<ArrayList<Integer>> copy = new ArrayList<>(list);
            		ArrayList<Integer> exam = new ArrayList<>();
            		exam.add(i-1);
            		exam.add(j);
            		if(!copy.contains(exam)) {
            			copy.add(exam);
            			gogo(board, i-1, j, "up", cost + 600, copy, all);
            		}
            	}
            	
            	if(i < board.length-1 && board[i+1][j] == 0) {
            		ArrayList<ArrayList<Integer>> copy = new ArrayList<>(list);
            		ArrayList<Integer> exam = new ArrayList<>();
            		exam.add(i+1);
            		exam.add(j);
            		if(!copy.contains(exam)) {
            			copy.add(exam);
            			gogo(board, i+1, j, "down", cost + 600, copy, all);
            		}
            	}
            	
            	if(j > 0 && board[i][j-1] == 0) {
            		ArrayList<ArrayList<Integer>> copy = new ArrayList<>(list);
            		ArrayList<Integer> exam = new ArrayList<>();
            		exam.add(i);
            		exam.add(j-1);
            		if(!copy.contains(exam)) {
            			copy.add(exam);
            			gogo(board, i, j-1, "left", cost + 100, copy, all);
            		}
            	}
            	
			}
			
		}
	}
	
	
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] A = {{0,0,0},
					 {0,0,0},
					 {0,0,0}};
		
		int[][] B = {{0,0,0,0,0,0,0,1},
					 {0,0,0,0,0,0,0,0},
					 {0,0,0,0,0,1,0,0},
					 {0,0,0,0,1,0,0,0},
					 {0,0,0,1,0,0,0,1},
					 {0,0,1,0,0,0,1,0},
					 {0,1,0,0,0,1,0,0},
					 {1,0,0,0,0,0,0,0}};
		
		int[][] C = {{0,0,1,0},
					 {0,0,0,0},
					 {0,1,0,1},
					 {1,0,0,0}};
		
		int[][] D = {{0,0,0,0,0,0},
					 {0,1,1,1,1,0},
					 {0,0,1,0,0,0},
					 {1,0,0,1,0,1},
					 {0,1,0,0,0,1},
					 {0,0,0,0,0,0}};
		
		//System.out.println("the answer is : " +s.solution(A));
		System.out.println("the answer is : " +s.solution(B));
		//System.out.println("the answer is : " +s.solution(C));
		//System.out.println("the answer is : " +s.solution(D));
		
	}
}
