package in.malkani.junit.first;

import static org.junit.Assert.*;
import org.junit.Test;

public class MyClassTest {

	@Test
	public void testDivide() {
		MyClass tester = new MyClass();
		assertEquals("Result", 2, tester.testDivide(10, 5));
		//fail("Not yet implemented");
	}
	
}
