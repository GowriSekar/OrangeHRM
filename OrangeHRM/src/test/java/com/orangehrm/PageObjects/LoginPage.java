package com.orangehrm.PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class LoginPage
{
	WebDriver localDriver;
	
	public LoginPage(WebDriver remoteDriver)
	{
		localDriver=remoteDriver;
		PageFactory.initElements(remoteDriver, this);	
	}
	
	//By txtuser=By.xpath("//*[@id=\\\"txtUsername\\\"]");
	
	@FindBy(how=How.XPATH, using="//*[@id=\"txtUsername\"]")
	WebElement txtUserName;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"txtPassword\"]")
	WebElement txtPassword;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"btnLogin\"]")
	WebElement logInButton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"forgotPasswordLink\"]/a")
	WebElement forgetPassword;
	
	public void setUserName(String username)
	{
		txtUserName.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		logInButton.click();
	}
}
