package lv1;

public class FoodFightContest {
	public String solution(int[] food) {
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < food.length; i++) {
        	for(int j = 0; j < food[i]/2; j++) {
        		sb.append(i);
        	}
        }
        StringBuilder revereSb = new StringBuilder();
        revereSb.append(sb);
        revereSb.append(0);
        revereSb.append(sb.reverse());
        
        return revereSb.toString();
    }
	
	public static void main(String[] args) {
		FoodFightContest s = new FoodFightContest();
		System.out.println(s.solution(new int[] {1,3,4,6}));
		System.out.println(s.solution(new int[] {1,7,1,2}));
	}
}
