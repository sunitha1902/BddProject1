package pageobject;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;

import uistore.CorporateCarRentalPageUI;
import utility.Logs;

public class CorporateCarRentalPage {
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;

	public CorporateCarRentalPage() {
		helper = new WebDriverHelper();
		loggerUtil = new Logs();
	}

	public void ClickOnCorporateCarRental() {
		log = loggerUtil.createLog("CorporateCarRental.java");
		try {
			helper.actionClick(CorporateCarRentalPageUI.corporate);
			log.debug("Clicked on CorporateCarRental under service section");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot Click on CorporateCarRental under service section");
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

	public void EnterName(String name) {
		try {
			helper.sendText(CorporateCarRentalPageUI.name, name);
			log.debug("Name Entered");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot Enter Name");
		}
	}

	public void EnterCompany(String company) {
		try {
			helper.sendText(CorporateCarRentalPageUI.company, company);
			log.debug("Company name Entered");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot fill Company name");
		}
	}

	public void EnterEmail(String email) {
		try {
			helper.sendText(CorporateCarRentalPageUI.email, email);
			log.debug("Email  Entered");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot fill Email");
		}
	}

	public void EnterPhoneNo(String Phone) {
		try {
			helper.sendText(CorporateCarRentalPageUI.phoneno, Phone);
			log.debug("Phone no Entered");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot fill Phone no");
		}
	}

	public void SelectRentalReq(String req) {
		try {
			helper.selectByValue(CorporateCarRentalPageUI.req,
					req);
			log.debug("Rental Requirment Selected");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot select Rental Requirment ");
		}
	}

	public void ClickSubmit() {
		try {
			helper.actionClick(CorporateCarRentalPageUI.submit);
			log.debug("Submit button Clicked");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot Click Submit button ");
		}
	}

	public void ValidateMSG() {
		try {
			helper.applicationWait(5000);
			log.info(helper.getText(CorporateCarRentalPageUI.msg));
			log.debug("MSG validated");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot validate MSG");
		}
	}
}
