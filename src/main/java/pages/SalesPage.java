package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseClass;

public class SalesPage extends BaseClass {
	
	public SalesPage()
	{
		this.driver = getDriver();
	}
	
	public SalesPage searchForPartyConsent(String partyName) throws InterruptedException
	{
		WebElement search = driver.findElementByXPath("//input[@name='PartyConsent-search-input']");
		wait.until(ExpectedConditions.elementToBeClickable(search));
		search.clear();
		search.sendKeys(partyName);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		return this;
	}
	
	public SalesPage clearSearch() throws InterruptedException
	{
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//input[@name='PartyConsent-search-input']")));
		search.clear();
		search.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		return this;
	}
	
	public SalesPage deletePartyConsent(String partyName)
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//a[@title='"+partyName+"']/following::td[10]//a"))).click();
		driver.findElementByXPath("//div[@role='button' and @title='Delete']/..").click();
		return this;
	}
	
	public SalesPage deletePopUpConfirmation()
	{
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//button//span[text()='Delete']"))).click();
		return this;
	}
	
	public void verifyDeletePartyConsent(String partyName)
	{
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
