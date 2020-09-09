package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	WebDriver driver;
	public String username = "admin";
	public String password = "admin123";
	WebDriverWait wait;
	public int WebDriverWaitTimeout = 300;

	public WebDriver setupBrowser() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\ChromeDriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("disable-gpu");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver, 100);
		wait = new WebDriverWait(driver, WebDriverWaitTimeout);

		return driver;

	}

	public void VerifyLogin() {

		String homepage_actual = wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//*[@id='dashboard-navbar']/nav/div/ul[1]/li")))
				.getText();
		System.out.println(homepage_actual);

		String homepage_exp = "Dashboard";

		if (homepage_actual.equals(homepage_exp)) {
			System.out.println("Login successfull and redirected to Home page");
		} else {
			System.out.println("Login failed or homepage redirection not verified");
		}
	}

}
