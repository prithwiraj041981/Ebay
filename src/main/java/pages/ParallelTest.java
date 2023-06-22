package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTest {
	public static WebDriver driver=null;
        @SuppressWarnings("deprecation")
		@Test
        public void EDGETest() throws InterruptedException {	 
            //Initializing the firefox driver (Gecko)
        	DesiredCapabilities dc = new DesiredCapabilities();
			Map<String, Object> edgeOptions = new HashMap<>();
			edgeOptions.put("args", ImmutableList.of("-inprivate"));
			dc.setCapability("ms:edgeOptions", edgeOptions);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(dc);
			

			Thread.sleep(2000);
			driver.get("https://www.google.com"); 
			Thread.sleep(2000);
			WebElement searchText = driver.findElement(By.name("q"));
			Thread.sleep(2000);
			searchText.sendKeys("india");
			Thread.sleep(2000);
			searchText.clear();
			Thread.sleep(2000);
	    driver.close();
         }
 
        @Test
 	public void ChromeTest() throws InterruptedException
 	{ 
	  //Initialize the chrome driver
        	DesiredCapabilities dc = new DesiredCapabilities();
			Map<String, Object> edgeOptions = new HashMap<>();
			edgeOptions.put("args", ImmutableList.of("-inprivate"));
			dc.setCapability("ms:edgeOptions", edgeOptions);
        	WebDriverManager.chromedriver().setup();
        	Thread.sleep(2000);


			driver = new ChromeDriver(dc);
			Thread.sleep(2000);

			driver.get("https://www.google.com");
			Thread.sleep(2000);
			WebElement searchText = driver.findElement(By.name("q"));
			Thread.sleep(2000);
			searchText.sendKeys("india");
			Thread.sleep(2000);
			searchText.clear();
			Thread.sleep(2000);
			 driver.close();
 	}
}
