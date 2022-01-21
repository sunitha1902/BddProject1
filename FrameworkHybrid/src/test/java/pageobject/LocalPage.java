package pageobject;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;

import uistore.LocalPageUI;
import utility.Logs;

public class LocalPage {
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;

	public LocalPage() {
		helper = new WebDriverHelper();
		loggerUtil = new Logs();
	}

	public void ClickOnLocal() {
		log = loggerUtil.createLog("LocalPage.java");
		try {
			helper.actionClick(LocalPageUI.local);
			log.debug("Clicked on Local under service section");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot Click on Local under service section");
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

	public void SelectSrc(String string) {
		try {
			helper.sendText(LocalPageUI.src,string );
			helper.applicationWait(5000);
			helper.clickButton(LocalPageUI.srcclick);
			log.debug(" location filled");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot fill  location");
		}
	}

	public void SelectDate(String Month,String Date) {
		try {
			helper.actionClick(
					LocalPageUI.datepicker);
			helper.applicationWait(5000);
			helper.Datepicker(LocalPageUI.mon, Month,
					LocalPageUI.nxt,
					LocalPageUI.date, Date);
			log.debug("Date  selected");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot select Date ");
		}
	}

	public void SelectPickuptime(String string) {
		try {
			helper.selectByText(LocalPageUI.pickup, string);
			log.debug("Pickuptime  selected");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot select Pickuptime ");
		}
	}

	public void ClickOnSearchCar() {
		try {
			helper.actionClick(LocalPageUI.searchcar);
			log.debug("SearchCar Clicked");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot Click SearchCar ");
		}
	}

	public void SelectFirstCar() {
		try {
			helper.applicationWait(5000);
			helper.actionClick(LocalPageUI.firstcar);
			log.debug("First Car Selected in the result page");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot Select Car ");
		}
	}

	public void ValidateCarDetails(String ExpectedCarType) {
		try {
			helper.applicationWait(5000);
			String ActualCarType = helper.getText(LocalPageUI.type);
			if (ActualCarType.contains(ExpectedCarType)) {
				log.info("CarType Validated : " + ActualCarType);

			} else {
				log.info("CarType Validation Failed : " + ActualCarType);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot Validate Car Details");
		}
	}
}
