package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lv3.GetItem;

class GetItemTest {
	
	private GetItem gt;
	
	@BeforeEach
	public void setup() {
		gt = new GetItem();
	}

	@Test
	void test() {
		System.out.println(gt.getAllPoint(new int[] {1,1,7,4}));
		System.out.println(gt.getAllPoint(new int[] {3,2,5,5}));
	}

}
