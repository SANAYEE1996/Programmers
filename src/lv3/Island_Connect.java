package lv3;


public class Island_Connect {
	public int solution(int n, int[][] costs) {
        int answer = 0;
        
        int[][] map = new int[n][n];
        
        for(int[] i : costs) {
        	map[i[0]][i[1]] = i[2];
        	map[i[1]][i[0]] = i[2];
        }
        print(map);
        
        int distance = 0;
        int targetIndex = 0;
        
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		visited = new boolean[n];
        		visited[i] = true;
        		if(i == j) continue;
        		if(map[i][j] != 0) {
        			distance = map[i][j];
        			targetIndex = j;
        			visited[j] = true;
        		}
        		
        	}
        }
        
        
        return answer;
    }
	
	public static void gogo(int[][] map, boolean[] visited, int targetIndex) {
		
		for(int i = 0; i < visited.length; i++) {
			
		}
		
		
	}
	
	
	public static void print(int[][] map) {
		for(int[] i : map) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	
	

	public static void main(String[] args) {
		Island_Connect s = new Island_Connect();
		
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		
		System.out.println("the answer is : " +s.solution(4, costs));
		

	}

}
