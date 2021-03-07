package com.orangehrm.Utilites;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
public class ReadConfig 
{
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try 
		{
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(fis);
		} 
		catch(Exception e) 
		{
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromedriverpath");
		return chromepath;
	}
	
	public String getEdgeDriverPath()
	{
		String edgepath=pro.getProperty("edgedriverpath");
		return edgepath;
	}
	
	public String getLogInTestDataFilePath() 
	{
		String excelFilePath=pro.getProperty("LoginTestDataPath");
		return excelFilePath;
	}
	
	public String getWelcomePageTitle() 
	{
		String welcomePageTile=pro.getProperty("WelcomePageTitle");
		return welcomePageTile;
	}
}


