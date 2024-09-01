package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SBILife_SmartLifetimeSaver extends mainconstructor{
	
	WebDriver driver;
	
	public SBILife_SmartLifetimeSaver(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//p[@class='unique-identifier-black']")
	private WebElement UIN;
	
	public String UINNo()
	{
		return UIN.getText();
	}
	
	@FindBy(xpath="//p[@class='unique-identifier-black unique-product-code']")
	private WebElement productcode;
	
	public String product_code()
	{
		return productcode.getText();
	}

}
