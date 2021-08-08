package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage()
	{
		this.driver = getDriver();
	}
	
	public LoginPage enterUsername()
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username")))).sendKeys("cypress@testleaf.com");
		return this;
	}
	
	public LoginPage enterPassword()
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("password")))).sendKeys("Selbootcamp@1234");
		return this;
	}
	
	public HomePage clickLogin()
	{
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("Login")))).click();
		return new HomePage();
	}
}
