package Test_Cases;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Page_Objects.SBILife_SmartLifetimeSaver;
import Page_Objects.homepage;
import Page_Objects.productList;
import Page_Objects.proposalFormEntry;
import TestBase.baseClass;

public class TC_001 extends baseClass {

	
	@Test //(dataProvider="Test1", dataProviderClass=dataProvider.class)
	public void firstScript() throws Throwable 
	{
		logger.info("Test case running started");
		
		homepage h = new homepage(driver);
		expilcitWait(driver, 5,h.product_Btn());
		mouseover(driver,h.product_Btn());
		logger.info("*********move to product succesfully*******");
		
		expilcitWait(driver,5,h.individual_plans());
		mouseover(driver, h.individual_plans());
		logger.info("*********move to plans succesfully*******");
		
		h.mainproductdynamicxpath("2",driver);
		logger.info("*********click on selected plan succesfully*******");
		
		productList pl = new productList(driver);
		expilcitWait(driver,10,pl.t1(driver,"SBI Life � Shubh Nivesh"));
		scroll(driver,pl.t1(driver,"SBI Life � Shubh Nivesh"));    
		
		expilcitWait1(driver,5,pl.product_list_select());
		productSelection(pl.product_list_select(),"SBI Life � Shubh Nivesh");
		
		SBILife_SmartLifetimeSaver smartlife= new SBILife_SmartLifetimeSaver(driver);
		
		String trt = smartlife.UINNo().replace("UIN: ","");
		System.out.println(trt);
		String pdc=smartlife.product_code().replace("Product Code: ", "");
		System.out.println(pdc);
		SoftAssert s = new SoftAssert();
		s.assertEquals(trt,"111N055V04","UIN Not matched");
		logger.info("UIN number verification");
		s.assertEquals(pdc, "35", "Product code does not match");
		logger.info("Product code verification");
		s.assertAll();
		proposalFormEntry pf = new proposalFormEntry(driver);
		scroll(driver,pf.nameScroll());
		logger.info("**************Scroll to Name value************************");
		pf.First_Name("Shruti");
		logger.info("**************Name Entered************************");
		pf.Date_Birth("16/04/1998");
		logger.info("**************DOB Entered************************");
		pf.Gender(driver,"female");
		logger.info("**************Gender Selected************************");
		pf.staffAndNonStaff(driver,"staff");
		logger.info("**************Staff and non staff selected************************");
		slidermove(pf.policyTermSlider(),pf.policyTermValueMatch(),"13");
		logger.info("**************policy Term Selected****************");
		pf.planOptions(driver, "Endowment Option");
		logger.info("**************Plan Option Selected****************");
		scroll(driver,pf.policyTermScoll());
		slideSlider(pf.premiumFrequencySlider(),pf.PremiumFrequency(driver,"Monthly SSS"),driver);
		Thread.sleep(5000);
		logger.info("**************premium frequency selected****************");
		// jsValueInsert(driver,pf.Sum_Assured(),78000000);
		Thread.sleep(5000);
		logger.info("**************Sum Assured Entered****************");
		pf.calculate_Btn();
		logger.info("**************Calculate btn click****************");
		jsCloseWindow(driver,pf.close_btn());
		pf.close_btn();
//		logger.info("**************Close btn up****************");
//		expilcitWait(driver,15,pf.close_popup());
//		jsCloseWindow(driver, pf.close_popup());
//		logger.info("**************Close Suggestion pop up****************");

		Thread.sleep(3000);
		
		
	}
}
