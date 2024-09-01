package TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.readFromProperties;

public class baseClass extends readFromProperties {
	
	public static WebDriver driver;
	public Logger logger;   // to configure  the logger file  log4j.logger packages

	@Parameters("browser")
	@BeforeClass
	public void Open(String br) throws IOException
	{
		logger = LogManager.getLogger(this.getClass());// to get the log of running class so use this keyword
		
		switch(br.toLowerCase())
		{
		case "chrome" : ChromeOptions option = new ChromeOptions();
		                option.addArguments("----disable-notifications");
			            driver = new ChromeDriver(option); 
		                break;
		case "firefox": FirefoxOptions option1 = new FirefoxOptions();
		                option1.addArguments("----disable-notifications");
			            driver = new FirefoxDriver(option1);
		                break;
		case "edge"   : EdgeOptions options= new EdgeOptions();
		                options.addArguments("----disable-notifications");
			            driver = new EdgeDriver(options);
		                break;
        default       : System.out.println("Not browser Found!"); 
                        return; 
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(readData("URL"));
		driver.manage().window().maximize();
	}
	@AfterClass
	public void Close()
	{
		driver.close();
	}
	
	public void mouseover(WebDriver driver,WebElement ele)   // to move to element for this want getter method
	{
		Actions a =new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
	public List<WebElement> productSelection(List<WebElement> elm, String txt)  // to iterate the options and get list and click on wanted plan
	{
		for(int i=0; i<elm.size(); i++)
		{
			if(elm.get(i).getText().equals(txt))
			{
				elm.get(i).click();
				break;
			}
		}
		return elm;
	}
	
	public String capturescreenshot(String tname) throws IOException
	{
	    Date date=new Date();
		String formattedDate = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(date);
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"/screenshots1/" + tname+"_"+formattedDate+".png";
		File targetFile=new File(targetFilePath);
		// Files.move(sourceFile, targetFile);
		//sourceFile.renameTo(targetFile);
		//FileUtils.copyFile(sourceFile, targetFile);
		try {
            FileUtils.copyFile(sourceFile, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null in case of failure
        }
		return targetFilePath;
	}
	
	public void scroll(WebDriver driver, WebElement elm)   // to scroll the page only webelement is require not list of webelement and getter method is required
	{
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true)", elm);
	}
	
	public void expilcitWait(WebDriver driver,int time,WebElement webElement)  // explicit wait for webelement
	{
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	public void expilcitWait1(WebDriver driver,int time,List<WebElement> webElement)   // explicit wait for list of webelement
	{
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
	}
//	public void explicitwaitpopup(WebDriver driver,int time1,WebElement frameElement)
//	{
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(time1));
//		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
//	}
	
	public void switchToDefaultContent(WebDriver driver) {
	       driver.switchTo().defaultContent();
	   }
		
	public void switchToFrame(WebElement frameElement, WebDriver driver) {
	    // Wait and switch to the frame using explicit wait
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	
	public void slider(WebDriver driver, WebElement ele1)
	{
		Actions a  = new Actions(driver);
		a.clickAndHold(ele1).moveByOffset(70030000, 0).release().perform();
	}
	
	public void slidermove(WebElement ele,String user,String txt)
	{
		for(int i=0; i<=100; i++)
		{
			Actions a = new Actions(driver);
			a.click(ele).dragAndDropBy(ele,i,0).perform();
			if(txt.equals("user"))
			{
				a.release(ele).perform();
				break;
			}
		}
	}


}
