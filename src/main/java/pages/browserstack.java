package pages;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class browserstack {
	 public static final String USERNAME = "prithwirajbhowmi_d2x3HU";
	    public static final String AUTOMATE_KEY = "CHCF8iyjxJYhaw4NS9zz";
	    public static final String BROWSERSTACK_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	    public static void main(String[] args) {
	        try {
	            DesiredCapabilities caps = new DesiredCapabilities();

	            // Set your BrowserStack configuration
	            caps.setCapability("browser", "Chrome");
	            caps.setCapability("browser_version", "latest");
	            caps.setCapability("os", "Windows");
	            caps.setCapability("os_version", "10");
	            caps.setCapability("name", "Sample Test");

	            WebDriver driver = new RemoteWebDriver(new URL(BROWSERSTACK_URL), caps);

	            // Start your test
	            driver.get("https://www.example.com");
	            System.out.println("Page Title: " + driver.getTitle());

	            // Perform your test actions
	            // ...

	            // End the test
	            driver.quit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
