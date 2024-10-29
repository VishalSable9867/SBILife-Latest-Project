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
	
	@FindBy(xpath="//p[text()='Name(Assured):']")
	private WebElement name;
	
	public WebElement nameScroll()
	{
		return name;
	}
	
	@FindBy(xpath="//input[@id='pName']")
	private WebElement firstname;
	
	public void First_Name(String value)
	{
		 firstname.sendKeys(value);;
	}
	
	@FindBy(xpath="//input[@id='birthDate3']")
	private WebElement DOB;
	
	public void Date_Birth(String dob)
	{
		DOB.sendKeys(dob);
	}
	
	public void Gender(WebDriver driver,String key)     ////input[@value="Third Gender"]
	{
		WebElement ele = driver.findElement(By.xpath("//input[@id='imp-"+key+"']"));
		ele.click();
	}
	
	public void staffAndNonStaff(WebDriver driver,String key)   //input[@value="Non-Staff"]
	{
		WebElement ele1 = driver.findElement(By.xpath("//input[@id='imp-"+key+"']"));
		ele1.click();
	}
	
	@FindBy(xpath="//p[text()='Policy Term']")
	private WebElement PT;
	
	public WebElement policyTermScoll()
	{
		return PT;
	}
	@FindBy(xpath="(//div[@class='tooltip tooltip-main bottom in']//div)[2]")
	private WebElement policyTermValue;
	
	public WebElement policyTermValueMatch()
	{
		return policyTermValue;
	}
	
	@FindBy(xpath="(//div[@class='slider-handle min-slider-handle round'])[1]")
	private WebElement policyTerm;
	
	public WebElement policyTermSlider()
	{
		return policyTerm;
	}
	
	public void policy_Term(String key)
	{
		WebElement PT=driver.findElement(By.xpath("//div[@class='slider slider-horizontal']//div[normalize-space()='"+key+"']"));
		PT.click();
	}
	
	@FindBy(xpath="(//div[@class='slider-handle min-slider-handle round'])[2]")
	private WebElement sliderPremiumFrequency;
	
	public WebElement premiumFrequencySlider()
	{
		return sliderPremiumFrequency;
	}
	
	public WebElement PremiumFrequency(WebDriver driver,String key)
	{
		WebElement Frequencyvalue = driver.findElement(By.xpath("//div[normalize-space()='"+key+"']"));
		return Frequencyvalue;
	}
	
	public void planOptions(WebDriver driver,String key)
	{
		WebElement optn = driver.findElement(By.xpath("//input[@value='"+key+"']"));
		optn.click();
	}
	
	@FindBy(xpath="//input[@id='prmAmtVal']")  // to verify same premium amount is displayed in sum assured
	private WebElement sumAssured;
	
	public WebElement Sum_Assured()
	{
		return sumAssured;
	}
	
	public void riderCheckbox(WebDriver driver,String key)
	{
		WebElement ele = driver.findElement(By.xpath("(//input[@class=\"rider-checkbox\"])["+key+"]"));
		ele.click();
	}
	
	@FindBy(xpath="(//div[@class='slider-block-row slider-block-row-mobile']//h3//span)[1]")
	private WebElement riderScroll;
	
	public WebElement riderScrollView()
	{
		return riderScroll;
	}
	
	@FindBy(xpath="//button[text()='Calculate']")
	private WebElement calculate;
	
	public void calculate_Btn()
	{
		calculate.click();
	}
	
	@FindBy(xpath="//div[@id='errorModal']//button[@type='button'][normalize-space()='Close']")
	private WebElement close;
	
	public WebElement close_btn()
	{
		return close;
	}
	
	@FindBy(xpath="//span[@id='nv_js-leadform-close-button_3481']")
	private WebElement cls;
	
	public WebElement close_popup()
	{
		return cls;
	}
	
	@FindBy(xpath="//input[@id='prmAmtVal']")
	private WebElement premium_Amount;
	
	public void premium_Amount()
	{
		premium_Amount.click();
	}
}
