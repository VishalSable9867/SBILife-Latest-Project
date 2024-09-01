package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameFirst extends mainconstructor {

	WebDriver driver;
	public FrameFirst(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//iframe[@id='nv_leadform_content-iframe_2940']")
	private WebElement frame1;
	
	public WebElement frame12()
	{
		return frame1;
	}
}
