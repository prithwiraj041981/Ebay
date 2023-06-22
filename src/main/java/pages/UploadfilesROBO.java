package pages;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadfilesROBO {
	public static WebDriver driver=null;
	final static long TIMEOUT = 30;
	private static String filePath ="C:\\Screenshot\\robo.txt";
	
	
	 public static void main(String[] args) throws Exception  {
		 WebDriverManager.chromedriver().setup();


			driver = new ChromeDriver();
			
			driver.get("https://demo.guru99.com/test/upload/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
			WebElement browse = driver.findElement(By.xpath("//div[contains(@id,'file_wraper0')]"));
			browse.click();
			Thread.sleep(2000);
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
