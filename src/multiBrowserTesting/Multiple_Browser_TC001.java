package multiBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Multiple_Browser_TC001 {

	WebDriver driver;
	
	@Test(priority=1)
	public void openFireFox() throws Exception{
		
		driver.navigate().to("http://127.0.0.1/orangehrm-2.6/login.php");
		Reporter.log("Open HRMS application FireFox Driver");
		Thread.sleep(3000);
	}
	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(String browser) {	
		
		if(browser.equals("FireFox")) {
			
			System.setProperty("webdriver.gecko.driver", "E:\\Software\\Webdrivers\\firefoxdriver.exe");
			driver = new FirefoxDriver();
			System.out.println();
		}
		else if(browser.equals("Chrome")){
			
			System.setProperty("webdriver.chrome.driver", "E:\\Software\\Webdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	}
	
	@AfterMethod
	public void closeApplication() {
		driver.close();
	}
}
