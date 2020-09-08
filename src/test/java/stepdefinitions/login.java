package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class login {

	WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Given("^Open URL$")
	public void open_URL() throws Throwable {
		
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
	}

	@When("^user logged in using username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_logged_in_using_username_as_and_password_as(String username, String password) throws Throwable {
		driver.findElement(By.xpath("//*[@id='txtUsername']")).clear();
		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[contains(@name,'txtPassword')]")).clear();
		driver.findElement(By.xpath("//input[contains(@name,'txtPassword')]")).sendKeys(password);
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Then("^homepage should display$")
	public void homepage_should_display() throws Throwable {

	}

}
