package lv2;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Before;
import org.junit.jupiter.api.Test;

public class TilingTest {
	
	private Tiling tiling = new Tiling();
	
	/*
	@Before
	public void setup() {
		tiling = new Tiling();
	}
	*/
	
	@Test
	public void combTest01() {
		assertEquals(1, tiling.comb(6, 0));
		assertEquals(6, tiling.comb(6, 1));
		assertEquals(15, tiling.comb(6, 2));
		assertEquals(20, tiling.comb(6, 3));
		assertEquals(15, tiling.comb(6, 4));
		assertEquals(6, tiling.comb(6, 5));
		assertEquals(1, tiling.comb(6, 6));
	}

}
