/**
 * class designed to use JUnit and test
 * the LifeUniverse class
 */

import junit.framework.TestCase; 

public class SimpleTest extends TestCase { 

	public SimpleTest(String name) { 
		super(name);
	}

	public void testSimpleTest() {
		LifeUniverse lu = new LifeUniverse();
		int answer = lu.UltimateQuestion();
		assertEquals(42, answer); 
	}
}
      
