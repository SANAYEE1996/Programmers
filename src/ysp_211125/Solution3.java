package ysp_211125;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Solution3 {
	
	public int solution(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> flag = new HashMap<>();
        int beforeRank = 0;
        int beforeFlag = 0;
        for (int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i])) {
				beforeRank = map.get(arr[i]);
				beforeFlag = flag.get(arr[i]);
				if(beforeRank == beforeFlag) {
					map.put(arr[i], i - beforeFlag);
					flag.put(arr[i], i);
				}
				else {
					if(beforeRank > i - beforeFlag) {
						map.put(arr[i], i - beforeFlag);
						flag.put(arr[i], i);
					}
				}
			}
			else {
				map.put(arr[i], i);
				flag.put(arr[i], i);
			}
		}
        
        
        if(map.size() == arr.length) {
        	return -1;
        }
        
        List<Entry<Integer, Integer>> list_entries = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
    	
		Collections.sort(list_entries, new Comparator<Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
				return obj1.getValue().compareTo(obj2.getValue());
			}
		});
		
		
        return list_entries.get(0).getValue();
    }

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		
		int[] a = {2,1,3,1,4,2,1,3};
		int[] b = {1,2,3};
		
		System.out.println("the answer is : "+s.solution(a));
		System.out.println("the answer is : "+s.solution(b));
		

	}

}
