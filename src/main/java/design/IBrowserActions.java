package design;

import java.util.List;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public interface IBrowserActions {

	/**
	 * This method will locate the element using any given locator
	 * @param locator  - The locator by which the element to be found
	 * @param locValue - The locator value by which the element to be found
	 * @author Praveen Raj A
	 * @throws NoSuchElementException
	 */
	public WebElement locateElement(String locator, String locValue) ;	

	/**
	 * This method will locate the elements using any given locator
	 * @param locator  - The locator by which the elements to be found
	 * @param locValue - The locator value by which the elements to be found
	 * @author Praveen Raj A
	 * @return A list of all WebElements, or an empty list if nothing matches.
	 */
	public List<WebElement> locateElements(String type, String value);
	/**
	 * This method will enter the value in the given text field 
	 * @param ele   - The WebElement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the WebElement
	 * @author Praveen Raj A
	 * @throws ElementNotVisibleException		 * 
	 */
	public void type(WebElement ele, String data) ;

	/**
	 * This method will click the element and take snap
	 * @param ele   - The WebElement (button/link/element) to be clicked
	 * @author Praveen Raj A
	 */
	public void click(WebElement ele);

	/**
	 * This method will get the text of the element
	 * @param ele   - The WebElement (button/link/element) in which text to be retrieved
	 * @author Praveen Raj A - TestLeaf
	 */
	public String getText(WebElement ele);

	/**
	 * This method will close the active browser
	 * @author Praveen Raj A - TestLeaf
	 */
	public void closeActiveBrowser();		

	/**
	 * This method will close all the browsers
	 * @author Praveen Raj A - TestLeaf
	 */
	public void closeAllBrowsers();

}


