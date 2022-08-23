package lv1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegretionTest {

	private CheckCharacter cc;
	
	@BeforeEach
	public void setup() {
		cc = new CheckCharacter();
	}
	
	@Test
	void test() {
		assertEquals("TCMA", cc.solution(new String[] {"AN", "CF", "MJ", "RT", "NA"}, new int[] {5, 3, 2, 7, 5}));
		assertEquals("RCJA", cc.solution(new String[] {"TR", "RT", "TR"}, new int[] {7, 1, 3}));
	}

}
