package pages;

//import base.BaseClass;
import design.BrowserActions;

public class HomePage extends BrowserActions {
	
	public HomePage()
	{
		this.driver = getDriver();
	}
	
	public HomePage clickToggleButton()
	{
		click(locateElement("xpath","//div[@class='slds-icon-waffle']"));
		return this;
	}
	
	public HomePage clickViewAll()
	{
		click(locateElement("xpath","//button[text()='View All' and @class='slds-button']"));
		return this;
	}
	
	public HomePage searchApp(String value)
	{
		type(locateElement("xpath","//input[@type='search' and @placeholder='Search apps or items...']"),value);
		return this;
	}
	
	public SalesPage clickOnPartyConsent()
	{
		click(locateElement("xpath","//p//mark[contains(text(),'Party Consent')]"));
		return new SalesPage();
	}
	
	
}
