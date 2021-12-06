package ysp_211206;

import java.util.ArrayList;

public class Solution {
	
	
	public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());
        for(int i = 0; i < n; i++) {
        	list.add(new ArrayList<Integer>());
        }
        for(int[] i : edge) {
        	list.get(i[0]).add(i[1]);
        	list.get(i[1]).add(i[0]);
        }
        int[] flag = new int[n+1];
        int length = 1;
        flag[1] = 1;
        ArrayList<Integer> first = new ArrayList<>(list.get(1));
        int target = 0;
        for (int i = 0; i < first.size(); i++) {
        	target = first.get(i);
        	if(flag[target] == 0) {
				flag[target] = length;
				gogo(list, target, length+1, flag);
			}
			else if(flag[target] > length){
				flag[target] =  length;
				gogo(list, target, length+1, flag);
			}
		}
        int max = 0;
        for(int i : flag) {
        	if(i > max) max = i;
        }
        for(int i : flag) {
        	if(i == max) answer++;
        }
        
        return answer;
    }
	
	public static void gogo(ArrayList<ArrayList<Integer>> list, int key, int length,int[] flag) {
		ArrayList<Integer> first = new ArrayList<>(list.get(key));
		int target = 0;
		for (int i = 0; i < first.size(); i++) {
			target = first.get(i);
        	if(flag[target] == 0) {
				flag[target] = length;
				gogo(list, target, length+1, flag);
			}
        	else if(flag[target] > length){
				flag[target] =  length;
				gogo(list, target, length+1, flag);
			}
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 6;
		int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		
		
		System.out.println("the answer is : " +s.solution(n, edge));
	}

}
