package testing;

import org.testng.annotations.Test;

public class TestGrouping {

	@Test(groups = {"regression"})
	public void test1() {
		System.out.println("This is Test 1!");
	}
	
	@Test(groups = {"smoke"})
	public void test2() {
		System.out.println("This is Test 2!");
	}
	
	@Test(groups = {"regression","sanity","smoke"})
	public void test3() {
		System.out.println("This is Test 3!");
	}
	
	@Test(groups = {"sanity"})
	public void test4() {
		System.out.println("This is Test 4!");
	}


}
