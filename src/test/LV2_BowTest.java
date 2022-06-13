package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import KAKAO_2022_Blind.LV2_Bow;

class LV2_BowTest {
	
	private LV2_Bow bow;
	
	@BeforeEach
	public void setup() {
		bow = new LV2_Bow();
	}
	
	@Test
	void testCase01() {
		int n = 5;
		int[] info = {2,1,1,1,0,0,0,0,0,0,0};
		assertEquals(new int[] {0,2,2,0,1,0,0,0,0,0,0}, bow.solution(n, info));
	}
	
	@Test
	void testCase02() {
		int n = 1;
		int[] info = {1,0,0,0,0,0,0,0,0,0,0};
		assertEquals(new int[] {-1}, bow.solution(n, info));
	}
	
	@Test
	void testCase03() {
		int n = 9;
		int[] info = {0,0,1,2,0,1,1,1,1,1,1};
		assertEquals(new int[] {1,1,2,0,1,2,2,0,0,0,0}, bow.solution(n, info));
	}
	
	@Test
	void testCase04() {
		int n = 10;
		int[] info = {0,0,0,0,0,0,0,0,3,4,3};
		assertEquals(new int[] {1,1,1,1,1,1,1,1,0,0,2}, bow.solution(n, info));
	}

}
