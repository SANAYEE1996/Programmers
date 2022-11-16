package lv1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lv1.SellApple;

class SellAppleTest {
	
	private SellApple s;
	
	@BeforeEach
	public void setup() {
		s = new SellApple();
	}

	@Test
	void test() {
		assertEquals(8,s.solution(3, 4, new int[] {1, 2, 3, 1, 2, 3, 1}));
		assertEquals(33,s.solution(4, 3, new int[] {4,1,2,2,4,4,4,4,1,2,4,2}));
	}

}
