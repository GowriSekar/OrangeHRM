package com.orangehrm.TestCases;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.orangehrm.PageObjects.HomePage;
import com.orangehrm.PageObjects.LoginPage;
import com.orangehrm.Utilites.XLUtils;
public class TestLoginPage extends BaseClass
{
	
	@Test(dataProvider="LoginData")
	public void loginTest(String username,String password) throws IOException, InterruptedException 
	{
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		
		lp.setUserName(username);
		Thread.sleep(2000);
		
		lp.setPassword(password);	
		Thread.sleep(2000);
		
		lp.clickLoginButton();
		Thread.sleep(2000);
		
		String actualWelcomePageTitle=hp.getHomePageTitle();
		String expectedWelcomePageTitle=readconfig.getWelcomePageTitle();
		
		assertEquals(actualWelcomePageTitle, expectedWelcomePageTitle,"Welcome Page Title mismatching - Check the Username and Password");
		
		hp.clickWelcomeProfile();
		Thread.sleep(2000);
		
		hp.clickLogoutButton();
		Thread.sleep(2000);
	}

	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/TestData\\LoginTestData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
		return logindata;
	}
}
