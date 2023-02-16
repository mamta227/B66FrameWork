package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pages.ETTPage;
import pages.LoginPage;

public class ValidLogin extends BaseTest {
	
	@Test(priority=1)
	
	public void testValidLogin()
	{
		//get the test data from the excel sheet
		String un = Excel.getData("./data/Book1.xlsx","ValidLogin" ,1 , 0);
		String pw = Excel.getData("./data/Book1.xlsx","ValidLogin" ,1 , 1);
		
		//1.enter valid un
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(un);
		
		//2.enter valid pw
		loginPage.setPassword(pw);
		
		//click on login
		loginPage.clickLoginButton();
		
		//verify home page is displayed
		ETTPage ettPage=new ETTPage(driver);
		boolean result=ettPage.verifyHomePageIsDisplayed(wait);
		
		//true- home page pass,, false- no home page fail
		Assert.assertEquals(result, true);
		
		
		
	}

}
