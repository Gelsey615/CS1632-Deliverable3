import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
public class FactorialPageTests {
	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for each test
	@Before
	public void setUp() throws Exception {
		driver.get("https://cs1632ex.herokuapp.com/");
	}
	
	// Given that I am on the home page
	// When I click link to Factorial page
	// Then I should be sent to the correct page.
	@Test
	public void testLinkToFactorialPage() throws Exception {
	   driver.findElement(By.linkText("Factorial")).click();
	   assertEquals("Enter number to calculate factorial of:", 
			   driver.findElement(By.cssSelector("h2")).getText());
	}
	
	// Given that I am on the home page
	// When I click link to Factorial page. 
	// Then I should see that the new page has all required links
	@Test
	public void testFactorialPageHeaderLinks() throws Exception {
	   driver.findElement(By.linkText("Factorial")).click();
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
	// When I click link to Factorial page. 
	// And I input -1 for calculation
	// Then I should see "Factorial of -1 is 1!" as result.
	@Test
	public void testFactorialWithNegtiveNumber() throws Exception {
	    driver.findElement(By.linkText("Factorial")).click();
	    driver.findElement(By.name("value")).clear();
	    driver.findElement(By.name("value")).sendKeys("-1");
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	    assertEquals("Factorial of -1 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	 }
	 
 	// Given that I am on the home page
	// When I click link to Factorial page. 
	// And I input 5 for calculation
	// Then I should see "Factorial of 5 is 120!" as result.
	 @Test
	 public void testFactorialWithPositiveNumInRange() throws Exception {
	    driver.findElement(By.linkText("Factorial")).click();
	    driver.findElement(By.name("value")).clear();
	    driver.findElement(By.name("value")).sendKeys("5");
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	    assertEquals("Factorial of 5 is 120!", driver.findElement(By.cssSelector("h2")).getText());
	 }

	// Given that I am on the home page
	// When I click link to Factorial page. 
	// And I input 101 for calculation
	// Then I should see "Factorial of 101 is 1!" result.
	 @Test
	 public void testFactorialWithPositiveEdgeCase1() throws Exception {
	    driver.findElement(By.linkText("Factorial")).click();
	    driver.findElement(By.name("value")).clear();
	    driver.findElement(By.name("value")).sendKeys("101");
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	    assertEquals("Factorial of 101 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	 }

	// Given that I am on the home page
	// When I click link to Factorial page. 
	// And I input 100 for calculation
	// Then I should see correct result instead of ""Factorial of 100 is 1!"".
	 @Test
	 public void testFactorialWithPositiveEdgeCase2() throws Exception {
	    driver.findElement(By.linkText("Factorial")).click();
	    driver.findElement(By.name("value")).clear();
	    driver.findElement(By.name("value")).sendKeys("100");
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	    assertNotEquals("Factorial of 100 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	 }
	 
	// Given that I am on the home page
	// When I click link to Factorial page. 
	// And I input A for calculation
	// Then I should see "Factorial of A is 1!" as result.
	 @Test
	 public void testFactorialWithNonIntegerInput() throws Exception {
	    driver.findElement(By.linkText("Factorial")).click();
	    driver.findElement(By.name("value")).clear();
	    driver.findElement(By.name("value")).sendKeys("A");
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	    try{
	    	assertEquals("Factorial of A is 1!", driver.findElement(By.cssSelector("h2")).getText());
	    }catch(NoSuchElementException nseex){
	    	fail();
	    } 
	    
	 }
}

