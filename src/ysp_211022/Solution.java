package ysp_211022;


public class Solution {
	public int solution(String phone_number) {
		if(isNumber(phone_number)) {
			return 2;
		}
		else {
			if(phone_number.length()==13 &&
				isNumber(phone_number.substring(0,3)) &&
				isNumber(phone_number.substring(4,8)) &&
				isNumber(phone_number.substring(9)) &&
				phone_number.charAt(3) == '-' &&
				phone_number.charAt(8) == '-') {
				return 1;
			}
			else if(phone_number.length()==16 &&
					isNumber(phone_number.substring(7,11)) &&
					isNumber(phone_number.substring(12)) &&
					phone_number.substring(0,7).equals("+82-10-") &&
					phone_number.charAt(11) == '-') {
				return 3;
			}
			return -1;
		}
    }
	
	public boolean isNumber(String a){
		boolean isnumb = true;
		for(int i = 0; i < a.length(); i++) {
			if(!Character.isDigit(a.charAt(i))) {
				isnumb = false;
			}
		}
		return isnumb;
	}

	public static void main(String[] args) {

	}

}
