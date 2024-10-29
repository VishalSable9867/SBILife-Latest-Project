package Test_Cases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Page_Objects.SBILife_SmartLifetimeSaver;
import Page_Objects.homepage;
import Page_Objects.productList;
import Page_Objects.proposalFormEntry;
import TestBase.baseClass;
import utilities.dataProvider;

public class TC_002 extends baseClass {

	@Test(dataProvider="Test2", dataProviderClass=dataProvider.class)
	public void secondcript (String planselection,String ProductName,String UIN_No,String product_code,String name, String dob,String gend,String staff_select,String term,String frequency,String amt ) throws Throwable 
	{
		logger.info("Test case running started");
		
		homepage h = new homepage(driver);
		expilcitWait(driver, 5,h.product_Btn());
		mouseover(driver,h.product_Btn());
		logger.info("*********move to product succesfully*******");
		
		expilcitWait(driver,5,h.individual_plans());
		mouseover(driver, h.individual_plans());
		logger.info("*********move to plans succesfully*******");
		
		h.mainproductdynamicxpath(planselection,driver);
		logger.info("*********click on selected plan succesfully*******");
		
		productList pl = new productList(driver);
		expilcitWait(driver,10,pl.t1(driver,ProductName));
		scroll(driver,pl.t1(driver,ProductName));    
		
		expilcitWait1(driver,5,pl.product_list_select());
		productSelection(pl.product_list_select(),ProductName);
		
		SBILife_SmartLifetimeSaver smartlife= new SBILife_SmartLifetimeSaver(driver);
		
		String trt = smartlife.UINNo().replace("UIN: ","");
		System.out.println(trt);
		String pdc=smartlife.product_code().replace("Product Code: ", "");
		System.out.println(pdc);
		SoftAssert s = new SoftAssert();
		s.assertEquals(trt,UIN_No,"UIN Not matched");
		logger.info("UIN number verification");
		s.assertEquals(pdc, product_code, "Product code does not match");
		logger.info("Product code verification");
		s.assertAll();
		proposalFormEntry pf = new proposalFormEntry(driver);
		scroll(driver,pf.nameScroll());
		logger.info("**************Scroll to Name value************************");
		pf.First_Name(name);
		logger.info("**************Name Entered************************");
		pf.Date_Birth(dob);
		logger.info("**************DOB Entered************************");
		pf.Gender(driver,gend);
		logger.info("**************Gender Selected************************");
		pf.staffAndNonStaff(driver,staff_select);
		logger.info("**************Staff and non staff selected************************");
	//	slidermove(pf.policyTermSlider(),pf.policyTermValueMatch(),"13");
	//	logger.info("**************policy Term Selected****************");
//		pf.planOptions(driver, "Endowment Option");
//		logger.info("**************Plan Option Selected****************");
		//scroll(driver,pf.policyTermScoll());
	//	pf.policy_Term(term);
	//	pf.PremiumFrequency(driver, frequency);
		//slideSlider(pf.premiumFrequencySlider(),pf.PremiumFrequency(driver,"Monthly SSS"),driver);
		Thread.sleep(5000);
		logger.info("**************premium frequency selected****************");
		pf.premium_Amount();
		jsValueInsert(driver,pf.Sum_Assured(),amt);
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
