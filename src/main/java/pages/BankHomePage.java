package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import utility.BaseClass;
import utility.GenericUtility;

public class BankHomePage extends GenericUtility {

    By homePageUserName = By.xpath("//table//tr[@class='heading3']");
    
    
    public BankHomePage(WebDriver driver) {
    	super(driver);
	}
    
	public String getBankHomePageDashboardUserName(){
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return   getText(homePageUserName); 
	}

}