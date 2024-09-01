package Page_Objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homepage extends mainconstructor {
	WebDriver driver;
	public homepage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//li//h3[contains(text(),'PRODUCTS')]")  // to mouseover action need getter method
	private WebElement product;
	
	public WebElement product_Btn()
	{
		return product;
	}
	
//	@FindBy(xpath="//h3[@class='navbar-menu-header']")
//	private List<WebElement> firstnav;
//	
//	public List<WebElement> firstnav_selection()
//	{
//		return firstnav;
//	}
//	
	@FindBy(xpath="//a[text()='Individual Life Insurance Plans']")
	private WebElement individualplan;
	
	public WebElement individual_plans()
	{
		return individualplan;
	}
	
   @FindBy(xpath="(//ul[@class='sub-menus'])[2]//li")
   private List<WebElement> plans;
   
    public List<WebElement> plans_selection()
    {
    	return plans;
    }
	
	@FindBy(xpath="//*[@id=\"sub-menus-wrapper-2\"]/div/div/ul/li[1]/div/div/div[1]/a/p")
	private WebElement mainproductname;
	
	public WebElement mainproduct()
	{
		return mainproductname;
	}
	
	public void mainproductdynamicxpath(String key,WebDriver driver)
	{
		WebElement optn = driver.findElement(By.xpath("//*[@id=\"sub-menus-wrapper-2\"]/div/div/ul/li[1]/div/div/div["+key+"]/a/p"));
		optn.click();
	}
	
//	@FindBy(xpath="//*[@id=\"sub-menus-wrapper-2\"]/div/div/ul/li[1]/div/div/div[1]/div/div//child::p")
//	private List<WebElement> online_prod;
//	
//	public List<WebElement> onlineplans()
//	{
//		return online_prod;
//	}
	
	@FindBy(xpath="//h2[@class='insurance-card-name']")
	private List<WebElement> subproduct;
	
	public List<WebElement> subproduct_List()
	{
		return subproduct;
	}
}