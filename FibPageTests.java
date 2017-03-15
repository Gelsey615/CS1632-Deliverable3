import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
public class FibPageTests {
	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for each test
	@Before
	public void setUp() throws Exception {
		driver.get("https://cs1632ex.herokuapp.com/");
	}
	
	// Given that I am on the home page
	// When I click link to Fibonacci page
	// Then I should be sent to the correct page.
	@Test
	public void testLinkToFibPage() throws Exception {
	    driver.findElement(By.linkText("Fibonacci")).click();
	    assertEquals("Enter number to calculate Fibonacci of:", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	// Given that I am on the home page
	// When I click link to Fibonacci page. 
	// Then I should see that the new page has all required links
	@Test
	public void testFibPageHeaderLinks() throws Exception {
	    driver.findElement(By.linkText("Fibonacci")).click();
	    try{
		    driver.findElement(By.linkText("CS1632 D3 Home"));
			driver.findElement(By.linkText("Factorial"));
			driver.findElement(By.linkText("Fibonacci"));
			driver.findElement(By.linkText("Hello"));
			driver.findElement(By.linkText("Cathedral Pics"));
		} catch (NoSuchElementException nseex) {
			fail();
	    }
	}
	 
	// Given that I am on the home page
	// When I click link to Fibonacci page. 
	// And I input 5 for calculation
	// Then I should see "Fibonacci of 5 is 8!" as result.
	@Test
	public void testFibWithPositiveNumInRange() throws Exception {
	    driver.findElement(By.linkText("Fibonacci")).click();
	    driver.findElement(By.id("tb1")).clear();
	    driver.findElement(By.id("tb1")).sendKeys("5");
	    driver.findElement(By.id("sub")).click();
	    assertEquals("Fibonacci of 5 is 8!", driver.findElement(By.cssSelector("h2")).getText());
	}
	 
	// Given that I am on the home page
	// When I click link to Fibonacci page. 
	// And I input 100 for calculation
	// Then I should see correct result instead of "Fibonacci of 100 is 1!" .
	@Test
	public void testFibWithPositiveEdgeCase() throws Exception {
	    driver.findElement(By.linkText("Fibonacci")).click();
	    driver.findElement(By.id("tb1")).clear();
	    driver.findElement(By.id("tb1")).sendKeys("100");
	    driver.findElement(By.id("sub")).click();
	    assertNotEquals("Fibonacci of 100 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	// Given that I am on the home page
	// When I click link to Fibonacci page. 
	// And I input -101 for calculation
	// Then I should see "Fibonacci of -101 is 1!" as result. 
	@Test
	public void testFibWithNegativeNumber() throws Exception {
	    driver.findElement(By.linkText("Fibonacci")).click();
	    driver.findElement(By.id("tb1")).clear();
	    driver.findElement(By.id("tb1")).sendKeys("-101");
	    driver.findElement(By.id("sub")).click();
	    assertEquals("Fibonacci of -101 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	// Given that I am on the home page
	// When I click link to Fibonacci page. 
	// And I input 10.5 for calculation
	// Then I should see "Fibonacci of 10.5 is 1!" as result. 
	@Test
	public void testFibWithNonIntegerInput() throws Exception {
	    driver.findElement(By.linkText("Fibonacci")).click();
	    driver.findElement(By.id("tb1")).clear();
	    driver.findElement(By.id("tb1")).sendKeys("10.5");
	    driver.findElement(By.id("sub")).click();
	    try{
	    	assertEquals("Fibonacci of 10.5 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	    }catch(NoSuchElementException nseex){
	    	fail();
	    }    
	}
	 
}