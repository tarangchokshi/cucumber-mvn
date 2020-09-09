package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login extends Base {

	WebDriver driver;

	@Test
	@Given("^Open URL$")
	public void open_URL() throws Throwable {

		driver = setupBrowser();

		System.out.println("Open URL......");
//		driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");

	}

	@Test
	@When("^user logged in using username and password$")
	public void user_logged_in_using_username_and_password() throws Throwable {
		System.out.println("user logged in using username and password......");
	}

	@Test
	@Then("^homepage should display$")
	public void homepage_should_display() throws Throwable {
		System.out.println("homepage should display......");
	}

	@AfterSuite 
	public void TestClosure(){
		driver.close();
	}
}
