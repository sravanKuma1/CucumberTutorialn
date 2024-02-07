package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsUtils {
	WebDriver driver;
	public ElementsUtils(WebDriver driver) {
		this.driver=driver;
	}
	public void ClickonElement(WebElement element, long durationInSeconds) {

		WebElement webelement = waitForElement(element, durationInSeconds);
		webelement.click();
	}

	public void TypeTextIntoElement(WebElement element, long durationInSeconds, String TextedtoBeTyped) {

		WebElement webelement = waitForElement(element, durationInSeconds);
		webelement.clear();
		webelement.sendKeys(TextedtoBeTyped);
	}

	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		WebElement webelement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		return webelement;
	}

	public void SelectOptionInDropdown(WebElement element,String dropdownOption, long durationInSeconds) {

		WebElement webElement= waitForElement(element, durationInSeconds);
		Select select = new Select(webElement);
		select.deselectByVisibleText(dropdownOption);
	}

	public void acceptAlert(long durationInSeconds) {
		Alert alert = waitforalerts(durationInSeconds);
		alert.accept();
	}

	public void dissmissAlert(long durationInSeconds) {

		Alert alert = waitforalerts(durationInSeconds);
		alert.dismiss();
	}

	public Alert waitforalerts(long durationInSeconds) {

		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		}
		catch(Throwable e) {
			e.printStackTrace();
		}

		return alert;
	}

	
	public void MouseoverAndClick(WebElement element,long durationInSeconds ) {
	
		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		Actions actions = new Actions(driver);
		actions.moveToElement(webelement).click().build().perform();
	}

	public WebElement waitForVisibilityOfElement(WebElement element,long durationInSeconds ) {
		WebElement webelement=null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		 webelement = wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		return webelement;
	}
	
	
	public void JavascriptClick(WebElement element,long durationInSeconds) {
		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click()", webelement);
	}
	public void javascriptType(WebElement element,long durationInSeconds,String texttobeTyped) {
		WebElement webelement =waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].valu='"+texttobeTyped+"'", webelement);
	}
	public String gettextfromElement(WebElement element, long durationInSeconds) {
		WebElement webElement= waitForElement(element, durationInSeconds);
		return webElement.getText();
	}
	
	public boolean DisplaystatusOfelement(WebElement element, long durationInSeconds) {
		try {
		WebElement webElement= waitForElement(element, durationInSeconds);
		return webElement.isDisplayed();
	}catch(Throwable e) {
		return false;
	}
		
	}
	
}

































