package assignment;

import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;

public class CreateContractWithoutMandatoryFields extends BaseClass {
	
	@Test
	public void createNewContractWithoutMandatoryFields() throws InterruptedException {
		
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickToggleButton()
		.clickViewAll()
		.searchApp("Contract")
		.clickOnApp("Contract")
		.clickOnTab("Contract")
		.clickOnNewContract()
		.inputAccountName()
		.inputContractDate("8/9/2021")
		.clickonSaveButton()
		.verifyErrorOnPage();
		
	}
}
