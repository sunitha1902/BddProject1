package runner;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.mindtree.manager.PageObjectManager;
import com.mindtree.reusable.BaseTest;

import pageobject.AboutUsPage;
import pageobject.AirportPage;
import pageobject.ContactUsPage;
import pageobject.CorporateCarRentalPage;
import pageobject.Homepage;
import pageobject.LocalPage;
import pageobject.OneWayPage;
import pageobject.OutstationPage;
import utility.ExcelSheetRead;
import utility.ExtentReporterNG;
import utility.Logs;


public class WebApp extends BaseTest {
	static PageObjectManager pageManager;
	static Homepage homepage;
	static ContactUsPage contactpage;
	static AboutUsPage aboutpage;
	static CorporateCarRentalPage corporatepage;
	static OneWayPage onewaypage;
	static AirportPage airportpage;
	static OutstationPage outstationpage;
	static LocalPage localpage;
	static Logs loggerUtil;
	static Logger log;
	static ExcelSheetRead ex;
	static ExtentReports extent = ExtentReporterNG.extentReportGenerator();
	static String screenshotPath = null;

	@BeforeMethod
	public void Before() throws IOException {
		startUp();
		ex = new ExcelSheetRead(); 
	}

	@Test(priority = 1)
	public static void test1() throws IOException, InterruptedException {
		try {
			test = extent.createTest("test1");
			test.log(Status.PASS, "TestCase Execution Started");
			loggerUtil = new Logs();
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test1");
			pageManager = new PageObjectManager();
			homepage = pageManager.getHomePage();
			String ExpectedTitle = ex.read("HomepageTitle");
			homepage.ValidateTitle(ExpectedTitle);
			test.log(Status.PASS, "Successful");
			screenshotPath = getscreenshotpath("test1");
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test1");
			test.fail("test1 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.log(Status.FAIL, "UnSuccessful");
		}
	}

	@Test(priority = 2)
	public static void test2() throws IOException, InterruptedException {
		try {
			test = extent.createTest("test2");//df
			test.log(Status.PASS, "TestCase Execution Started");//ff
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test 2");
			pageManager = new PageObjectManager();
			String Name = ex.read("Name");
			String Phone = ex.read("Phone");
			String Email = ex.read("Email");
			String Password = ex.read("Password");
			String RePassword = ex.read("RePassword");
			homepage.SignUp(Name, Phone, Email, Password, RePassword);
			test.log(Status.PASS, "Successful");//df
			screenshotPath = getscreenshotpath("test2");//df
		} catch (Exception e) {
			screenshotPath = getscreenshotpath("test2");//df
			test.fail("test2 test failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//df
			test.log(Status.FAIL, "UnSuccessful");//df
		}
	}

	@Test(priority = 3)
	public static void test3() throws IOException, InterruptedException {
		try {
			
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test3");
			pageManager = new PageObjectManager();
			String Email = ex.read("Email");
			String Password = ex.read("Password");
			homepage.Login(Email, Password);
			
		} catch (Exception e) {
			
		}
	}

	@Test(priority = 4)
	public static void test4() throws IOException, InterruptedException {
		try {
		
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test4");
			pageManager = new PageObjectManager();
			aboutpage = pageManager.getAboutUsPage();
			aboutpage.ClickOnAbout();
			aboutpage.Switchtab(1);
			String Expected = ex.read("CEO");
			aboutpage.Validate(Expected);
		} catch (Exception e) {
			
		}
	}

	@Test(priority = 5)
	public static void test5() throws IOException, InterruptedException {
		try {
			
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test5");
			pageManager = new PageObjectManager();
			contactpage = pageManager.getContactUsPage();
			contactpage.ClickOnContactUs();
			contactpage.Switchtab(1);
			String Contact = ex.read("Contact");
			contactpage.Validate(Contact);
			
		} catch (Exception e) {
			
		}

	}

	@Test(priority = 6)
	public static void test6() throws IOException, InterruptedException {
		try {
			
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test6");
			pageManager = new PageObjectManager();
			onewaypage = pageManager.getOneWayPage();
			onewaypage.ClickOnOneWay();
			onewaypage.Switchtab(1);
			onewaypage.SelectAgra();
			onewaypage.SelectPlace();
			onewaypage.Switchtab(2);
			String Expected = ex.read("OneWay");
			onewaypage.ValidatePage(Expected);
			
		} catch (Exception e) {
			
		}
	}

	@Test(priority = 7)
	public static void test7() throws IOException, InterruptedException {
		try {
			
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test7");
			pageManager = new PageObjectManager();
			localpage = pageManager.getLocalPage();

			localpage.ClickOnLocal();
			localpage.Switchtab(1);

			String Source = ex.read("Source");
			String Month = ex.read("Month");
			String Date = ex.read("Date").replace(".0", "");
			String Time = ex.read("Time");
			String CarType = ex.read("CarType");

			localpage.SelectSrc(Source);
			localpage.SelectDate(Month, Date);
			localpage.SelectPickuptime(Time);
			localpage.ClickOnSearchCar();
			localpage.SelectFirstCar();
			localpage.ValidateCarDetails(CarType);
			
		} catch (Exception e) {
			
		}
	}

	@Test(priority = 8)
	public static void test8() throws IOException, InterruptedException {
		try {
			
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test8");
			pageManager = new PageObjectManager();
			String Source = ex.read("Source");
			String Destination = ex.read("Destination");
			String Month = ex.read("Month");
			String Date = ex.read("Date").replace(".0", "");
			String Time = ex.read("Time");
			String Outprice = ex.read("Outprice");

			outstationpage = pageManager.getOutstationPage();
			outstationpage.SelectSrc(Source);
			outstationpage.SelectDest(Destination);
			outstationpage.SelectDate(Month, Date);
			outstationpage.SelectPickuptime(Time);
			outstationpage.ClickOnSearchCar();
			outstationpage.SelectFirstCar();
			outstationpage.ValidateCarDetails(Outprice);
			
			} catch (Exception e) {
			
		}

	}

	@Test(priority = 9)
	public static void test9() throws IOException, InterruptedException {
		try {
			
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test9");
			pageManager = new PageObjectManager();

			String Source = ex.read("Source");
			String AirportDest = ex.read("AirportDest");
			String Month = ex.read("Month");
			String Date = ex.read("Date").replace(".0", "");
			String Time = ex.read("Time");
			String Outprice = ex.read("Outprice");

			airportpage = pageManager.getAirportPage();
			airportpage.ClickOnAirport();
			airportpage.Switchtab(1);
			airportpage.SelectSrc(Source);
			airportpage.SelectTripType();
			airportpage.SelectDest(AirportDest);
			airportpage.SelectDate(Month, Date);
			airportpage.SelectPickuptime(Time);
			airportpage.ClickOnSearchCar();
			airportpage.SelectFirstCar();
			airportpage.ValidateCarDetails(Outprice);
			
		} catch (Exception e) {
		
		}

	}

	@Test(priority = 10)
	public static void test10() throws IOException, InterruptedException {
		try {
			
			loggerUtil = new Logs();
			log = loggerUtil.createLog("Test10");
			pageManager = new PageObjectManager();

			String Name = ex.read("Name");
			String Phone = ex.read("Phone");
			String Email = ex.read("Email");
			String Company = ex.read("Company");
			String Req = ex.read("Req");

			corporatepage = pageManager.getCorporateCarRentalPage();
			corporatepage.ClickOnCorporateCarRental();
			corporatepage.Switchtab(1);
			corporatepage.EnterName(Name);
			corporatepage.EnterCompany(Company);
			corporatepage.EnterEmail(Email);
			corporatepage.EnterPhoneNo(Phone);
			corporatepage.SelectRentalReq(Req);
			corporatepage.ClickSubmit();
			corporatepage.ValidateMSG();
			
		} catch (Exception e) {
			
		}
	}

	@AfterMethod
	public void After() {
		tearDown();
	}
	@AfterSuite()
	public void flush() {
		extent.flush();
	}
	

}
