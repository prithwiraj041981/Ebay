package pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class uploadanotherfile {
	public static WebDriver driver=null;
	final static long TIMEOUT = 30;
	private static String filePath ="C:\\Screenshot\\robo.txt";
	public static void main(String[] args) throws Exception  {
		 WebDriverManager.chromedriver().setup();


			driver = new ChromeDriver();
			
			driver.get("https://www.grammarly.com/plagiarism-checker");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
			JavascriptExecutor js = (JavascriptExecutor)driver; // Scroll operation using Js Executor
		    js.executeScript("window.scrollBy(0,200)"); // Scroll Down(+ve) upto browse option
		    Thread.sleep(2000);
		    WebElement browse = driver.findElement(By.xpath("//*[@id=\"file-upload-form\"]/button/span/span[2]"));
		     // using linkText, to click on browse element 
		    browse.click(); // Click on browse option on the webpage
		    Thread.sleep(2000); // suspending execution for specified time period
		 
		    // creating object of Robot class
		    Robot rb = new Robot();
		 
		    // copying File path to Clipboard
		    StringSelection str = new StringSelection(filePath);
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 
		     // press Contol+V for pasting
		     rb.keyPress(KeyEvent.VK_CONTROL);
		     rb.keyPress(KeyEvent.VK_V);
		 
		    // release Contol+V for pasting
		    rb.keyRelease(KeyEvent.VK_CONTROL);
		    rb.keyRelease(KeyEvent.VK_V);
		 
		    // for pressing and releasing Enter
		    rb.keyPress(KeyEvent.VK_ENTER);
		    rb.keyRelease(KeyEvent.VK_ENTER);
	}
}
