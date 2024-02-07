package stepdefinations;

import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.commonUtils;


public class Login {
	WebDriver driver;
	private LoginPage loginpage;
	private AccountPage accountpage;
	private commonUtils commonutlis;
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		
		driver = Driverfactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.ClickonMyAccountOption();
		loginpage = homepage.ClickOnLoginOption();
		
	    }

	@When("^User enters valid EmailAddress (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String validEmailtext) {
		loginpage.EnterEmailAddress(validEmailtext);
		
	   }

	@And("^User enters vaild Password (.+) into password field$")
	public void user_enters_vaild_password_into_password_field(String validPasswordext) {
		loginpage.EnterPassword(validPasswordext);
	    }

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		accountpage = loginpage.ClickOnLoginButton();
	    }

	@Then("user should successfully logged in")
	public void user_should_successfully_logged_in() {
		
		Assert.assertTrue(accountpage.displayEdityourAccountinfo());
	    }

	
	@When("User enters invalid EmailAddress into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		commonutlis = new commonUtils();
		loginpage.EnterEmailAddress(commonutlis.getEmailtimestamp());
	}

	@And("User enters invaild Password {string} into password field")
	public void user_enters_invaild_password_into_password_field(String invalidPasswordtext) {
		loginpage.EnterPassword(invalidPasswordtext);
		
	}

	@Then("user should get a warning message about credentails mismatch")
	public void user_should_get_a_warning_message_about_credentails_mismatch() {
		Assert.assertTrue(loginpage.getWarningmessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	  }

	@When("User dont enters EmailAddress into email field")
	public void user_dont_enters_email_address_into_email_field() {
		
		loginpage.EnterEmailAddress("");
		
	  }

	@And("User dont enters Password into password field")
	public void user_dont_enters_password_into_password_field() {
		loginpage.EnterPassword(" ");
	    }
	


}
