package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class downloadfiles {
	public static WebDriver driver=null;
	final static long TIMEOUT = 30;
	public static String downloadPath="C:\\Users\\Welcome\\Downloads";
	public static String fileName="LibreOffice_7.5.3_Win_x86-64.msi";
	 public static void main(String[] args) throws Exception  {
		 WebDriverManager.chromedriver().setup();
		 
		 
		 ChromeOptions options = new ChromeOptions();
		 Thread.sleep(2000);
			Map<String, Object> prefs = new HashMap<String, Object>();
			Thread.sleep(2000);
			prefs.put("safebrowsing.enabled", true);
			prefs.put("profile.default_content_settings.popups", 0);
			Thread.sleep(7000);
			options.setExperimentalOption("prefs", prefs);
			
			
		 
		 Thread.sleep(2000);

		 driver = new ChromeDriver(options);
		 Thread.sleep(2000);
			//driver = new ChromeDriver();
			
			driver.get("https://sourceforge.net/projects/libreoffice/");
			Thread.sleep(2000);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
			
			 WebElement downloadButton = driver.findElement(By.cssSelector("a.button.download.big-text.green"));
			 Thread.sleep(7000);
		        downloadButton.click();
		        Thread.sleep(7000);
		        fileDownload();
		        Thread.sleep(60000);
		        isFileDownloaded(downloadPath,fileName);
		 
	 }
	 public static void fileDownload() throws Exception {
		 Robot robot = new Robot(); 
		 Thread.sleep(7000);
		 robot.keyPress(KeyEvent.VK_TAB);
		 Thread.sleep(7000);
		 		robot.keyRelease(KeyEvent.VK_TAB);
		 		 Thread.sleep(7000);
		 		robot.keyPress(KeyEvent.VK_ENTER);
		 		 Thread.sleep(7000);
		 		robot.keyRelease(KeyEvent.VK_ENTER);  

		     }
	 
	 public static void isFileDownloaded(String downloadPath, String fileName) {
		  File dir = new File(downloadPath);
		  File[] dirContents = dir.listFiles();

		  for (int i = 0; i < dirContents.length; i++) {
			  //System.out.println("Files"+dirContents.length);
			  //System.out.println("Files name"+dirContents[i].getName());
		      if (dirContents[i].getName().equals(fileName)) {
		          // File has been found, it can now be deleted:
		         // dirContents[i].delete();
		    	  System.out.println("File is downloaded successfully");
		    	  dirContents[i].delete();
		      }
		      
		          }
		      
		  }
}
