package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage()
	{
		this.driver = getDriver();
	}
	
	public HomePage clickToggleButton()
	{
		WebElement menuClk = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@class=\"slds-icon-waffle\"]")));
		menuClk.click();
		return this;
	}
	
	public HomePage clickViewAll()
	{
		WebElement viewALL = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//button[text()='View All' and @class='slds-button']")));
		viewALL.click();
		return this;
	}
	
	public HomePage searchApp(String value)
	{
		driver.findElementByXPath("//input[@type='search' and @placeholder='Search apps or items...']").sendKeys(value);
		return this;
	}
	
	public SalesPage clickOnPartyConsent()
	{
		WebElement Accounts = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//p//mark[contains(text(),'Party Consent')]")));
		Accounts.click();
		return new SalesPage();
	}
	
	
}
