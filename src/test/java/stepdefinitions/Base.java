package stepdefinitions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base {
	WebDriver driver;
	public String username = "admin";
	public String password = "admin123";
	WebDriverWait wait;
	public int WebDriverWaitTimeout = 300;
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HHmmss");


	@BeforeSuite
	public void before() throws Throwable {
//		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\ExtentReports\\Automation_Report_" + dateFormat.format(new Date()) + ".html");

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\ExtentReports\\AutomationReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setJS("js-string");
		htmlReporter.config().setProtocol(Protocol.HTTPS);

		htmlReporter.config().setReportName("Tarang | Automation Report");
		htmlReporter.config().setDocumentTitle("Extent-Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);

		htmlReporter.config()
				.setCSS("body > nav > div > a > img { content:url('http://tarangchokshi.in/img/favicon_png.png') }");

	}

	@AfterSuite
	public void extentReportClosure() {
		extent.flush();
	}
	
	public WebDriver setupBrowser() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\ChromeDriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
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
