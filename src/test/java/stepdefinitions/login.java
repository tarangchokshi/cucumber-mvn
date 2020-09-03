package stepdefinitions;

import cucumber.api.java.en.*;

public class login extends Base {

	@Given("^Open URL$")
	public void open_URL() throws Throwable {
		System.out.println("Demo Test");
		driver = setupBrowser();
	}

	@When("^insert valid credentials$")
	public void insert_valid_credentials() throws Throwable {
		System.out.println("Demo Test");

	}

	@Then("^check result$")
	public void check_result() throws Throwable {
		System.out.println("Demo Test");
		driver.close();
		System.out.println("Browser Closed!!!");
	}

}
