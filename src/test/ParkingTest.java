package test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import KAKAO_2022_Blind.LV2_Parking;

class ParkingTest {

	private LV2_Parking park;
	
	@BeforeEach
	public void setup() {
		park = new LV2_Parking();
	}
	
	@Test
	void testCase01() {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", 
							"06:34 0000 OUT", "07:59 5961 OUT", 
							"07:59 0148 IN", "18:59 0000 IN", 
							"19:09 0148 OUT", "22:59 5961 IN", 
							"23:00 5961 OUT"};
		int[] answer = {14600, 34400, 5000};
		assertArrayEquals(answer, park.solution(fees, records));
	}
	
	@Test
	void testCase02() {
		int[] fees = {120, 0, 60, 591};
		String[] records = {"16:00 3961 IN","16:00 0202 IN",
							"18:00 3961 OUT","18:00 0202 OUT",
							"23:58 3961 IN"};
		int[] answer = {0, 591};
		assertArrayEquals(answer, park.solution(fees, records));
	}
	
	@Test
	void testCase03() {
		int[] fees = {1, 10, 1, 11};
		String[] records = {"00:00 1234 IN", "00:02 1234 OUT"};
		int[] answer = {21};
		assertArrayEquals(answer, park.solution(fees, records));
	}

}
