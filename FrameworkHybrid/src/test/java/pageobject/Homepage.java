package pageobject;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;

import uistore.HomepageUI;
import utility.Logs;

public class Homepage {
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;

	public Homepage() {
		helper = new WebDriverHelper();
		loggerUtil = new Logs();
	}

	public void ValidateTitle(String string) {
		log = loggerUtil.createLog("Homepage.java");
		String ActualTitle = helper.getTitle();
		String ExpectedTitle = string;
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		log.debug("Homepage Title Validated");
	}

	public void SignUp(String string, String string2, String string3, String string4, String string5) {
		try {
			helper.clickButton(HomepageUI.signin);
			helper.clickButton(HomepageUI.register);

			helper.sendText(HomepageUI.username, string);
			helper.sendText(HomepageUI.phone, string2);
			helper.sendText(HomepageUI.email, string3);
			helper.sendText(HomepageUI.pass, string4);
			helper.sendText(HomepageUI.repass, string5);
			helper.clickButton(HomepageUI.submit);
			log.info("User Succesfully Registered");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.info("Failed to SignUp");
		}
	}

	public void Login(String string, String string2) {
		try {
			helper.clickButton(HomepageUI.signin);

			helper.sendText(HomepageUI.email, string);
			helper.sendText(HomepageUI.pass, string2);

			helper.clickButton(HomepageUI.submit);
			log.info("User Succesfully Loggged in");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.info("User Failed to Loggged in");
		}
	}
}
