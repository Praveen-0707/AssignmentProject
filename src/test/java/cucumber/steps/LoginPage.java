package cucumber.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import cucumber.base.CucumberBaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginPage extends CucumberBaseClass {
	
	@Given("launch salesforce application")
	public void launcApp()
	{
		String URL = "https://login.salesforce.com/";
		driver.get(URL);
	}
	
	@Given("Enter username as {string}")
	public void enterUsername(String username)
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username")))).sendKeys(username);
	}
	
	@Given("Enter password as {string}")
	public void enterPassword(String password)
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("password")))).sendKeys(password);
	}
	
	@Then("Click on Login button")
	public void clickLogin()
	{
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("Login")))).click();
		
		try {
			WebElement pageLoad1 = driver.findElementByXPath("//div[@class='linkElements']/a[text()='Switch to Lightning Experience']");
			boolean isDisplayed = pageLoad1.isDisplayed();
			if (isDisplayed)
			{
				js.executeScript("arguments[0].click();", pageLoad1);
			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
