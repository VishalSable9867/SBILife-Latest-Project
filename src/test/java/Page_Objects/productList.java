package Page_Objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productList extends mainconstructor {
	
	WebDriver driver;
	public productList(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[@class='insurance-card-name']")
	private List<WebElement> productlist1;
	
	public List<WebElement> product_list_select()
	{
		return productlist1;
	}
	
//	@FindBy(xpath="//h2[text()='SBI Life - Smart Platina Assure']")   // to scroll the page only webelement is require not list of webelement and getter metho
//	private WebElement p2;
	
	public WebElement t1(WebDriver driver,String key)   // use to scroll the page dynamic scroll bown bar
	{
		WebElement pz = driver.findElement(By.xpath("//h2[text()='"+key+"']"));
		return pz;
	}
	
	
	public void productListDynamci(String key)
	{
		WebElement ele1 = driver.findElement(By.xpath("(//h2[@class='insurance-card-name'])["+key+"]"));
		ele1.click();
		
	}

}
