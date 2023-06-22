package pages;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReaddatafromXML {
	
	public static WebDriver driver = null;
    
    public static void main(String args[]) throws Exception

    {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.quit();

        System.out.println("First Name is :>"+getXMLData("firstname"));
        System.out.println("Last Name is :>"+getXMLData("lastname"));
        System.out.println("Email  is :>"+getXMLData("email"));


    }

    public static String getXMLData(String datafor)
    {
        String nodevalue = null;
        try{

            String sourceXML = "C://tools//xmldata/readTestData.xml";
            File file = new File(sourceXML);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document document = documentBuilder.parse(file);
            nodevalue =  document.getElementsByTagName(datafor).item(0).getTextContent();
        }

        catch(Exception e)
        {
            nodevalue = null;
        }
        return nodevalue;
    }

}
