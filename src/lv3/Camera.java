package lv3;

import java.util.Arrays;
import java.util.Comparator;

public class Camera {
	public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] a, int[] b) {
        		if(a[0] == b[0]) {
        			return a[1] - b[1];
        		}
        		else {
        			return a[0] - b[0];
        		}
        	}
        });
        
        for(int[] i : routes) {
        	System.out.print(Arrays.toString(i)+" ");
        }
        System.out.println();
        
        int flag = routes[0][1];
        for(int i = 1; i < routes.length; i++) {
        	if(flag <= routes[i][1] && flag >= routes[i][0]) {
        		continue;
        	}
        	else if(flag < routes[i][0]) {
        		flag = routes[i][1];
        		answer++;
        	}
        	else if(flag > routes[i][1]) {
        		flag = routes[i][1];
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		Camera s = new Camera();
		
		int[][] a = { {-20, 15}, {-14, -5}, {-18, -13}, {-5, -3} };
		int[][] b ={ {-2, -1}, {1, 2}, {-3, 0} };
		int[][] c ={ {0, 0}, };
		int[][] d ={ {0, 1}, {0, 1}, {1, 2} };
		int[][] e = { {0, 1}, {2, 3}, {4, 5}, {6, 7} };
		int[][] f ={ {-7, 0}, {-6, -4}, {-5, -3}, 
					{-3, -1}, {-1, 4}, {1, 2}, {3, 4} };
		int[][] g ={ {0, 1}, {1, 2}, {2, 3}, 
					{3, 4}, {4, 5}, {5, 6}, 
					{6, 7}, {7, 8}, {8, 9}, 
					{9, 10}, {10, 11}, {11, 12}, 
					{12, 13}, {13, 14}, {14, 15} };
		
		System.out.println("the answer is : " +s.solution(a));
		System.out.println("the answer is : " +s.solution(b));
		System.out.println("the answer is : " +s.solution(c));
		System.out.println("the answer is : " +s.solution(d));
		System.out.println("the answer is : " +s.solution(e));
		System.out.println("the answer is : " +s.solution(f));
		System.out.println("the answer is : " +s.solution(g));
		
	}

}
