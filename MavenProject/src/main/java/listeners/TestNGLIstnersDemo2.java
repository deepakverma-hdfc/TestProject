package listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listners.TestNGListners.class)
public class TestNGLIstnersDemo2 {
	
	@Test
	public void Test4() {
		
		System.out.println("I am inside Test4");
	}
	
	@Test
	public void Test5() {
		
		System.out.println("I am inside Test5");
		Assert.assertTrue(false);
	}
	
	@Test
	public void Test6() {
		
		System.out.println("I am inside Test6");
	}

}
