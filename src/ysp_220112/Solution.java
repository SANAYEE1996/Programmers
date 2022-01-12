package ysp_220112;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int[] solution(String[] gems) {

        HashSet<String> set = new HashSet<>();

        for (String s : gems) {
            set.add(s);
        }

        int n = gems.length;

        int distance = 100000;
        
        int left = 0;
        int right = 0;
        
        int start = 0;
        int end = 0;

        HashMap<String, Integer> map = new HashMap<>();

        while (true) {

            if (set.size() == map.size()) {
                map.put(gems[left], map.get(gems[left])-1);
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            } else if (right == n) {
                break;
            } else {
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }
            
            if (map.size() == set.size() && right-left < distance) {
                distance = right-left;
                start = left+1;
                end = right;
            }

        }
        

        return new int[] {start,end};
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

	}

}
