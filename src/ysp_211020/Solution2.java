package ysp_211020;

import java.util.Arrays;

public class Solution2 {
	public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        int cbsp = 0;
        
        Arrays.sort(info);
        for(int i = 0; i < info.length; i++) {
        	if(info[i].charAt(0) == 'c') {
        		if(info[i].charAt(4) == ' ') {
        			
        		}
        	}
        	else if(info[i].charAt(0) == 'j') {
        		
        	}
        	else if(info[i].charAt(0) == 'p') {
        		
        	}
        }
        String[] a = new String[8];
		for(int i = 0; i < query.length; i++) {
			a = query[i].split(" ");
			if(a[0].equals("java")) {
				
			}
			else if(a[0].equals("cpp")) {
				
			}
			else if(a[0].equals("python")) {
							
			}
			else if(a[0].equals("-")) {
				
			}
		}
        return answer;
    }

	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150",
				"java frontend senior chicken 300",
				"python frontend senior chicken 210",
				"python frontend senior chicken 150",
				"cpp backend senior pizza 260",
				"java backend junior chicken 80",
				"python backend senior chicken 50"};
		
		String[] query = {	"java and backend and junior and pizza 100",
							"python and frontend and senior and chicken 200",
							"cpp and - and senior and pizza 250",
							"- and backend and senior and - 150",
							"- and - and - and chicken 100",
							"- and - and - and - 150"};
		
		Arrays.sort(info);
		
		System.out.println(Arrays.toString(info));
		
		String[] a = new String[8];
		for(int i = 0; i < query.length; i++) {
			a = query[i].split(" ");
			System.out.println(Arrays.toString(a));
		}

	}

}
