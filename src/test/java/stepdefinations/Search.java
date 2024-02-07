package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;

public class Search {
	WebDriver driver;
	private HomePage homepage;
	private SearchPage searchpage;
	
	@Given("User navigates to Searchpage")
	public void user_navigates_to_searchpage() {
		driver = Driverfactory.getDriver();
			
		}

	@When("User enters Valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String validProducttext) {
		
		homepage= new HomePage(driver);
		homepage.enterValidSearchBoxfild(validProducttext);
				
	}

	@And("Clicks on search button")
	public void clicks_on_search_button() {

		searchpage = homepage.ClickonSearchButton();
		}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		Assert.assertTrue(searchpage.searchVaildProductDisplayed());
		}

	@When("User enters inValid product {string} into search box field")
	public void user_enters_in_valid_product_into_search_box_field(String invalidProducttext) {
		homepage = new HomePage(driver);
		homepage.enterValidSearchBoxfild(invalidProducttext);
	}

	@Then("User should get a message about no prdouct match")
	public void user_should_get_a_message_about_no_prdouct_match() {
		
		Assert.assertEquals("There is no product that matches the search criteria.", searchpage.warninginvaildproductMessage());
		
	}

	@When("User dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
		homepage= new HomePage(driver);
		
	}

}
