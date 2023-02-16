package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.ETTPage;
import pages.LoginPage;

public class ValidLogin extends BaseTest {
	
	@Test(priority=1)
	
	public void testValidLogin()
	{
		//1.enter valid un
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName("admin");
		
		//2.enter valid pw
		loginPage.setPassword("manager");
		
		//click on login
		loginPage.clickLoginButton();
		
		//verify home page is displayed
		ETTPage ettPage=new ETTPage(driver);
		boolean result=ettPage.verifyHomePageIsDisplayed(wait);
		//true- home page pass,, false- no home page fail
		Assert.assertEquals(result, true);
		
		
		
	}

}
