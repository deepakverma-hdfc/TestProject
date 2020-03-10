package listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listners.TestNGListners.class)
public class TestNGLIstnersDemo {
	
	@Test
	public void Test1() {
		
		System.out.println("I am inside Test1");
	}
	
	@Test
	public void Test2() {
		
		System.out.println("I am inside Test2");
		Assert.assertTrue(false);
	}
	
	@Test
	public void Test3() {
		
		System.out.println("I am inside Test3");
	}

}
