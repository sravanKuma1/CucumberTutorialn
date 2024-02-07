package stepdefinations;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.common.collect.Maps;

import factory.Driverfactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.commonUtils;


public class Register {
	
	WebDriver driver;
	private RegisterPage registerpage;
	private AccountSuccessPage accountSuccesspage;
	private commonUtils commonutlis;
	
	@Given("User navigates to RegisterAccount Page")
	public void user_navigates_to_register_account_page() {
		
		driver = Driverfactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.ClickonMyAccountOption();
		registerpage = homepage.ClickonRegisterOption();
		}

	@When("User enters below fields")
	public void user_enters_below_fields(DataTable dataTable) {
		Map<String, String> datamap = dataTable.asMap(String.class, String.class);
		 commonutlis = new commonUtils();
		registerpage = new RegisterPage(driver);
		registerpage.EnterfirstnameText(datamap.get("FirstName"));
		registerpage.Enterlastnametext(datamap.get("LastName"));
		registerpage.enterEmailText(commonutlis.getEmailtimestamp());
		registerpage.EntertelephoneNumber(datamap.get("Telephone"));
		registerpage.EnterPassword(datamap.get("password"));
		registerpage.ConfirmPassword(datamap.get("password"));
	
	    }
	
	@When("User enters below fields with duplicate email")
	public void user_enters_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> datamap = dataTable.asMap(String.class, String.class);
		
		registerpage.EnterfirstnameText(datamap.get("FirstName"));
		registerpage.Enterlastnametext(datamap.get("LastName"));
		registerpage.enterEmailText(datamap.get("Email"));
		registerpage.EntertelephoneNumber(datamap.get("Telephone"));
		registerpage.EnterPassword(datamap.get("password"));
		registerpage.ConfirmPassword(datamap.get("password"));
	
	    }
	

	@And("User selects privacy policy")
	public void user_selects_privacy_policy() {
		
		registerpage.ClickonPrivacyPolic();
	  }

	@And("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		accountSuccesspage = registerpage.ClickonContinueButton();
		
	    }

	@Then("User account should be created")
	public void user_account_should_be_created() {
		
		Assert.assertEquals
		("Your Account Has Been Created!", accountSuccesspage.GetPageHeading());
		
	   }

	@And("User selects Yes for NewsLetter")
	public void user_selects_yes_for_news_letter() {
		
		registerpage = new RegisterPage(driver);
		registerpage.ClickonYesNewsLetter();
	    }

	@Then("User Should get proper warning message about duplicate email")
	public void user_should_get_proper_warning_message_about_duplicate_email() {
		Assert.assertTrue(registerpage.getWarningmessageText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {


		registerpage.EnterfirstnameText("");
		registerpage.Enterlastnametext("");
		registerpage.enterEmailText("");
		registerpage.EntertelephoneNumber("");
		registerpage.EnterPassword("");
		registerpage.ConfirmPassword("");
	   }


	@Then("User Should get proper warning message for every mandatory field")
	public void user_should_get_proper_warning_message_for_every_mandatory_field() {
		
		
		Assert.assertTrue(registerpage.getWarningmessageText()
				.contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerpage.getfirstnamewarning());
	    }


	}

