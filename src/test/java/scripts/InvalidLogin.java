package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.ETTPage;
import pages.LoginPage;

public class InvalidLogin extends BaseTest{
	
	@Test(priority = 2)
	
	public void testInvalidLogin()
	{
		        //1.enter valid un
				LoginPage loginPage=new LoginPage(driver);
				loginPage.setUserName("abcd");
				
				//2.enter valid pw
				loginPage.setPassword("xyz");
				
				//click on login
				loginPage.clickLoginButton();
				
				//verify err msg  is displayed
				boolean result=loginPage.verifyErrormsgIsDisplayed(wait);
				
				Assert.assertEquals(result, true);
	}

}
