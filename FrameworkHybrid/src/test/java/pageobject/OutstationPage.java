package pageobject;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;

import uistore.OutstationPageUI;
import utility.Logs;

public class OutstationPage {
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;

	public OutstationPage() {
		helper = new WebDriverHelper();
		loggerUtil = new Logs();
	}

	public void SelectSrc(String string) {
		try {
			log = loggerUtil.createLog("OutstationPage.java");
			helper.sendText(OutstationPageUI.src,string );
			helper.applicationWait(5000);
			helper.actionClick(OutstationPageUI.srcclick);
			log.debug("Source location filled");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot fill Source location");
		}
	}

	public void SelectDest(String string) {
		try {
			helper.sendText(OutstationPageUI.dest,
					string);
			helper.applicationWait(5000);
			helper.actionClick(OutstationPageUI.destclick);
			log.debug("Destination location filled");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot fill Destination location");
		}
	}

	public void SelectDate(String Month,String Date) {
		try {
			helper.actionClick(
					OutstationPageUI.datepicker);
			helper.applicationWait(5000);
			helper.Datepicker(OutstationPageUI.mon, Month,
					OutstationPageUI.nxt,
					OutstationPageUI.date, Date);
			log.debug("Date  selected");
		} catch (WebDriverHelperException e) {
			e.printStackTrace();
			log.debug("Cannot select Date ");
		}
	}

	public void SelectPickuptime(String string) {
		try {
			helper.selectByText(OutstationPageUI.pickup,string );
			log.debug("Pickuptime  selected");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot select Pickuptime ");
		}
	}

	public void ClickOnSearchCar() {
		try {
			helper.actionClick(OutstationPageUI.searchcar);
			log.debug("SearchCar Clicked");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot Click SearchCar ");
		}
	}

	public void SelectFirstCar() {
		try {
			helper.applicationWait(5000);
			helper.actionClick(OutstationPageUI.firstcar);
			log.debug("First Car Selected in the result page");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot Select Car ");
		}
	}

	public void ValidateCarDetails(String Expectedprice) {
		try {
			helper.applicationWait(5000);
			String Actualprice = helper.getText(OutstationPageUI.price);
			if (Actualprice.contains(Expectedprice)) {
				log.info("Price Validated : " + Actualprice);
			} else {
				log.info("Price Validation Failed : " + Actualprice);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Cannot Validate Car Details");
		}
	}
}
