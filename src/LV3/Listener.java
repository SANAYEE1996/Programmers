package LV3;

import java.util.ArrayList;
import java.util.Collections;

public class Listener {
	public int solution(int n) {
        int answer = 0;
        double m = Math.sqrt(n);
        
        if(m - (int) m == 0) {
        	return 1;
        }
        
        int mot = (int) m;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = mot; i >= 1; i--) {
        	count = 1;
        	answer = gogo(n, i, count);
        	list.add(answer);
        }
        
        
        return Collections.min(list);
    }
	
	public static int gogo(int n, int mot, int count) {
		n -= Math.pow(mot, 2);
		
		double m = Math.sqrt(n);
		int motCopy = (int) m;
		count++;
		if(m - (int) m == 0) {
			return count;
		}
		else {
			return gogo(n, motCopy, count);
		}
		
	}

	public static void main(String[] args) {
		Listener s = new Listener();
		
		System.out.println("3th the answer is : " +s.solution(9));
		System.out.println("3th the answer is : " +s.solution(15));
		System.out.println("3th the answer is : " +s.solution(41));

	}

}
