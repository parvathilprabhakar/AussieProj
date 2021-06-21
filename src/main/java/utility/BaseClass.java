package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

/*
 * BaseClass is inherited by the TestNG class in src/test/java
 *
 */
public class BaseClass {
	private WebDriver driver;
	public ReadPropFile prop;
	
	@BeforeClass
	public void initializeDriver() {
		String path = System.getProperty("user.dir");// making reference to the current directory
		System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path + "\\Utils\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.navigate().to("http://demo.guru99.com/test/newtours/");
		
		prop = new ReadPropFile();
	}

	@AfterClass
	public void closeDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

}
