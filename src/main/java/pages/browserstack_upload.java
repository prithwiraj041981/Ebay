package pages;


import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class browserstack_upload {

  public static final String AUTOMATE_USERNAME = "prithwirajbhowmi_d2x3HU";
  public static final String AUTOMATE_KEY = "CHCF8iyjxJYhaw4NS9zz";
  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

  public static void main(String[] args) throws Exception {
	  DesiredCapabilities caps = new DesiredCapabilities();

      // Set your BrowserStack configuration
      caps.setCapability("browser", "Chrome");
      caps.setCapability("browser_version", "latest");
      caps.setCapability("os", "Windows");
      caps.setCapability("os_version", "10");
      caps.setCapability("name", "Sample Test");

    RemoteWebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.setFileDetector(new LocalFileDetector());
    driver.get("http://www.fileconvoy.com/");
    driver.findElement(By.id("upfile_0")).sendKeys("C:\\Screenshot\\capture1.png");
    driver.findElement(By.id("readTermsOfUse")).click();
    driver.findElement(By.name("upload_button")).submit();
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    try {
    	WebDriverWait wait = new WebDriverWait(driver, 5);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("TopMessage")));
    	if(driver.findElementById("TopMessage").getText().contains("successfully uploaded")) {
    		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"File uploaded successfully\"}}");
    	} else {
    		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"File upload failed\"}}");
    	}
    }
    catch(Exception e) {
    	jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"File could not be uploaded in 5 seconds\"}}");
    }
    driver.quit();
  }
}
