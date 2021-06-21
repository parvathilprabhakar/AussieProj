package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utility.GenericUtility;

public class BankLogin extends GenericUtility {
	public BankLogin(WebDriver driver) {
		super(driver);
	}

    By userName = By.name("uid");
    By password = By.name("password");
    By titleText =By.className("barone");
    By login = By.name("btnLogin");


	public void loginToApplication(String usrName, String pWord) {
		enterTextbox(userName, usrName);
		enterTextbox(password, pWord);
		click(login);
	}

    public String getLoginTitle(){
        return   getText(titleText);
       }

}
