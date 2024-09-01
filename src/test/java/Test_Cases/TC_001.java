package Test_Cases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Page_Objects.FrameFirst;
import Page_Objects.SBILife_SmartLifetimeSaver;
import Page_Objects.homepage;
import Page_Objects.productList;
import TestBase.baseClass;
import utilities.dataProvider;

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
		expilcitWait(driver,10,pl.t1(driver,"SBI Life – Shubh Nivesh"));
		scroll(driver,pl.t1(driver,"SBI Life – Shubh Nivesh"));    
		
		expilcitWait1(driver,5,pl.product_list_select());
		productSelection(pl.product_list_select(),"SBI Life – Shubh Nivesh");
		
		SBILife_SmartLifetimeSaver smartlife= new SBILife_SmartLifetimeSaver(driver);
		
		String trt = smartlife.UINNo().replace("UIN: ","");
		System.out.println(trt);
		String pdc=smartlife.product_code().replace("Product Code: ", "");
		System.out.println(pdc);
		SoftAssert s = new SoftAssert();
		s.assertEquals(trt,"111N136V0","UIN Not matched");
		logger.info("UIN number verification");
		s.assertEquals(pdc, "2Z", "Product code does not match");
		logger.info("Product code verification");
		s.assertAll();
		logger.info("Test case execution ended");
		//driver.navigate().to("https://www.sbilife.co.in/");
//		FrameFirst ff = new FrameFirst(driver);
//		switchToFrame(ff.frame12(),driver);
		// Thread.sleep(50000);
		// switchToFrame(ff.frame12(),driver);
	}
}
