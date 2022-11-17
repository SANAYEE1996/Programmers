package lv1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lv1.NumberFriend;

class NumberFriendTest {
	
	private NumberFriend n;
	
	@BeforeEach
	public void setup() {
		n = new NumberFriend();
	}
	
	@Test
	void test() {
		assertEquals("-1",n.solution("100", "2345"));
		assertEquals("0",n.solution("100", "203045"));
		assertEquals("10",n.solution("100", "123450"));
		assertEquals("321",n.solution("12321", "42531"));
		assertEquals("552",n.solution("5525", "1255"));
	}

}
