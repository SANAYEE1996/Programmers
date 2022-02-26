package LV3;

public class Chuseok_Trrafic {
	public int solution(String[] lines) {
        int answer = 0;
        String[] exam = new String[3];
        for(String s : lines) {
        	exam = s.split(" ");
        	gogo(exam);
        } 
        return answer;
    }
	
	public static void gogo(String[] exam) {
		//System.out.println(exam[0] + " 시간 : " +exam[1] + " 소요시간 : " +exam[2]);
		String startDay = exam[0];
		String endDay = exam[0];
		
		int startHour = Integer.parseInt(exam[1].substring(0,2));
		int endHour = Integer.parseInt(exam[1].substring(0,2));
		
		int startMin = Integer.parseInt(exam[1].substring(3,5));
		int endMin = Integer.parseInt(exam[1].substring(3,5));
		
		double end = Double.parseDouble(exam[1].substring(6));		
		double t = Double.parseDouble(exam[2].substring(0,exam[2].length()-1));
		double start = end - t + 0.001;
		start = Math.round(start*1000)/1000.0;
		//System.out.println("처음 시간  ? " +start + " 끝나느 시간 : " +end);
		if(start < 0) {
			start += 60;
			startMin -= 1;
			if(startMin < 0) {
				startMin += 60;
				startHour -= 1;
				if(startHour < 0) { 
					startHour += 24;
					startDay = "2016-09-14";
				}
			}
			
		}
		System.out.println("시작 날짜 : " +startDay + " 일 , " +startHour + " 시 , " +startMin + " 분 , " +start +" 초");
		System.out.println("종료 날짜 : " +endDay + " 일 , " +endHour + " 시 , " +endMin + " 분 , " +end+" 초");
		
		
		
	}

	public static void main(String[] args) {
		Chuseok_Trrafic s = new Chuseok_Trrafic();
		
		System.out.println("the answer is : " 
		+s.solution(new String[] {"2016-09-15 00:00:00.000 3s"}));
		System.out.println();
		System.out.println("the answer is : " +
		s.solution(new String[] {"2016-09-15 23:59:59.999 0.001s"}));
		System.out.println();
		System.out.println("the answer is : " +
		s.solution(new String[] {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"}));
		System.out.println();
		System.out.println("the answer is : " +
		s.solution(new String[] {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"}));
		System.out.println();
		System.out.println("the answer is : " +
		s.solution(new String[] {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", 
				"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", 
				"2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", 
				"2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", 
				"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"}));
		System.out.println();
		System.out.println("the answer is : " +
		s.solution(new String[] {"2016-09-15 00:00:00.000 2.3s", "2016-09-15 23:59:59.999 0.1s"}));
		
		
		
		double exam = 4.003 - 0.006 + 0.001;
		System.out.println(Math.round(exam*1000)/1000.0);
	}

}
