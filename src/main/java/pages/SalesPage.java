package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import base.BaseClass;
import design.BrowserActions;

public class SalesPage extends BrowserActions {
	
	public SalesPage()
	{
		this.driver = getDriver();
	}
	
	public SalesPage searchForPartyConsent(String partyName) throws InterruptedException
	{
		WebElement search = locateElement("xpath","//input[@name='PartyConsent-search-input']");
		typeAndEnter(search, partyName);
		Thread.sleep(3000);
		return this;
	}
	
	public SalesPage clearSearch() throws InterruptedException
	{
		WebElement search = locateElement("xpath","//input[@name='PartyConsent-search-input']");
		typeAndEnter(search, "");
		click(locateElement("xpath","//button[@title='Refresh']"));
		Thread.sleep(5000);
		return this;
	}
	
	public SalesPage deletePartyConsent(String partyName)
	{
		click(locateElement("xpath","//a[@title='"+partyName+"']/following::td[10]//a"));
		click(locateElement("xpath","//div[@role='button' and @title='Delete']/.."));
		return this;
	}
	
	public SalesPage deletePopUpConfirmation()
	{
		click(locateElement("xpath","//button//span[text()='Delete']"));
		return this;
	}
	
	public SalesPage clickOnTab(String value)
	{
		try {
			clickByJS(locateElement("xpath","(//a[contains(@title,'"+value+"')]/following::a)[1]"));
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public SalesPage clickOnNewContract()
	{
		try {
			clickByJS(locateElement("xpath","//span[contains(text(),'New Contract')]/ancestor::a"));
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public SalesPage inputAccountName()
	{
		try {
			WebElement ele = locateElement("xpath","//input[@title='Search Accounts']");
			clickByActions(ele);
			sendkeysUsingActions(ele, Keys.ARROW_DOWN);
			sendkeysUsingActions(ele, Keys.ENTER);
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public SalesPage inputContractDate(String date)
	{
		try {
			WebElement ele = locateElement("xpath","//span[text()='Contract Start Date']/parent::label/following-sibling::div/input");
			clickByActions(ele);
			type(ele, date);
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public SalesPage clickonSaveButton()
	{
		try {
			click(locateElement("xpath","//button[@title='Save']"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public void verifyErrorOnPage()
	{
		WebElement err = locateElement("xpath","//div[@class='desktop forcePageError']//ul/li");
		String eachName = err.getText();
		if (eachName.contains("These required fields must be completed"))
		{
			System.out.println("TC Passed");
		}
		else
		{
			System.out.println("TC Failed");
		}
	}
		
	public void verifyDeletePartyConsent(String partyName)
	{
		List<WebElement> elements = locateElements("xpath","//table[contains(@class,'slds-table forceRecordLayout')]/tbody/tr");
		int size = elements.size();
		int i;
		for (i=1; i<=size; i++)
		{
			WebElement names = locateElement("xpath","//table[contains(@class,'slds-table forceRecordLayout')]/tbody/tr["+i+"]/th//a");
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
