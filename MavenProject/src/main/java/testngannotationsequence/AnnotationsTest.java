package testngannotationsequence;

import org.testng.annotations.*;

public class AnnotationsTest {

	@BeforeClass
	public void beforeClass()
	{
		System.out.println("From BeforeClass annotation test in AnnotationsTest class");
	}

	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("From BeforeMethod annotation in AnnotationsTest");
	}

	@Test
	public void first ()
	{
		System.out.println("From first Test annotated in AnnotationsTest");
	}

	@AfterTest
	public void afterTest()
	{
		System.out.println("From AfterTest annotation in AnnotationsTest class");
	}

	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("From AfterMethod annotation in AnnotationsTest");
	}

	@AfterClass
	public void afterClass()
	{
		System.out.println("From AfterClass annotation test in AnnotationsTest class");
	}

	@AfterSuite
	public void afterSuite()
	{
		System.out.println("From AfterSuite annotation in AnnotationsTest class");
	}

}
