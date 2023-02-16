package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pages.LoginPage;

public class InvalidLogin extends BaseTest{
	
	@Test(priority = 2)
	
	public void testInvalidLogin()
	{
		
		        //get the test data from the excel sheet
				String un = Excel.getData("./data/Book1.xlsx","InvalidLogin" ,1 , 0);
				String pw = Excel.getData("./data/Book1.xlsx","InvalidLogin" ,1 , 1);
				
				
		        //1.enter valid un
				LoginPage loginPage=new LoginPage(driver);
				loginPage.setUserName(un);
				
				//2.enter valid pw
				loginPage.setPassword(pw);
				
				//click on login
				loginPage.clickLoginButton();
				
				//verify err msg  is displayed
				boolean result=loginPage.verifyErrormsgIsDisplayed(wait);
				
				Assert.assertEquals(result, true);
	}

}
