package cucumber.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class CucumberBaseClass extends AbstractTestNGCucumberTests {
	
	public static RemoteWebDriver driver;
	public ChromeOptions chromeOptions;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	public static Actions actions;
	public static String browser;
	
}
