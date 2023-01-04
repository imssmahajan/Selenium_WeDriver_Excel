package webDriver_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Wd_TestNG {
	
	
	WebDriver driver;
	
	@BeforeClass
	public void openApplication() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Webdrivers\\chromedriver.exe");
		Reporter.log("Open Application");
		driver = new ChromeDriver();
	}
	@AfterClass
	public void closeApplication() {
		driver.close();
		Reporter.log("Close Application");
	}
	
	@Test
	public void TC_001() {
		
		/*Test Steps
				1. Open Application
				2. Login Into Application
				3. Logout Application
			 	4. Close Application
		*/
		driver.navigate().to("http://127.0.0.1/orangehrm-2.6/login.php");
		Reporter.log("Login Successfully");  // TestNG: HTML Report
		
		driver.findElement(By.name("txtUserName")).sendKeys("nareshit");
		driver.findElement(By.name("txtPassword")).sendKeys("nareshit");
		driver.findElement(By.name("Submit")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@Test
	public void TC_002() {

		/*Test Steps
		 		1. Open Application
		 		2. Login Into Application
		 		3. Click on Add Button
		 		4. Enter Employee FirstName & LastName
		 		5. Click on Save Button
		 		6. Click on Logout Button
		 		7. Close Application	
		 */
		
		
	}
}
