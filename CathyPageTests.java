import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
public class CathyPageTests {
	static WebDriver driver = new HtmlUnitDriver();
	// Start at the home page for each test
	@Before
	public void setUp() throws Exception {
		driver.get("https://cs1632ex.herokuapp.com/");
	}
	
	// Given that I am on the home page
	// When I click link to Cathedral Pics page
	// Then I should see the sub heading "Cathedral Pictures".
	@Test
	 public void testLinkToCathyPics() throws Exception {
	    driver.findElement(By.linkText("Cathedral Pics")).click();
	    assertEquals("Cathedral Pictures", driver.findElement(By.cssSelector("h2")).getText());
	 }
	 
	// Given that I am on the home page
	// When I click link to Cathedral Pics page
	// Then I should see that it has all required links.
	 @Test
	 public void testCathyPicsPageHeaderLinks() throws Exception {
	    driver.findElement(By.linkText("Cathedral Pics")).click();
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
	// When I click link to Cathedral Pics page
	// Then I should see three images of Cathedral of Learning.
	 @Test
	 public void testCathyPicsPageImages() throws Exception {
	    driver.findElement(By.linkText("Cathedral Pics")).click();
	    try{
		    driver.findElement(By.cssSelector("img[alt=\"Sunny Cathedral\"]"));
			driver.findElement(By.cssSelector("img[alt=\"Alpenglow Cathedral\"]"));
			driver.findElement(By.cssSelector("img[alt=\"Old Cathedral\"]"));
		} catch (NoSuchElementException nseex) {
			fail();
	    }
	 }
	 
	// Given that I am on the home page
	// When I click link to Cathedral Pics page
	// Then I should see the ordered list for images.
	 @Test
	 public void testCathyPicsPageOrderedList() throws Exception {
	    driver.findElement(By.linkText("Cathedral Pics")).click();
	    try{
		    driver.findElement(By.xpath("//ol/li[1]"));
			driver.findElement(By.xpath("//ol/li[2]"));
			driver.findElement(By.xpath("//ol/li[3]"));
		} catch (NoSuchElementException nseex) {
			fail();
	    }
	 }
}