package lv2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TilingTest {
	
	private Tiling tiling;
	
	
	@BeforeEach
	public void setup() {
		tiling = new Tiling();
	}
	
	
	
	@Test
	public void test01() {
		assertEquals(3, tiling.solution(2));
	}
	
	@Test
	public void test02() {
		assertEquals(11, tiling.solution(4));
	}
	
	@Test
	public void test03() {
		assertEquals(41, tiling.solution(6));
	}
	
	@Test
	public void test04() {
		assertEquals(153, tiling.solution(8));
	}
	
	@Test
	public void test05() {
		assertEquals(571, tiling.solution(10));
	}
	
	@Test
	public void test06() {
		assertEquals(2131, tiling.solution(12));
	}
	
	@Test
	public void test07() {
		assertEquals(7953, tiling.solution(14));
	}
	
	
	@Test
	public void twoMaxTest01() {
		assertEquals(658712818, tiling.solution(5000));
	}
	
}
