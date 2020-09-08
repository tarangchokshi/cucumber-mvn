package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class login {

	WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test @Given("^Open URL$")
	public void open_URL() throws Throwable {

	System.out.println("test1......");
	}

	@When("^user logged in using username and password$")
	public void user_logged_in_using_username_and_password() throws Throwable {
		System.out.println("test2......");
	}

	@Then("^homepage should display$")
	public void homepage_should_display() throws Throwable {
		System.out.println("test3......");
	}
}
