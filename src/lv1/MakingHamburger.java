package lv1;

import java.util.ArrayList;

public class MakingHamburger {
	public int solution(int[] ingredient) {
		ArrayList<Integer> ingredientList = new ArrayList<>();
        int answer = 0;
        for(int i : ingredient) {
        	ingredientList.add(i);
        	if(ingredientList.size() >= 4 && isRightOrder(ingredientList)) {
        		removeTop4List(ingredientList);
        		answer++;
        	}
        }
        return answer;
    }
	
	private boolean isRightOrder(ArrayList<Integer> list) {
		int last = list.size()-1;
		return (list.get(last-3) == 1 && list.get(last-2) == 2 && list.get(last-1) == 3 && list.get(last) == 1);
	}
	
	private void removeTop4List(ArrayList<Integer> list) {
		int last;
		for(int i = 0; i < 4; i++) {
			last = list.size()-1;
			list.remove(last);
		}
	}
}
