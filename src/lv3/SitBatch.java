package lv3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class SitBatch {
public long[][] solution(String[] record) {
		
		
		String[] str;
		int id = 0;
		int k = 0;
		HashMap<Integer, int[]> map = new HashMap<>();
		LinkedList<Long> list = new LinkedList<>();
		LinkedList<Integer> sit = new LinkedList<>();
		int index = 0;
		
		for(String s : record) {
			str = s.split(" ");
			id = Integer.parseInt(str[0].substring(str[0].indexOf("=")+1));
			if(str.length == 3) {
				k = Integer.parseInt(str[2].substring(str[2].indexOf("=")+1));
				//System.out.println("id "+id+" 는 "+str[1]+" 앉는 것" + k +" 만큼 띄어서");
				
				if(list.size() == 0) {
					//앉은 사람이 없을 때
					list.add((long)k);
					sit.add(id);
					map.put(id, new int[] {0,k});
				}
				else {
					//앉은 사람이 있을 때
					gogo(list, map, sit, id, k);
				}
				
				/*
				for(int key : map.keySet()) {
					System.out.println(key + " " +Arrays.toString(map.get(key)));
				}
				System.out.println(list);
				System.out.println(sit);
				*/
			}
			else {
				//System.out.println("id "+id+" 는 "+str[1]+" 떠나는 것");
				for(int i = 0; i < sit.size(); i++) {
					if(sit.get(i) == id) {
						index = i;
						break;
					}
				}
				
				map.remove(id);
				
				for(int key : map.keySet()) {
					if(map.get(key)[0] > index) {
						map.get(key)[0]--;
					}
				}
				
				sit.remove(index);
				list.remove(index);
				/*
				for(int key : map.keySet()) {
					System.out.println(key + " " +Arrays.toString(map.get(key)));
				}
				System.out.println(list);
				System.out.println(sit);
				*/
			}
			
		}
		/*
		for(int key : map.keySet()) {
			System.out.println(key + " " +Arrays.toString(map.get(key)));
		}
		*/
		
		
		
        long[][] answer = new long[list.size()][2];
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i][0] = sit.get(i);
        	answer[i][1] = list.get(i);
        }
        
        Arrays.sort(answer, new Comparator<long[]>() {
        	@Override
        	public int compare(long[] o1, long[] o2) {
        		return (int) (o1[0] - o2[0]);
        	}
        });
        
        
        for(long[] i : answer) {
        	System.out.println(Arrays.toString(i));
        }
        
        
        return answer;
    }
	
	public static void gogo(LinkedList<Long> list, HashMap<Integer, int[]> map,
							LinkedList<Integer> sit, int id, int k) {
		long diff = list.get(0) - map.get(sit.get(0))[1];
		boolean not = false;
		
		if(diff >= k*2) {
			list.add(0,(long) k);
			sit.add(0,id);
			for(int key : map.keySet()) {
				map.get(key)[0]++;
			}
			map.put(id, new int[] {0,k});
		}
		else {
			for(int i = 0; i < list.size()-1; i++) {
				diff = list.get(i+1) - list.get(i);
				diff -= (map.get(sit.get(i))[1] + map.get(sit.get(i+1))[1]);
				if(diff >= k*2) {
					if(map.get(sit.get(i))[1] > k) {
						list.add(i, list.get(i) + map.get(sit.get(i))[1]);
					}
					else {
						list.add(i, list.get(i) + (long) k+1);
					}
					sit.add(i, id);
					for(int key : map.keySet()) {
						if(map.get(key)[0] >= i) {
							map.get(key)[0]++;
						}
					}
					map.put(id, new int[] {i,k});
					not = true;
					break;
				}
			}
			
			if(!not) {
				if(map.get(sit.get(sit.size()-1))[1] >= k) {
					list.add(list.get(list.size()-1) + map.get(sit.get(sit.size()-1))[1] + 1);
				}
				else {
					list.add(list.get(list.size()-1) + (long) k + 1);
				}
				sit.add(id);
				map.put(id, new int[] {list.size()-1,k});
			}
		}
		
	}

	public static void main(String[] args) {
		String[] a = {"id=1 sit k=1","id=2 sit k=3","id=3 sit k=2",
				"id=2 leave","id=4 sit k=4","id=5 sit k=2"};
		String[] b = {"id=1 sit k=1","id=2 sit k=3","id=3 sit k=2",
						"id=2 leave","id=4 sit k=1","id=5 sit k=3"};
		String[] c = {"id=1 sit k=6","id=1 leave","id=2 sit k=1",
						"id=3 sit k=5","id=4 sit k=2"};
		String[] d = {"id=1 sit k=1","id=2 sit k=3",
						"id=1 leave","id=3 sit k=1"};
		
		
		SitBatch s = new SitBatch();
		
		System.out.println("the answer is : " +s.solution(a));
		System.out.println("the answer is : " +s.solution(b));
		System.out.println("the answer is : " +s.solution(c));
		System.out.println("the answer is : " +s.solution(d));
		
		long big = 100000000000L;
		int small = 4;
		
		System.out.println(big + small);

	}

}
