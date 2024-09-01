package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class proposalFormEntry extends mainconstructor {
	WebDriver driver;
	
	public proposalFormEntry(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='pName']")
	private WebElement firstname;
	
	public void First_Name()
	{
		firstname.sendKeys("Om");
	}
	
	@FindBy(xpath="//input[@id='birthDate3']")
	private WebElement DOB;
	
	public void Date_Birth()
	{
		DOB.sendKeys("16/04/1998");
	}
	
	public void Gender(String key)     ////input[@value="Third Gender"]
	{
		WebElement ele = driver.findElement(By.xpath("//input[@value="+key+"]"));
		ele.click();
	}
	
	public void discount(String key)   ////input[@value="Non-Staff"]
	{
		WebElement ele1 = driver.findElement(By.xpath("//input[@value="+key+"]"));
		ele1.click();
	}
	
	public void PPT(String key)
	{
		WebElement ele1 = driver.findElement(By.xpath("(//div[@class='slider-tick-container'])[1]//div["+key+"]"));
		ele1.click();
	}
	
	public void PremiumFrequency(String key)
	{
		WebElement ele1 = driver.findElement(By.xpath("(//div[@class='slider-tick-container'])[2]//div["+key+"]"));
		ele1.click();
	}
	
	@FindBy(xpath="//input[@id=\"prmAmtVal\"]")
	private WebElement premiumamount;
	
	public void Premium_Amount()
	{
		premiumamount.sendKeys("250000");
	}
	
	@FindBy(xpath="//input[@id=\"sumAssurVal\"]")  // to verify same premium amount is displayed in sum assured
	private WebElement sumAssured;
	
	public String Sum_Assured()
	{
		return sumAssured.getText();
	}
	
	public void riderCheckbox(String key)
	{
		WebElement ele = driver.findElement(By.xpath("(//input[@class=\"rider-checkbox\"])["+key+"]"));
		ele.click();
	}
}
