package ysp_211027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution2 {
	public int solution(int n, int[][] wires) {
        int answer = -1;
        
        ArrayList<int[]> wife = new ArrayList<>();
        for(int i = 0; i < wires.length; i++) {
        	Arrays.sort(wires[i]);
        	wife.add(wires[i]);
        }
        LinkedList<int[]> copy = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        PriorityQueue<Integer> difference = new PriorityQueue<>();
        int Asize = 0;
        int Bsize = 0;
        int result = 0;
        for(int i = 0; i < wires.length; i++) {
        	copy.addAll(wife);
        	copy.remove(i);
        	list.add(copy.get(0)[0]);
        	list.add(copy.get(0)[1]);
        	copy.remove(0);
        	gogo(copy,list);
        	Asize = list.size();
        	Bsize = n - Asize;
        	result = Math.abs(Asize-Bsize);
        	//System.out.println(i+" 번째 //"+Asize+" : 한쪽 // "+Bsize+
        	//					" : 다른쪽 // 그것을 자르고 두개로 나눔 : "+result);
        	difference.add(result);
        	list.clear();
        	copy.clear();
        }
        answer = difference.peek();
        return answer;
    }
	
	public static void gogo(LinkedList<int[]> copy, LinkedList<Integer> list) {
		int a = 0,b = 0;
		for(int i = 0; i < copy.size(); i++) {
			a = copy.get(i)[0];
			b = copy.get(i)[1];
			if(list.contains(a) && !list.contains(b)) {
				list.add(b);
				copy.remove(i);
				gogo(copy,list);
			}
			else if(list.contains(b) && !list.contains(a)) {
				list.add(a);
				copy.remove(i);
				gogo(copy,list);
			}
		}
	}
	

	public static void main(String[] args) {
		int[][] a = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		int[][] b = {{1,2},{2,3},{3,4}};
		int[][] c = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
		int[][] d = {{1,4},{6,3},{2,5},{5,1},{5,3}};
		Solution2 s = new Solution2();
		System.out.println(s.solution(9, a));
		System.out.println(s.solution(4, b));
		System.out.println(s.solution(7, c));
		System.out.println(s.solution(6, d));

	}

}
