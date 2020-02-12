package com.maventestjenkins;

import org.testng.annotations.Test;

public class TestJenkinsMaven {

	@Test
	public void sumNumber() {
		
		int a = 10;
		int b = 20;
		int sum = a+b;
		
		System.out.println("Sum is "+sum);
	}
	
	@Test
	public void mulNumber() {
		
		int a = 10;
		int b = 20;
		int mul = a*b;
		
		System.out.println("Mul is "+mul);
	}

}
