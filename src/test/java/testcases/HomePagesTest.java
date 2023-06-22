package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.TestBase;

import pages.Homepage;

public class HomePagesTest {
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		TestBase tbase= new TestBase();
		tbase.Base_url();
		
	}
	@Test(description="This is login validate")
	public void Validate() throws IOException {
		
		
		Homepage log= new Homepage();	
		log.HomepageforBuying();
		
		
		
		//add content, manage tests etc

		
	}
}
