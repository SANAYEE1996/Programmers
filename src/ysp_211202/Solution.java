package ysp_211202;

import java.util.HashSet;

public class Solution {
	
	
	public int solution(int n, int[][] computers) {
        for (int i = 0; i < computers.length; i++) {
			computers[i][i] = i+1;
		}
        boolean[] visited = new boolean[n];
        int[] exam = new int[n];
        int[] target = new int[n];
        int orgin = 0;
        for (int i = 0; i < computers.length; i++) {
        	orgin = computers[i][i];
        	exam = computers[i];
        	for (int j = 0; j < exam.length; j++) {
				if(exam[j] != 0) {
					target = computers[j];
					if(visited[j] == false) {
						visited[j] = true;
						gogo(computers, target, orgin,visited);
					}
				}
			}
		}
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < computers.length; i++) {
        	set.add(computers[i][i]);
		}
        
        return set.size();
    }
	
	public static void gogo(int[][] computers, int[] target, int orgin,boolean[] visited) {
		int[] purpose = new int[computers.length];
		for (int i = 0; i < target.length; i++) {
			if(target[i] != 0) {
				target[i] = orgin;
				purpose = computers[i];
				if(visited[i] == false) {
					visited[i] = true;
					gogo(computers, purpose, orgin,visited);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
		int[][] computers1 = {{1,1,0},{1,1,1},{0,1,1}};
		int[][] computers2 = {	{1,1,0,1},
								{1,1,0,0},
								{0,0,1,1},
								{1,0,1,1}};
		int[][] computers3 = {	{1,1,0,0,1,0,0},
								{1,1,0,0,0,0,0},
								{0,0,1,1,1,0,0},
								{0,0,1,1,1,0,0},
								{1,0,1,1,1,0,0},
								{0,0,0,0,0,1,1},
								{0,0,0,0,0,1,1}};
		int[][] computers4 = {	{1,0,0,0,0,0,0},
								{0,1,0,0,1,0,0},
								{0,0,1,1,1,0,0},
								{0,0,1,1,1,0,0},
								{0,1,1,1,1,0,0},
								{0,0,0,0,0,1,1},
								{0,0,0,0,0,1,1}};
		int[][] computers5 = {	{1,0,0,0},
								{0,1,0,0},
								{0,0,1,0},
								{0,0,0,1}};
		
		int[][] computers6 = {	{1, 0, 1, 1, 0, 0}, 
								{0, 1, 0, 0, 1, 1}, 
								{1, 0, 1, 1, 1, 1}, 
								{1, 0, 1, 1, 1, 1}, 
								{0, 1, 1, 1, 1, 1}, 
								{0, 1, 1, 1, 1, 1}};
		
		int n = 3;
		int n1 = 3;
		int n2 = 4;
		int n3 = 7;
		int n4 = 7;
		int n5 = 4;
		
		Solution s = new Solution();
		
		System.out.println("the answer is : " +s.solution(n, computers) +"\n");
		System.out.println("the answer is : " +s.solution(n1, computers1)+"\n");
		System.out.println("the answer is : " +s.solution(n2, computers2)+"\n");
		System.out.println("the answer is : " +s.solution(n3, computers3)+"\n");
		System.out.println("the answer is : " +s.solution(n4, computers4)+"\n");
		System.out.println("the answer is : " +s.solution(n5, computers5)+"\n");
		System.out.println("the answer is : " +s.solution(6, computers6)+"\n");
		

	}

}
