package design;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass;

public class BrowserActions extends BaseClass implements IBrowserActions{

	public BrowserActions() {
			this.driver = getDriver();
	}

	public WebElement locateElement(String locator, String locValue) {

		try {
			
			switch (locator.toLowerCase()) {
			case "id": return driver.findElement(By.id(locValue));

			case "name": return driver.findElement(By.name(locValue));

			case "class": return driver.findElement(By.className(locValue));

			case "link" : return driver.findElement(By.linkText(locValue));

			case "xpath": return driver.findElement(By.xpath(locValue));	

			default:
				break;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<WebElement> locateElements(String type, String value) {
		try {
			switch(type.toLowerCase()) {
			case "id": return driver.findElementsById(value);
			case "name": return driver.findElementsByName(value);
			case "class": return driver.findElementsByClassName(value);
			case "link": return driver.findElementsByLinkText(value);
			case "xpath": return driver.findElementsByXPath(value);
			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void type(WebElement ele, String data) {
		try {
			webDriverWait4VisibilityOfEle(ele);
			ele.clear();
			ele.sendKeys(data);
		} catch (InvalidElementStateException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}
	
	public void typeAndEnter(WebElement ele, String data) throws InterruptedException {
		try {
			webDriverWait4VisibilityOfEle(ele);
			ele.clear();
			ele.sendKeys(data);
			Thread.sleep(1000);
			ele.sendKeys(Keys.ENTER);
		} catch (InvalidElementStateException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}
	
	public void click(WebElement ele) {
		try {
			webDriverWait4ElementToBeClickable(ele);
			ele.click();
		} catch (InvalidElementStateException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		} 
	}
	
	public void clickByJS(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try {
			js.executeScript("arguments[0].click();", ele);
		} catch (JavascriptException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		} 
	}
	
	public void clickByActions(WebElement ele) {
		Actions actions = new Actions(driver);
		try {
			actions.moveToElement(ele).click().perform();
		} catch (ElementClickInterceptedException e) {
			e.printStackTrace();
		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		} 
	}
	
	public void sendkeysUsingActions(WebElement ele, Keys keyVal) {
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys(keyVal).perform();
		} catch (InvalidElementStateException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}
	
	public String getText(WebElement ele) {	
		String bReturn = "";
		try {
			webDriverWait4VisibilityOfEle(ele);
			bReturn = ele.getText();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		return bReturn;
	}

	public void closeActiveBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
