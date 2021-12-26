package ysp_211227;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
	public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] a, int[] b) {
        		if(a[0] == b[0]) 
        			return a[1] - b[1];
        		else 
        			return a[0] - b[0];
        	}
        });
        
        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        for(int[] i : jobs) {
        	ArrayList<Integer> a = new ArrayList<>();
        	a.add(i[0]);
        	a.add(i[1]);
        	all.add(a);
        };
        
        ArrayList<int[]> map = new ArrayList<>();
        for(int[] i : jobs) map.add(i);
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        int endTime = 0;
        int wasteTime = 0;
        int nowStart = jobs[0][0];
        int nowWaste = jobs[0][1];
        int index = 0;
        for (int i = 0; i < jobs.length; i++) {
        	ArrayList<Integer> exam = new ArrayList<>();
        	exam.add(nowStart);
        	exam.add(nowWaste);
        	if(endTime <= nowStart) {
        		wasteTime = nowWaste;
        		answer += wasteTime;
        		endTime = nowStart + nowWaste;
        	}
        	else {
        		wasteTime = (endTime - nowStart) + nowWaste;
        		answer += wasteTime;
        		endTime += nowWaste;
        	}
        	
        	index = all.indexOf(exam);
        	if(all.size() > 0 && index >= 0) all.remove(index);
			list.clear();
			for(int j = 0; j < all.size(); j++) {
				if(all.get(j).get(0) <= endTime) {
					list.add(all.get(j));
				}
				else {
					break;
				}
			}
			Collections.sort(list, new Comparator<ArrayList<Integer>>() {
				@Override
				public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
					if(a.get(1) == b.get(1)) {
						return a.get(0) - b.get(0);
					}
					else {
						return a.get(1) - b.get(1);
					}
				}
			});
			if(list.size() > 0) {
				nowStart = list.get(0).get(0);
				nowWaste = list.get(0).get(1);
			}
			else {
				if(all.size() > 0) {
					nowStart = all.get(0).get(0);
					nowWaste = all.get(0).get(1);
				}
			}
			
		}
        return answer/jobs.length;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		
		int[][] jobs ={	{24, 10}, 
						{28, 39}, 
						{43, 20}, 
						{37, 5}, 
						{47, 22}, 
						{20, 47}, 
						{15, 34}, 
						{15, 2}, 
						{35, 43}, 
						{26, 1}};
		
		int[][] jobs2 ={{0,5},{2,10},{10000,2}};
		
		System.out.println("the answer is : " +s.solution(jobs) +"\n");
		System.out.println("the answer is : " +s.solution(jobs2)+"\n");
	}

}
