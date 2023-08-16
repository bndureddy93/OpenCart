package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;
import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import TestBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	@Test(groups= {"Regression","Master"}) //Step8 groups added
	public void test_account_Registration() throws InterruptedException
	{
		logger.debug("application logs......");
		logger.info("***  Starting TC_001_AccountRegistrationTest ***");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();

		logger.info("Clicked on My account link");
		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing customer data");
		regpage.setFirstName(randomeString().toUpperCase());
		
		regpage.setLastName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		
		//regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		Thread.sleep(2000);
		//regpage.setConfirmPassword(password);
		regpage.clicksubscriber();
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail();
		}
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");
	}
	
}
	
	

