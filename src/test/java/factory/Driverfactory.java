package factory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import net.bytebuddy.asm.Advice.Return;
import utils.ConfigReader;
import utils.commonUtils;

public class Driverfactory {
	static WebDriver driver=null;
	public static WebDriver initializeBroser(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			 driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			 driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("Safari")) {
			 driver = new SafariDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(commonUtils.IMPLICT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(commonUtils.PAGE_LOAD_TIME));
		return driver;
	}
	
	public static WebDriver  getDriver() {
		return driver;
		
	}
	
	
}
