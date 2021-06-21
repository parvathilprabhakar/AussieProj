package smokeTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.BankHomePage;
import pages.BankLogin;
import pages.NewToursLogin;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.ReadPropFile;

public class TC_LoginTest extends BaseClass {
	
	WebDriver driver;
	ExcelUtility x = new ExcelUtility("Login");
	
	NewToursLogin newToursLogin;
	BankHomePage homePage;
	BankLogin bankLogin;
	

	@Test(enabled = true)
	public void checkLogin() throws IOException {
		driver = getDriver();
		newToursLogin = new NewToursLogin(driver);
		
		driver.navigate().to("http://demo.guru99.com/test/newtours/");
		newToursLogin.loginToApplication(prop.getPropData().getProperty("UserName"),prop.getPropData().getProperty("PassWord"));
		newToursLogin.checkSuccessfulLogin(prop.getPropData().getProperty("ExpectedTitle"));
	}

	@Test(enabled = true)
	public void homePageValidation() throws Exception {
		driver = getDriver();
		newToursLogin = new NewToursLogin(driver);
		homePage = new BankHomePage(driver);
		
		driver.get("http://demo.guru99.com/V4/");
		bankLogin = new BankLogin(driver);
		Assert.assertTrue(bankLogin.getLoginTitle().toLowerCase().contains("guru99 bank"));
		bankLogin.loginToApplication(x.readData("Username"), x.readData("Password"));

		Assert.assertTrue(homePage.getBankHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
	}

}
