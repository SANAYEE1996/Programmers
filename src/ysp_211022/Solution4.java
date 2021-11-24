package ysp_211022;

public class Solution4 {
	
	public int solution(int [][]board){
        int answer = 1234;
        int size = 0;
        int maxSize = 0;
        int isSize = 1;
        for(int i = 0; i < board.length; i++) {
        	if(Math.sqrt(maxSize) < board.length-i) {
	        	for(int j = 0; j < board[i].length; j++) {
	        		size = (int) Math.sqrt(maxSize);
	        		isSize = 1;
	        		if(size >= board[i].length-j+1) {
	        			break;
	        		}
	        		if(board[i][j] == 1 && size < board[i].length-j+1) {
	        			size = size(board[i],j+1);
	        			if(size > Math.sqrt(maxSize) && i + size -1 < board.length) {
		        			for(int k = 1; k < size; k++) {
		        				if(	board[i+k][j] == 1 &&
		        					isRight(board[i+k],j,j+size)) {
		        					isSize++;
		        				}
		        				else {
		        					break;
		        				}
		        			}
	        			}
	        		}
	        		if(isSize == size && maxSize < size*size) {
        				maxSize = size*size;
        			}
	        	}
        	}
        	else {
        		break;
        	}
        }
        answer = maxSize;
        return answer;
    }
	
	public static int size(int[] a,int flag) {
		int gogo = a[flag-1];
		for(int i = flag; i < a.length; i++) {
			if(a[i] == 1) {
				gogo++;
			}
			else {
				break;
			}
		}
		return gogo;
	}
	
	public static boolean isRight(int[] a, int flag, int max) {
		boolean isRight = true;
		for(int i = flag; i < max; i++) {
			if(a[i] == 0) {
				isRight = false;
				break;
			}
		}
		return isRight;
	}
	
	public static void main(String[] args) {
		Solution4 s = new Solution4();
		int[][] a = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int[][] b = {{0,0,1,1},{1,1,1,1}};
		int[][] c = {{0,1,1,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		int[][] d = new int[1000][1000];
		for(int i = 0; i < d.length; i++) {
			for(int j = 0; j < d[i].length; j++) {
				d[i][j] = 1;
			}
		}
		long start = 0;
		long end = 0;
		start = System.nanoTime();
		System.out.println(s.solution(a));
		end = System.nanoTime();
		System.out.println("걸린시간 : " +(double)(end-start)/1000000);
		
		start = System.nanoTime();
		System.out.println(s.solution(b));
		end = System.nanoTime();
		System.out.println("걸린시간 : " +(double)(end-start)/1000000);
		
		start = System.nanoTime();
		System.out.println(s.solution(c));
		end = System.nanoTime();
		System.out.println("걸린시간 : " +(double)(end-start)/1000000);
		
		start = System.nanoTime();
		System.out.println(s.solution(d));
		end = System.nanoTime();
		System.out.println("걸린시간 : " +(double)(end-start)/1000000);

	}

}

/*
 * 11111
 * 11111
 * 11111
 * 11111
 * 11111
 */