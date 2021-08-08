package cucumber.steps;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SalesPage;
import cucumber.base.CucumberBaseClass;

public class CommonMethods extends CucumberBaseClass {
	
	@Then("Click on Toggle button")
	public void clickToggleButton()
	{
		WebElement menuClk = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@class='slds-icon-waffle']")));
		menuClk.click();
	}
	
	@Then("Click on View All Link")
	public void clickViewAll()
	{
		WebElement viewALL = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//button[text()='View All' and @class='slds-button']")));
		viewALL.click();
	}
	
	@Given("Enter application name as {string}")
	public void searchApp(String value)
	{
		WebElement searchApp = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//input[@type='search' and @placeholder='Search apps or items...']")));
		searchApp.sendKeys(value);
	}
	
	@Then("Click on {string} link")
	public void clickOnApplication(String app)
	{
		WebElement appClk = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//p//mark[contains(text(),'"+app+"')]")));
		appClk.click();
	}
	
	@Then("search for existing record {string}")
	public void searchForPartyConsent(String partyName) throws InterruptedException
	{
		WebElement search = driver.findElementByXPath("//input[@name='PartyConsent-search-input']");
		wait.until(ExpectedConditions.elementToBeClickable(search));
		search.clear();
		search.sendKeys(partyName);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}
	
	@Then("click on delete record {string}")
	public void deletePartyConsent(String partyName)
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//a[@title='"+partyName+"']/following::td[10]//a"))).click();
		driver.findElementByXPath("//div[@role='button' and @title='Delete']/..").click();
	}
	
	@Then("click on confirm delete")
	public void deletePopUpConfirmation()
	{
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//button//span[text()='Delete']"))).click();
	}
	
	@Then("clear search record")
	public void clearSearch() throws InterruptedException
	{
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//input[@name='PartyConsent-search-input']")));
		search.clear();
		search.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}
	
	@When("verify if record {string} is deleted successfully")
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
