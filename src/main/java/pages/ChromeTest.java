package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeTest {
	public static WebDriver driver=null;
 
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.out.println("Initilizing the Google Chrome Driver");
		WebDriverManager.chromedriver().setup();
    	Thread.sleep(2000);


		driver = new ChromeDriver();
		Thread.sleep(2000);
	}

        @Test
 	public void ChromeTestMethod() throws Exception
 	{ 
	  //Initialize the chrome driver
	 System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getId());
	 driver.get("https://www.google.com");
		Thread.sleep(2000);
		WebElement searchText = driver.findElement(By.name("q"));
		Thread.sleep(2000);
		searchText.sendKeys("india");
		Thread.sleep(2000);
       }
 
       @AfterTest
       public void afterTest() {
	 System.out.println("Closing the browser ");
	 driver.close();
       }
}