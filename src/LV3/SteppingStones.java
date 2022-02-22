package LV3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SteppingStones {
	public int solution(int[] stones, int k) {
        int answer = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < stones.length; i++) {
        	if(!map.containsKey(stones[i])) {
        		map.put(stones[i], new ArrayList<Integer>());
        	}
        	map.get(stones[i]).add(i);
        }
        ArrayList<Integer> go = new ArrayList<>();
        
        Object[] keySet = map.keySet().toArray();
        Arrays.sort(keySet);
        
        Object key = 0;
        int length = stones.length-1;
        for(int i = keySet.length-1; i >= 0; i--) {
        	key = keySet[i];
        	System.out.println("값 : " +key + " 이 있는 인덱스 들 : " +map.get(key));
        	System.out.println("들어가기 전 리스트 : " +go);
        	System.out.println("↑ 여기에 들어갈 리스트 : " +map.get(key));
        	gogo(go, map.get(key),k,length);
        	
            System.out.println();
        }
        
        
        
        return answer;
    }
	
	public static void gogo(ArrayList<Integer> go, ArrayList<Integer> mapGet, int k,int length) {
		
		int key = 0;
		int mid = 0;
		int low = 0, high = 0;
		
		for(int i = 0; i < mapGet.size(); i++) {
			key = mapGet.get(i);
			low = 0;
			high = go.size()-1;
			while(low <= high) {
				
				mid = (low + high) / 2;

				if(key == go.get(mid)) {
					break;
				} else if(key < go.get(mid)) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			System.out.println(key+" 가  "+go+" 안에 들어갈 자리 : "+mid);
			if(mid > 0) {
				if(go.get(mid) > key) {
					go.add(mid, key);
					
				}
				else {
					if(mid < go.size()-1) {
						go.add(mid+1,key);
					}
					else {
						go.add(key);
					}
				}
			}
			else {
				if(go.size() == 0) {
					go.add(key);
				}
				else {
					if(go.get(mid) > key) {
						go.add(mid, key);
					}
					else {
						if(mid < go.size()-1) {
							go.add(mid+1,key);
						}
						else {
							go.add(key);
							if(go.get(0) <= k && go.get(1)-go.get(0) <= k) {
								if(go.size() >= 2 && go.get(2)-go.get(1) <= k) {
									System.out.println("건널 수 있다.");
								}
								else if(go.size() == 1) {
									System.out.println("건널 수 있다.");
								}
							}
						}
					}
				}
			}
		}
		
	}

	public static void main(String[] args) {
		SteppingStones s = new SteppingStones();
		
		System.out.println("the answer is : " 
		+s.solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));

	}

}
