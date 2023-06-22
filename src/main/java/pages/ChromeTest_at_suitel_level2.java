package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeTest_at_suitel_level2 {
	
	public static WebDriver driver=null;
	@BeforeTest
	public void beforeTest() throws Exception {
		System.out.println("Before Test Thread Number Is " + Thread.currentThread().getId());
		DesiredCapabilities dc = new DesiredCapabilities();
		Map<String, Object> edgeOptions = new HashMap<>();
		edgeOptions.put("args", ImmutableList.of("-inprivate"));
		dc.setCapability("ms:edgeOptions", edgeOptions);
    	WebDriverManager.chromedriver().setup();
    	Thread.sleep(2000);


		driver = new ChromeDriver(dc);
		Thread.sleep(2000);
	}

       @Test
 	public void ChromeTestMethod() throws Exception
 	{ 

	  //Initialize the chrome driver
	 System.out.println("The thread ID for Chrome Test is "+ Thread.currentThread().getId());
	 //System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	 driver.get("https://www.google.com");
		Thread.sleep(2000);
		WebElement searchText = driver.findElement(By.name("q"));
		Thread.sleep(2000);
		searchText.sendKeys("india");
		Thread.sleep(2000);
 
      }
 
     @AfterTest
     public void afterTest() {
	 System.out.println("After Test Thread Number Is " + Thread.currentThread().getId());
	 driver.close();
    }
 }


