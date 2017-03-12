package lab1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.SortingFocusTraversalPolicy;

public class testA {
	triangle tri;
	String result;
	String triA = "equilateral triangle";
	String triB = "isosceles triangle";
	String triC = "scalene triangle";
	String triD = "Not a triangle";
	@Before
	public void setUp(){
		tri = new triangle();
	}
	
	@Test
	public void testEquilateral(){
		result = tri.cal(1,1,1);
		assertEquals(triA, result);
	}
	
	@Test
	public void testIsosceles(){
		result = tri.cal(6,5,6);
		assertEquals(triB, result);
	}	@Test
	public void testScalene(){
		result = tri.cal(3,4,5);
		assertEquals(triC, result);
	}	@Test
	public void testNot(){
		result = tri.cal(1,1,4);
		assertEquals(triD, result);
	}
    
}

