package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Myhooks {
	WebDriver driver;
	private ConfigReader configreader;
	@Before
	public void setup() {
		configreader = new ConfigReader();
		Properties prop = configreader.initalizeProperties();
		driver = Driverfactory.initializeBroser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	}
	
	@After
	public void teardown(Scenario scenario) {
		String scenarioName =scenario.getName().replaceAll(" ", "_");
		if(scenario.isFailed()) {
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", scenarioName);
		}
		
		driver.quit();
	}
}
