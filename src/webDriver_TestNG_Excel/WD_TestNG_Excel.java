package webDriver_TestNG_Excel;

//Excel
import java.io.FileInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class WD_TestNG_Excel {
	WebDriver driver;

	
	@BeforeClass
	public void openApplication() throws Exception{ 
	
		
		System.setProperty("webdriver.chrome.driver","E:\\Software\\Webdrivers\\chromedriver.exe");
		System.out.println("Application Open");
		Reporter.log("Open Application");
		Thread.sleep(3000);
		driver =  new ChromeDriver();
	}
	
	@AfterClass
	public void closeAllpication() {
		driver.close();
		Reporter.log("Close Application");
	}
	
	@Test
	public void TC_001() throws Exception{
		// Excel
		FileInputStream file = new FileInputStream("E:\\ExcelData\\XLS\\MyData.xls");
		Workbook wb = Workbook.getWorkbook(file);
		
		Sheet st = wb.getSheet("Login");
		
		String un = st.getCell(0,1).getContents();
		Reporter.log(un);
		String pw = st.getCell(1,3).getContents();
		Reporter.log(pw);
		driver.get("http://127.0.0.1/orangehrm-2.6/login.php");
		System.out.println("Login Succssefull");
		Reporter.log("Login Successfully");
		driver.findElement(By.name("txtUserName")).sendKeys(un);
		driver.findElement(By.name("txtPassword")).sendKeys(pw);
		Thread.sleep(3000);
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		Reporter.log(driver.getTitle());
		driver.findElement(By.linkText("Logout")).click();
		
		
	}
}
