package ysp_211028;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {
	public int solution(int N, int[][] road, int K) {
		ArrayList<int[]> list = new ArrayList<>();
		LinkedList<int[]> copy = new LinkedList<>();
		int[] city = new int[N];
		city[0] = 1;
        int answer = 0;
        int temp = 0;
        for(int i = 0; i < road.length; i++) {
        	if(road[i][0] > road[i][1]) {
        		temp = road[i][0];
        		road[i][0] = road[i][1];
        		road[i][1] = temp;
        	}
        }
        
        Arrays.sort(road, new Comparator<int[]>() {
		    @Override
			public int compare(int[] o1, int[] o2) {
		    	 if(o1[0] == o2[0]) {
	                 return o1[1] - o2[1];
		    	 }else {
		    		 return o1[0] - o2[0]; 
		    	 }
	           }
        });
        
        for(int i = 0; i < road.length; i++) {
        	list.add(road[i]);
        }
        copy.addAll(list);
        int time = 0;
        int purpose = 0;
        int[] arr = new int[3];
        for(int i = 0; i < list.size(); i++) {
        	if(list.get(i)[0] == 1) {
        		if(list.get(i)[2] <= K) {
        			time = list.get(i)[2];
            		purpose = list.get(i)[1];
            		city[purpose-1] = 1;
            		if(time != K) {
            			arr = list.get(i);
                		copy.remove(i);
            			gogo(copy, city, K, purpose, time);
            			copy.add(i, arr);
            		}
        		}
        	}
        	else {
        		break;
        	}
        }
        System.out.println(Arrays.toString(city));
        for(int i = 0; i < city.length; i++) {
        	answer += city[i];
        }
        
        return answer;
    }
	
	public static void gogo(LinkedList<int[]> copy, int[] city, int K, int purpose,int time) {
		ArrayList<int[]> list = new ArrayList<>(copy);
		int[] arr = new int[3];
		int hereTime = time;
		int herePurpose = purpose;
		int p1 = 0, p2 = 0, t = 0;
		for(int i = 0; i < list.size(); i++) {
			hereTime = time;
			herePurpose = purpose;
			p1 = list.get(i)[0];
			p2 = list.get(i)[1];
			t = list.get(i)[2];
			if(p1 == herePurpose && t + hereTime <= K) {
				hereTime += t;
				herePurpose = p2;
				city[herePurpose-1] = 1;
				if(hereTime < K) {
					arr = list.get(i);
					copy.remove(i);
					gogo(copy, city, K, herePurpose, hereTime);
					copy.add(i, arr);
				}
			}
			else if(p2 == herePurpose && t + hereTime <= K) {
				hereTime += t;
				herePurpose = p1;
				city[herePurpose-1] = 1;
				if(hereTime < K) {
					arr = list.get(i);
					copy.remove(i);
					gogo(copy, city, K, herePurpose, hereTime);
					copy.add(i, arr);
				}
			}
			else if(p1 > purpose){
				break;
			}
		}
	}
    

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int[][] road2 = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int[][] road3 = {{1,2,1},{1,3,1},{1,4,1},{1,5,1},{1,6,2}};
		System.out.println("the answer is : " +s.solution(5, road, 3));
		System.out.println("the answer is : " +s.solution(6, road2, 4));
		System.out.println("the answer is : " +s.solution(6, road3, 1));

	}

}
