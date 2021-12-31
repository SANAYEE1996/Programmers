package ysp_211229;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Solution {
	
	public int[] solution(String[] gems) {
		HashSet<String> set = new HashSet<>();
		ArrayList<String> list = new ArrayList<>();
		for(String s : gems) {
			set.add(s);
			list.add(s);
		}
		ArrayList<String> orgin = new ArrayList<>(set);
		int[] start = {0};
		int end = 1;
		ArrayList<int[]> map = new ArrayList<>();
		for(int i = 0; i < gems.length; i++) {
			if(list.subList(start[0], end).containsAll(orgin)) {
				map.add(new int[] {++start[0], end});
				gogo(list, map, orgin, start, end);
			}
			end++;
		}
		Collections.sort(map, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				int length = a[1] - a[0];
				int length1 = b[1] - b[0];
				if(length == length1) {
					return a[0] - b[0];
				}
				else {
					return length - length1;
				}
			}
		});
        return new int[] {map.get(0)[0], map.get(0)[1]};
    }
	
	public static void gogo(ArrayList<String> list, ArrayList<int[]> map, 
							ArrayList<String> orgin, int[] start, int end) {
		if(list.subList(start[0], end).containsAll(orgin)) {
			map.add(new int[] {++start[0], end});
			gogo(list, map, orgin, start, end);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		
		String[] a = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		String[] b = {"AA", "AB", "AC", "AA", "AC"};
		String[] c = {"XYZ", "XYZ", "XYZ"};
		String[] d = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		
		System.out.println("the answer is : " +Arrays.toString(s.solution(a)));
		System.out.println("the answer is : " +Arrays.toString(s.solution(b)));
		System.out.println("the answer is : " +Arrays.toString(s.solution(c)));
		System.out.println("the answer is : " +Arrays.toString(s.solution(d)));
		
		long start = 0;
		long end = 0;
		HashSet<Integer> set = new HashSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> ggg = new ArrayList<>();
		for(int i = 0; i < 100000; i++) {
			list.add(i+1);
		}
		for(int i = 0; i < 99999; i++) {
			ggg.add(i+1);
		}
		
		System.out.println("리스트 사이즈 : " +list.size());
		
		
		
		start = System.nanoTime();
		set.addAll(list);
		end = System.nanoTime();
		System.out.println("add All 했을 때 시간 :\t\t" +((double)(end-start))/1000000000);
		
		start = System.nanoTime();
		list.containsAll(ggg);
		end = System.nanoTime();
		BigDecimal cm = new BigDecimal(((double)(end-start))/1000000000);
		System.out.println("containsAll 시간 :\t\t" +cm.toString().substring(0, 10));
		
		start = System.nanoTime();
		ggg.addAll(list);
		end = System.nanoTime();
		cm = new BigDecimal(((double)(end-start))/1000000000);
		System.out.println("arrayList에 addall 했을 때 시간 :\t" +cm.toString().substring(0, 10));
		
		start = System.nanoTime();
		ggg.contains(100000);
		end = System.nanoTime();
		cm = new BigDecimal(((double)(end-start))/1000000000);
		System.out.println("arrayList에서 찾았을때 시간 :\t\t" +cm.toString().substring(0, 10));
		
		start = System.nanoTime();
		ggg.clear();;
		end = System.nanoTime();
		cm = new BigDecimal(((double)(end-start))/1000000000);
		System.out.println("arrayList를 초기화 한 시간 : \t\t" +cm.toString().substring(0, 10));
		
		start = System.nanoTime();
		set.clear();
		end = System.nanoTime();
		System.out.println("clear 했을 때 시간 :\t\t\t" +((double)(end-start))/1000000000);
		
		start = System.nanoTime();
		set.add(1);
		end = System.nanoTime(); 
		BigDecimal bm = new BigDecimal(((double)(end-start))/1000000000);
		System.out.println("add 딱 하나만 했을 때 시간 :\t\t" +bm.toString().substring(0, 10));
	}

}
