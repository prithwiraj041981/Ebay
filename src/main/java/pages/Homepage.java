package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class Homepage extends TestBase {
	public static final long TIMEOUT = 30;

	

	public Homepage() {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//li[contains(@class,'hl-cat-nav__js-tab')]/a[contains(text(),'Electronics')]")
	WebElement electronics;
	
	public void HomepageforBuying() throws IOException {
		electronics.click();
		
	}
	
	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("C:\\extentreportscreenshot\\" + System.currentTimeMillis()+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}

}
