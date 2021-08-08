package assignment;

import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;

public class DeletePartyConsent extends BaseClass {
	
	@Test
	public void deleteParty() throws InterruptedException {
		
		String partyName = "Raj Praveen";
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickToggleButton()
		.clickViewAll()
		.searchApp("Party Consent")
		.clickOnApp("Party Consent")
		.searchForPartyConsent(partyName)
		.deletePartyConsent(partyName)
		.deletePopUpConfirmation()
		.clearSearch()
		.verifyDeletePartyConsent(partyName);
	}
}
