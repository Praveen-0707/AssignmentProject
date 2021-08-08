package pages;

import org.openqa.selenium.WebElement;
//import base.BaseClass;
import design.BrowserActions;

public class LoginPage extends BrowserActions {
	
	public LoginPage()
	{
		this.driver = getDriver();
	}
	
	public LoginPage enterUsername()
	{
		try {
			WebElement ele = locateElement("id", "username");
			type(ele, "cypress@testleaf.com");
			System.out.println("Username entered");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public LoginPage enterPassword()
	{
		try {
			WebElement ele = locateElement("id", "password");
			type(ele, "Selbootcamp@1234");
			System.out.println("Password entered");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public HomePage clickLogin()
	{
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("Login")))).click();
		click(locateElement("id","Login"));
		return new HomePage();
	}
}
