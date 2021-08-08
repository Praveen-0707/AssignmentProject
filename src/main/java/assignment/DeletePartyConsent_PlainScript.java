package assignment;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeletePartyConsent_PlainScript {

	public static void main(String[] args) throws InterruptedException {
		//*[local-name()='svg' and @class='slds-icon slds-icon_x-small']
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		
		String url = "https://login.salesforce.com/";
		driver.get(url);
		
		//Login
		driver.findElement(By.id("username")).sendKeys("cypress@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Selbootcamp@1234");
		driver.findElement(By.id("Login")).click();
		
		String partyName = "Raj Praveen";
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@class='slds-icon-waffle']"))).click();
		
		WebElement viewALL = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//button[text()='View All' and @class='slds-button']")));
		viewALL.click();
		driver.findElementByXPath("//input[@type='search' and @placeholder='Search apps or items...']").sendKeys("Party Consent");	
		
		WebElement Accounts = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//p//mark[contains(text(),'Party Consent')]")));
		Accounts.click();
		
		//delete by name
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//a[@title='"+partyName+"']/following::td[10]//a"))).click();
		driver.findElementByXPath("//div[@role='button' and @title='Delete']/..").click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//button//span[contains(text(),'Delete')]"))).click();
		Thread.sleep(5000);
		List<WebElement> elements = driver.findElementsByXPath("//table[contains(@class,'slds-table forceRecordLayout')]/tbody/tr");
		int size = elements.size();
		int i;
		for (i=1; i<=size; i++)
		{
			WebElement names = driver.findElementByXPath("//table[contains(@class,'slds-table forceRecordLayout')]/tbody/tr["+i+"]/th//a");
			String eachName = names.getText();
			if (eachName.contains(partyName))
			{
				System.out.println("TC Faied");
				break;
			}
			else
			{
				if (i == size)
				{
					System.out.println("Delete successful, TC-Passed");
				}
			}
		}
	}
}
