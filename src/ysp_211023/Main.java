package ysp_211023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class Main {
	
	
	public static void main(String[] args) {
		Hashtable<Integer, Integer> hash = new Hashtable<>();
		int[] a = {13,15,15,18,19,20,31,21,23};
		hash.put(1, 0);
		hash.put(2, 2);
		hash.put(3, 2);
		hash.put(4, 4);
		hash.put(5, 3);
		
		for(int i : hash.keySet()) {
			System.out.println(i+" " + hash.get(i));
		}
		for(int j : hash.values()) {
			System.out.println(j);
		}
		
		List<Integer> list = new ArrayList<>(hash.keySet());
		
		System.out.println("------value 내림차순------");
		Collections.sort(list, (o1, o2) -> (hash.get(o2).compareTo(hash.get(o1))));
		for(Integer key : list) {
			System.out.println("key : " + key + " / " + "value : " + hash.get(key));
		}
	}
}
