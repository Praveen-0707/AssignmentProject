package base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public RemoteWebDriver driver;
	public ChromeOptions chromeOptions;
	public static WebDriverWait wait;
	
	private static ThreadLocal<RemoteWebDriver> localDriver = new ThreadLocal<RemoteWebDriver>();
	
	public void setDriver(RemoteWebDriver driver)
	{
		localDriver.set(driver);
	}
	
	public static synchronized RemoteWebDriver getDriver()
	{
		return localDriver.get();
	}
	
	@BeforeMethod
	public void launchApp()
	{
		
		WebDriverManager.chromedriver().setup();
		chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		driver = new ChromeDriver(chromeOptions);
		setDriver(driver);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		
		String URL = "https://login.salesforce.com/";
		getDriver().get(URL);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		getDriver().close();
	}
	
}
