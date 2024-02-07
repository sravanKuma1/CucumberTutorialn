package pages;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;
import utils.commonUtils;

public class AccountSuccessPage {
	WebDriver driver;
	private ElementsUtils elementsUtils;
	public AccountSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}
	
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement Pageheading;
	
	
	public String GetPageHeading() {
		return elementsUtils.gettextfromElement(Pageheading, commonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}
}
