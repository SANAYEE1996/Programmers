package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lv2.MakeQueSum;

class IntegerationTest {
	
	private MakeQueSum mqs;
	
	@BeforeEach
	public void setup() {
		mqs = new MakeQueSum();
	}
	
	@Test
	void test() {
		System.out.println(mqs.solution(new int[] {3, 2, 7, 2}, new int[] {4, 6, 5, 1}));
		System.out.println(mqs.solution(new int[] {1, 2, 1, 2}, new int[] {1, 10, 1, 2}));
		System.out.println(mqs.solution(new int[] {1, 1}, new int[] {1, 5}));
		
		assertEquals(-1, mqs.solution(new int[] {1}, new int[] {3}));
	}

}
