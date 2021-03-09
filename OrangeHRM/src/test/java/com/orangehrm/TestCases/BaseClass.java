package com.orangehrm.TestCases;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.orangehrm.Utilites.ReadConfig;
public class BaseClass 
{
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger log;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{			
		log=Logger.getLogger("OrangeHRM");
		PropertyConfigurator.configure("C:\\Users\\GowriS\\git\\OrangeHRM\\OrangeHRM\\log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
			log.info("Chrome Driver Opened");
		}
		else if(br.equals("edgedriver"))
		{
			System.setProperty("webdriver.ie.driver",readconfig. getEdgeDriverPath());
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get(baseURL);
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
