package com.orangehrm.PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class HomePage 
{
	WebDriver localDriver;
	
	public HomePage(WebDriver remoteDriver) 
	{
		localDriver=remoteDriver;
		PageFactory.initElements(localDriver, this);
	}
	
	@FindBy(how=How.XPATH, using= "//*[@id=\"welcome\"]")
	WebElement welcomeProfile;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"welcome-menu\"]/ul/li[2]/a")
	WebElement logout;
	
	public void clickWelcomeProfile()
	{
		welcomeProfile.click();
	}
	
	public String getHomePageTitle()
	{
		String homePageTitle=localDriver.getTitle();
		return homePageTitle;
	}
	
	public void clickLogoutButton()
	{
		logout.click();
	}
}
