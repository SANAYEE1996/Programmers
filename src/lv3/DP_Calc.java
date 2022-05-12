package lv3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DP_Calc {
	public static ArrayList<Integer> plus(ArrayList<Integer> all, int n) {
		ArrayList<Integer> list = new ArrayList<>();
		int exam = 0;
		for (int i : all) {
			exam = n+i;
			if(!list.contains(exam)) {
				list.add(exam);
			}
		}
		
		return list;
	}
	
	public static ArrayList<Integer> minus(ArrayList<Integer> all, int n) {
		ArrayList<Integer> list = new ArrayList<>();
		int exam = 0;
		for (int i : all) {
			exam = n-i;
			if(!list.contains(exam)) {
				list.add(exam);
			}
			exam = i-n;
			if(!list.contains(exam)) {
				list.add(exam);
			}
		}
		
		return list;
	}
	
	public static ArrayList<Integer> multiple(ArrayList<Integer> all, int n) {
		ArrayList<Integer> list = new ArrayList<>();
		int exam = 0;
		for (int i : all) {
			exam = n*i;
			if(!list.contains(exam)) {
				list.add(exam);
			}
		}
		
		return list;
		
	}
	
	public static ArrayList<Integer> divide(ArrayList<Integer> all, int n) {
		ArrayList<Integer> list = new ArrayList<>();
		int exam = 0;
		for (int i : all) {
			if(i != 0) {
				exam = n/i;
				if(!list.contains(exam)) {
					list.add(exam);
				}
			}
			if(n != 0) {
				exam = i/n;
				if(!list.contains(exam)) {
					list.add(exam);
				}
			}
		}
		
		return list;
	}
	
	public static int attach(int count, int n) {
		int answer = n;
		int ten = 1;
		for(int i = 1; i <= count-1; i++) {
			ten *= 10;
			answer += ten*n;
		}
		
		return answer;
	}
	
	
	public int solution(int N, int number) {
        if(N == number) return 1;
		
		int answer = 2;
        
        ArrayList<Integer> all = new ArrayList<>();
        all.add(N);
        
        Set<Integer> set = new HashSet<>();
        
        while(answer < 9) {
        	set.clear();
        	ArrayList<Integer> pl = plus(all, N);
        	ArrayList<Integer> mi = minus(all, N);
        	ArrayList<Integer> mu = multiple(all, N);
        	ArrayList<Integer> di = divide(all, N);
        	set.addAll(pl);
        	set.addAll(mi);
        	set.addAll(mu);
        	set.addAll(di);
        	set.add(attach(answer, N));
        	all.addAll(set);
        	attach(answer, N);
        	if(all.contains(number)) break;
        	answer++;
        }
        
        
        all.clear();
        
        
        if(answer == 9) return -1;
        else return answer;
    }

	public static void main(String[] args) {
		DP_Calc s = new DP_Calc();
		
		System.out.println("정답은 ~~~~ "+s.solution(5, 12));
		System.out.println("정답은 ~~~~ "+s.solution(2, 11));
		System.out.println("정답은 ~~~~ "+s.solution(4, 100));
		
		System.out.println("정답은 ~~~~ "+s.solution(5, 250));
		System.out.println("정답은 ~~~~ "+s.solution(5, 1375));
		
		System.out.println("정답은 ~~~~ "+s.solution(1, 1121));
	}

}
