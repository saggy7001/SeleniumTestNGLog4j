package FirstPackage;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.Assertion;
import org.apache.log4j.Logger;

public class FirstTestNGFile {
	public WebDriver driver;
	Logger log = Logger.getLogger("FirstTestNGFile");	
	  
	@Test(priority =3)	 
	  public void OpenSoftware() {
		  
		  log.debug("@Test:- Test OpenSoftware");
				  
		  driver.findElement(By.xpath("html/body/div[5]/div[1]/div[2]/div[1]/a/img")).click();
		  log.debug("Go to Home");
		  	 
		  driver.findElement(By.linkText("Computers")).click();
		  new Actions(driver).moveToElement(driver.findElement(By.linkText("Software"))).click().perform();
		  log.debug("Click on Computers -> Software");
		  
		  driver.findElement(By.xpath("html/body/div[5]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div/div[3]/div/div[1]/a/img")).click();
		  log.debug("Open Windows 8 Pro Software item");
	  }
	  
	@Test(priority =2)	 
	public void CellPhones() {
					
		  log.debug("@Test:- Test cell-phones");
		  	 	 
		  driver.findElement(By.xpath("html/body/div[5]/div[1]/div[2]/div[1]/a/img")).click();
		  log.debug("Go to Home");
		  
		  driver.findElement(By.linkText("Electronics")).click();
		  new Actions(driver).moveToElement(driver.findElement(By.linkText("Cell phones"))).click().perform();
		  log.debug("Click on Electronics -> Cell phones");
		  
		  driver.findElement(By.xpath("html/body/div[5]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div/div[3]/div/div[1]/a/img")).click();
		  log.debug("Open Mobile Nokia Lumia 1020");
		           
	  }
	  
	@Test (priority =1)
	
	public void adidasShoes() {
		  
		  log.debug("@Test:- Test adidasShoes");
		  	 	 
		  driver.findElement(By.xpath("html/body/div[5]/div[1]/div[2]/div[1]/a/img")).click();
		  log.debug("Go to Home");
		  
		  driver.findElement(By.linkText("Apparel")).click();
		  new Actions(driver).moveToElement(driver.findElement(By.linkText("Shoes"))).click().perform();
		  log.debug("Click on Apparel -> Shoes");
		  
		  driver.findElement(By.xpath("html/body/div[5]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[1]/a/img")).click();
		  log.debug("Open adidas Consortium Campus 80s Running Shoes");
		           
	  }
	 
	
	  @BeforeClass
	 public void beforeClass() {
		  
		  log.debug("@BeforeClass");
		  driver = new FirefoxDriver();
	      log.debug("new FirefoxDriver()");
	 
	      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
	 
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      //Launch the Online Store Website	 	    
	      driver.get("http://demo.nopcommerce.com/");	    
	      log.debug("Open 'http://demo.nopcommerce.com/' ");	      	 
	 }
	 
	 @AfterClass
	 public void afterClass() {
		 log.debug(" @AfterClass");
		 //Close the driver	 		  
		  driver.quit();
		  log.debug("Close Firefox");
	 }
	 
	@BeforeMethod	 
	  public void beforeMethod() {
	 
		  // Create a new instance of the Firefox driver	 
		  log.debug("@BeforeTest");
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  
		  driver.navigate().to("http://demo.nopcommerce.com/");	      		  
		  
		  /*WebDriverWait wait = new WebDriverWait(driver, 10);

		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("html/body/div[5]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")));
		  
		  element.click();
*/		  
		  driver.findElement(By.xpath("html/body/div[5]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
		  
	      // Find the element that's ID attribute is 'account'(My Account)	 	 	      
	      log.debug("driver.findElement(By.xpath('html/body/div[5]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a')).click();");	 	  
	 
	      // Enter Username on the element found by above desc.
	 
	      driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys("test123@gmail.com");
	      log.debug("driver.findElement(By.xpath('.//*[@id='Email']')).sendKeys('test123@gmail.com');");
	 
	      // Find the element that's ID attribute is 'pwd' (Password
	 
	      // Enter Password on the element found by the above desc.
	 
	      driver.findElement(By.xpath(".//*[@id='Password']")).sendKeys("test@123");
	      log.debug("driver.findElement(By.xpath('.//*[@id='Password']')).sendKeys('test@123');");
	 
	      // Now submit the form. WebDriver will find the form for us from the element
	 
	      driver.findElement(By.xpath("html/body/div[5]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input")).click();
	      log.debug("Click on Login Button");
	      
	      log.debug("Check for login status");
	      	      
	      boolean present = driver.findElements(By.xpath("html/body/div[5]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[2]/div/ul/li")).size() > 0;;
	      
	      if(!present)
	      {
	    	// Print a Log In message to the screen
	    		 
		      System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		      log.debug("Login Successfully, User is Avilable");
		 
		      // Find the element that's ID attribute is 'account_logout' (Log Out)
		 
		      driver.findElement(By.xpath("html/body/div[5]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
		      log.debug("driver.findElement(By.xpath('html/body/div[5]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a'));");	 
		 
	      }
	      else
	      {	    	
		      
	    	  log.debug("Login status: Failed, Creating New User");
	    	  
	    	  driver.findElement(By.xpath("html/body/div[5]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
	    	  log.debug("Click On register");
	    	  
	    	  driver.findElement(By.xpath(".//*[@id='FirstName']")).sendKeys("test");
	    	  log.debug("Enter First Name");
	    	  
	    	  driver.findElement(By.xpath(".//*[@id='LastName']")).sendKeys("test");
	    	  log.debug("Enter Last Name");

	    	  driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys("test123@gmail.com");
	    	  log.debug("Enter Email");

	    	  driver.findElement(By.xpath(".//*[@id='Password']")).sendKeys("test@123");
	    	  log.debug("Enter Password");
	    	  
	    	  driver.findElement(By.xpath(".//*[@id='ConfirmPassword']")).sendKeys("test@123");
	    	  log.debug("Confirm Password");
	    	  
	    	  driver.findElement(By.xpath(".//*[@id='register-button']")).click();
	    	  log.debug("Click On register Button Password");
	    	  
	    	  driver.findElement(By.xpath("html/body/div[5]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
			  log.debug("Go to user profile");
	    	  
	    	  boolean is_exist = driver.findElements(By.xpath("html/body/div[5]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).size() > 0;
	    	  Assert.assertEquals(true,is_exist);
	      }	 
	      
	  }
	 
	  @AfterMethod	 
	  public void afterMethod() {
	 
		  log.debug("@AfterTest");	
		  //Logout User
		  driver.findElement(By.xpath("html/body/div[5]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
		  log.debug("Go to user profile");	
		  
		  driver.findElement(By.xpath("html/body/div[5]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
		  log.debug("Click on LogOut");			  		
	 
	  }

}
