package ysp_211104;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	public int solution(int[][] maps) {
        int answer = -1;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> q = new LinkedList<>();
        int[] a = {0,0,1};
        q.add(a);
        int x = 0;
        int y = 0;
        int height = maps.length;
        int width = maps[0].length;
        while(!q.isEmpty()){
            int[] node = q.poll();
            visited[node[0]][node[1]] = true;
            x = node[0];
            y = node[1];
            if(y > 0 && maps[x][y-1] == 1 && !visited[x][y-1]){
                q.add(new int[] {x,y-1,node[2]+1});
            }
            if(y < width-1 &&maps[x][y+1] == 1 && !visited[x][y+1]){
                q.add(new int[] {x,y+1,node[2]+1});
            }

            if(x > 0 && maps[x-1][y] == 1 && !visited[x-1][y]){
                q.add(new int[] {x-1,y,node[2]+1});
            }

            if(x < height-1 && maps[x+1][y] == 1 && !visited[x+1][y]){
                q.add(new int[] {x+1, y,node[2]+1});
            }
            
            if(visited[height-1][width-1]){
                answer = node[2];
                break;
            }
        }
        if(answer == 0) {
        	return -1;
        }
        else {
        	return answer;
        }
    }

	public static void main(String[] args) {
		int[][] a = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		int[][] b = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		
		Solution s = new Solution();
		
		System.out.println("the answer is "+s.solution(a));
		System.out.println("the answer is "+s.solution(b));

	}

}
