import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
public class HelloPageTests {
	static WebDriver driver = new HtmlUnitDriver();
	private String baseUrl = "https://cs1632ex.herokuapp.com/"; 
	// Start at the home page for each test
	@Before
	public void setUp() throws Exception {
		driver.get("https://cs1632ex.herokuapp.com/");
	}
	
	// Given that I am on the home page
	// When I click link to Hello page without trailing values
	// Then I should see that "Hello CS1632, from Prof. Laboon!" is displayed.
    @Test
	public void testHelloWithNoTrailingValues() throws Exception {
	    driver.get(baseUrl + "/hello");
	    assertEquals("Hello CS1632, from Prof. Laboon!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
    // Given that I am on the home page
 	// When I click link to Hello page without trailing values
 	// Then I should see that it has all required links
	@Test
	public void testHelloPageHeaderLinks() throws Exception {
	    driver.get(baseUrl + "/hello");
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
	// When I click link to Hello page with 3.1415926 as trailing values
	// Then I should see that "Hello CS1632, from 3.1415926!" is displayed.
	@Test
	public void testHelloWithNumTrailing() throws Exception {
	    driver.get(baseUrl + "/hello/3.1415926");
	    assertEquals("Hello CS1632, from 3.1415926!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	// Given that I am on the home page
	// When I click link to Hello page with Timmy as trailing values
	// Then I should see that "Hello CS1632, from Timmy!" is displayed.
	@Test
	public void testHelloWithStringTrailing() throws Exception {
	    driver.get(baseUrl + "/hello/Timmy");
	    assertEquals("Hello CS1632, from Timmy!", driver.findElement(By.cssSelector("h2")).getText());
	}
}