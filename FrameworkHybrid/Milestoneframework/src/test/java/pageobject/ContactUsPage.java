package pageobject;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;

import uistore.ContactUsPageUI;
import utility.Logs;

public class ContactUsPage {
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;

	public ContactUsPage() {
		helper = new WebDriverHelper();
		loggerUtil = new Logs();
	}

	public void ClickOnContactUs() {
		log = loggerUtil.createLog("ContactUsPage.java");
		try {
			helper.actionClick(ContactUsPageUI.contactus);
			log.debug("Contact Us Clicked");
		} catch (WebDriverHelperException e) {
			log.debug("Cannot Click Conatct Us Clicked");
		}
	}

	public void Switchtab(int i) {
		try {
			helper.switchHandles(i);
			log.debug("Switched to new Tab");
		} catch (Exception e) {
			log.debug("Cannot Switched to new Tab");
		}
	}

	public void Validate(String ExpectedContactNo) {
		try {
			String ActualContactNo = helper.getText(ContactUsPageUI.phoneno);
			if (ActualContactNo.contains(ExpectedContactNo)) {
				log.info("Contact No Validated : " + ActualContactNo);
			} else {
				log.info("Validation Failed");
			}
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.info("Cannot Validate");
		}
	}
}
