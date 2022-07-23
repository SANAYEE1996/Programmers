package ysp_220112;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution03 {
	
	int[] monthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	boolean isLeapYear(int year) {
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) return true;
		return false;
	}
	
	int getAfterWholeDate(Date afterDate) {
		int addDay = (isLeapYear(afterDate.getYear()) && afterDate.getMonth() > 2) ? 1 : 0;
		int answer = addDay + afterDate.getDay();
		for(int i = 0; i < afterDate.getMonth()-1; i++) {
			answer += monthArray[i];
		}
		return answer;
	}
	
	int getBeforeWholeDate(Date beforeDate) {
		int addDay = (isLeapYear(beforeDate.getYear()) && beforeDate.getMonth() <= 2) ? 1 : 0;
		int answer = addDay + (monthArray[beforeDate.getMonth()-1] - beforeDate.getDay());
		for(int i = beforeDate.getMonth(); i < 12; i++) {
			answer += monthArray[i];
		}
		return answer;
	}
	
	int getSameYearDifferCount(Date beforeDate, Date afterDate) {
		int addDay= (isLeapYear(beforeDate.getYear()) && beforeDate.getMonth() <= 2) ? 1 : 0;
		if(beforeDate.getMonth() == afterDate.getMonth()) return afterDate.getDay()-beforeDate.getDay() + addDay;
		int answer = addDay + (monthArray[beforeDate.getMonth()-1] - beforeDate.getDay());
		for(int i = beforeDate.getMonth(); i < afterDate.getMonth()-1; i++) {
			answer += monthArray[i];
		}
		answer += afterDate.getDay();
		return answer;
	}
	
	int getDifferYearDifferCount(Date beforeDate, Date afterDate) {
		int answer = 0;
		int beforeYear = beforeDate.getYear();
		int afterYear = afterDate.getYear();
		for(int i = beforeYear + 1; i < afterYear; i++) answer = (isLeapYear(i)) ? answer+366 : answer+365;
		answer += getAfterWholeDate(afterDate);
		answer += getBeforeWholeDate(beforeDate);
		return answer;
	}
	
	int getDifferDate(Date beforeDate, Date afterDate) {
		if(afterDate.getYear() - beforeDate.getYear() == 0) return getSameYearDifferCount(beforeDate, afterDate);
		return getDifferYearDifferCount(beforeDate, afterDate);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] str = input.split(" ");
		Date beforeDate = new Date(	Integer.parseInt(str[0].substring(0,4)),
									Integer.parseInt(str[0].substring(4,6)), 
									Integer.parseInt(str[0].substring(6)));
		Date afterDate = new Date(	Integer.parseInt(str[1].substring(0,4)),
									Integer.parseInt(str[1].substring(4,6)), 
									Integer.parseInt(str[1].substring(6)));
		Solution03 s = new Solution03();
		System.out.println(s.getDifferDate(beforeDate, afterDate));
	}
}

class Date{
	private int year;
	private int month;
	private int day;
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
}
