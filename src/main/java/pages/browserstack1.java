package pages;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.Hashtable;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
class TestClass1 implements Runnable {
    public void run() {
        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
        capsHashtable.put("deviceName", "iPhone 12 Pro");
        capsHashtable.put("osVersion", "14");
        capsHashtable.put("buildName", "browserstack-build-1");
        capsHashtable.put("sessionName", "Thread 1");
        browserstack1 r1 = new browserstack1();
        r1.executeTest(capsHashtable);
    }
}
class TestClass2 implements Runnable {
    public void run() {
        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
        capsHashtable.put("deviceName", "Google Pixel 6 Pro");
        capsHashtable.put("osVersion", "12.0");
        capsHashtable.put("buildName", "browserstack-build-1");
        capsHashtable.put("sessionName", "Thread 2");
        browserstack1 r2 = new browserstack1();
        r2.executeTest(capsHashtable);
    }
}
class TestClass3 implements Runnable {
    public void run() {
        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
        capsHashtable.put("browserName", "safari");
        capsHashtable.put("browserVersion", "14");
        capsHashtable.put("os", "OS X");
        capsHashtable.put("osVersion", "Big Sur");
        capsHashtable.put("buildName", "browserstack-build-1");
        capsHashtable.put("sessionName", "Thread 3");
        browserstack1 r3 = new browserstack1();
        r3.executeTest(capsHashtable);
    }
}
public class browserstack1 {
    public static final String USERNAME = "prithwirajbhowmi_y9duMz";
    public static final String AUTOMATE_KEY = "5j9BzkqpjmmqcztqkUvq";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
    public static void main(String[] args) throws Exception {
        Thread object1 = new Thread(new TestClass1());
        object1.start();
        Thread object2 = new Thread(new TestClass2());
        object2.start();
        Thread object3 = new Thread(new TestClass3());
        object3.start();
    }
    public void executeTest(Hashtable<String, String> capsHashtable) {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("bstack:options", capsHashtable);
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            // Searching for 'BrowserStack' on google.com
            driver.get("https://www.google.com");
            WebElement element = driver.findElement(By.name("q"));
            element.sendKeys("BrowserStack");
            element.submit();
            // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'BrowserStack'
          // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            
            WebDriverWait wait =new WebDriverWait(driver, 5);
            try {
                wait.until(ExpectedConditions.titleContains("BrowserStack"));
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Title matched!\"}}");
            }
            catch(Exception e) {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Title not matched\"}}");
            }
            System.out.println(driver.getTitle());
            driver.quit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
