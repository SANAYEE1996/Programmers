package ysp_211014;

import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {
	public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        double[] ratio = new double[weights.length];
        int[] bigger = new int[weights.length];
        String a;
        double victory;
        double total;
        int big;
        for(int i = 0; i < head2head.length; i++) {
           a = head2head[i];
           victory = 0;
           total = a.length() - 1;
           big = 0;
           for(int j = 0; j < a.length(); j++) {
              if(i != j) {
                 if(a.charAt(j) == 'W') {
                    victory++;
                    if(weights[i] < weights[j]) {
                       big++;
                    }
                 }
                 else if(a.charAt(j) == 'N') {
                    total--;
                 }
              }
           }
           if(total == 0) {
              victory = 0;
           }
           else {
              victory /= total;
           }
           ratio[i] = victory;
           bigger[i] = big;
        }
        double[][] gogo = new double[weights.length][3];
        for(int i = 0; i < gogo.length; i++) {
        	gogo[i][0] = ratio[i];
        	gogo[i][1] = bigger[i];
        	gogo[i][2] = i;
        }
        Arrays.sort(gogo, new Comparator<double[]>() {
		    @Override
			public int compare(double[] o1, double[] o2) {
		    	 if(o1[0] == o2[0]) {
	                	 return (int) (o1[1] - o2[1]);
		    	 }else {
		    		 return (int) (o1[0] - o2[0]); 
		    	 }
	           }
	    });
        System.out.println("승률 : "+Arrays.toString(ratio));
        System.out.println("자기보다 무거운 복서 이긴 횟수 : "+Arrays.toString(bigger));
        return answer;
    }

   public static void main(String[] args) {
      Solution3 s = new Solution3();
      int[] a = {50,82,75,120};
      String[] a1 = {"NLWL","WNLL","LWNW","WWLN"};
      
      int[] b = {145,92,86};
      String[] b1 = {"NLW","WNL","LWN"};
      
      int[] c = {60,70,60};
      String[] c1 = {"NNN","NNN","NNN"};
      
      System.out.println(Arrays.toString(s.solution(a, a1)));
      System.out.println(Arrays.toString(s.solution(b, b1)));
      System.out.println(Arrays.toString(s.solution(c, c1)));

   }


}
