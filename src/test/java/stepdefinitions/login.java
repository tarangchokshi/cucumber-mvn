package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class login extends Base {

	WebDriver driver;

	@BeforeSuite
	public void InitializeBrowser() {
		driver = setupBrowser();
	}

	@Test
	public void Login() throws Throwable {
		
		test = extent.createTest("Check Login Functionality");

		
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='txtUsername']")).clear();
		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='txtPassword']")).clear();
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();

		System.out.println("verify now");
		Thread.sleep(3000);

		VerifyLogin();
		test.log(Status.PASS, "Home Page Redirection Successful");

	}

	@AfterSuite
	public void closure() {
		driver.close();
	}
}
