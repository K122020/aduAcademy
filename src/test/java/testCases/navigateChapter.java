package testCases;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.CommonLibs;
import generics.Constants;
import pages.LoginPage;
import pages.NextPage;
import pages.SignOutPage;

public class navigateChapter extends CommonLibs {
	
	public static int flag=1;
	
	@BeforeTest()
	public void launchBrowser() throws InterruptedException {


		getDriverObject(Constants.browser, Constants.URL);

	}
	
	@BeforeMethod
	public void preTestCase ()
	{
		Reporter.log("Successfully execute the Test"+flag, true);
	}
	
	@Test(priority=1, alwaysRun = true, description="Login to the course")
	public void doLogin() throws InterruptedException
	{
		LoginPage login = new LoginPage();
		login.Lms_Login();
		
	}

	@Test(priority=2, alwaysRun=true, description="Click on next page until last page.")
	public void navNextPage() throws InterruptedException
	{
		NextPage nxtpg = new NextPage();
		nxtpg.Next_Page();
	}
	
	@Test(priority=3, alwaysRun=true, description = "Signout from the application")
	public void logOut()
	{
		SignOutPage logOut = new SignOutPage();
		logOut.Logout();
	}
	
	@AfterMethod()
	public void postTestcase()
	{
		flag++;
	}
	
	@AfterTest()
	public void doQuit()
	{
		driver.quit();
	}
	
	
}
