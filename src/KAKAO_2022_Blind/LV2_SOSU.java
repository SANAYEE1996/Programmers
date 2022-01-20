package KAKAO_2022_Blind;

import java.util.ArrayList;

public class LV2_SOSU {
	public int solution(int n, int k) {
		String gin = getGin(n, k);
		ArrayList<Long> list = new ArrayList<>();
		for(int i = 0; i < gin.length()-1; i++) {
			if(gin.charAt(i+1) == '0') {
				if(!gin.substring(0,i+1).contains("0"))
					list.add(Long.parseLong(gin.substring(0,i+1)));
			}
		}
		if(!gin.contains("0"))
			list.add(Long.parseLong(gin));
		for(int i = 1; i < gin.length(); i++) {
			if(gin.charAt(i-1) == '0' && gin.charAt(i) != '0') {
				for(int j = i; j < gin.length()-1; j++) {
					if(gin.charAt(j+1) == '0'  && gin.charAt(j) != '0') {
						if(!gin.substring(i,j+1).contains("0"))
							list.add(Long.parseLong(gin.substring(i,j+1)));
					}
				}
				if(!gin.substring(i).contains("0"))
					list.add(Long.parseLong(gin.substring(i)));
			}
		}
		int answer = 0;
		for(long i : list) {
			if(i > 1 && isSosu(i)) {
				answer++;
			}
			
		}
        return answer;
    }
	
	public static boolean isSosu(long n) {
		boolean isSosu = true;
		if(n == 2) return isSosu;
		for(long i = 2; i < Math.sqrt(n)+1; i++) {
			if(n % i == 0) {
				isSosu = false;
				break;
			}
		}
		
		return isSosu;
	}
	
	public static String getGin( int value, int n) { 
		StringBuilder builder = new StringBuilder(); 
		while (value >= 1) {
			builder.insert(0, value % n);
			value /= n; 
		}
		return builder.toString(); 
	}


	public static void main(String[] args) {
		LV2_SOSU s = new LV2_SOSU();
		
		System.out.println("the answer is : " +s.solution(437674, 3));
		System.out.println("the answer is : " +s.solution(110011, 10));
		System.out.println("the answer is : " +s.solution(1000000, 3));
	}

}
