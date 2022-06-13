package KAKAO_2022_Blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LV2_Bow {
	public int getTotalCount(int[] info) {
		int totalCount = 0;
        for(int i : info) totalCount += i;
        return totalCount;
	}
	
	public void putScoreToMap(Map<Integer,ArrayList<Integer>> map, int[] info) {
		for(int i = 0; i < info.length; i++) {
        	if(!map.containsKey(info[i]+1)) map.put(info[i]+1, new ArrayList<Integer>());
        	map.get(info[i]+1).add(10-i);
        }
	}
	
	public void sortReverseScore(Map<Integer,ArrayList<Integer>> map) {
		for(int key : map.keySet()) {
        	Collections.sort(map.get(key), Collections.reverseOrder());
        }
	}
	
	public void getMaxScoreByLine(Object[] keyArray, Map<Integer,ArrayList<Integer>> map, 
							ArrayList<Integer> list, int totalCount, int minusCount, int value, 
							int MaxKeyIndex, int nowIndex,
							ArrayList<Integer> maxList) {
		int size = totalCount/minusCount;
		if(minusCount >= totalCount && totalCount > 0) size = minusCount/totalCount;
		if(size <= 0 || totalCount <= 0) {
			maxList.add(value);
		}
		else {
			System.out.println(list +" 에서 최대 몇번 먹을 수 있는가 : "+size);
			for(int i = 0; i < size; i++) {
				getMaxScore(keyArray, map, 
						totalCount - minusCount, MaxKeyIndex, nowIndex + 1, value + list.get(i)
						,maxList);
				totalCount -= minusCount;
				value += list.get(i);
			}
		}
		
	}
	
	public void getMaxScore(Object[] keyArray, Map<Integer,ArrayList<Integer>> map, 
			int totalCount, int MaxKeyIndex, int nowIndex, int value,
			ArrayList<Integer> maxList) {
		if(nowIndex <= MaxKeyIndex) {
			
			//System.out.println("현재 최소 횟수 : " +(int) keyArray[nowIndex]);
			//System.out.println("이걸로 먹을 수 있는 점수 : "+map.get(keyArray[nowIndex]));
			//System.out.println("몇번 남았을 까 : " +totalCount);
			getMaxScoreByLine(keyArray, map, 
			map.get(keyArray[nowIndex]), totalCount, (int) keyArray[nowIndex], value, 
			MaxKeyIndex, nowIndex,maxList);
		}
		
	}
	
	public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        int totalCount = getTotalCount(info);
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        putScoreToMap(map, info);
        sortReverseScore(map);
        
        Object[] keyArray = map.keySet().toArray();
        Arrays.sort(keyArray);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("총 쏠 수 있는 횟수 : " +totalCount);
        
        getMaxScore(keyArray, map, 
        		totalCount, keyArray.length-1,0,0, 
        		list);
        
        System.out.println(list);
        
        return answer;
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
