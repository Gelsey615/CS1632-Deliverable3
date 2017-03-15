import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
public class WelcomePageTests {
	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for each test
	@Before
	public void setUp() throws Exception {
		driver.get("https://cs1632ex.herokuapp.com/");
	}
	
	// Given that I am on the home page
	// Then I should see correct welcome texts
	@Test
	public void testHomepageWelcomeText() throws Exception {
		String text1 = driver.findElement(By.cssSelector("p.lead")).getText();
		assertTrue(text1.contains("Welcome, friend,\nto a land of pure calculation"));
		assertEquals("Used for CS1632 Software Quality Assurance, taught by Bill Laboon", 
				driver.findElement(By.cssSelector("div.row > p.lead")).getText());
	}

	// Given that I am on the home page
	// Then I should see that it contains all required links
	@Test
	public void testHomePageHeaderLinks() {
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
}