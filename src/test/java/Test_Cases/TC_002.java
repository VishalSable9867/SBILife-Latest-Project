package Test_Cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class TC_002 {

	public static void main(String[] args) {
		
		ChromeOptions options =  new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.sbilife.co.in/en/individual-life-insurance/traditional/shubh-nivesh");
		WebElement premium = driver.findElement(By.xpath("//p[text()='Premium Frequency']"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", premium);
		
		WebElement slider = driver.findElement(By.xpath("(//div[@class='slider-handle min-slider-handle round'])[2]"));
		WebElement frequency=driver.findElement(By.xpath("//div[normalize-space()='Monthly SI/CC']"));
		
		Actions a = new Actions(driver);
		a.clickAndHold(slider).moveToElement(frequency).release().perform();
		
		WebElement closewindow = driver.findElement(By.xpath("//span[@id='nv_js-leadform-close-button_3481']"));
		js.executeScript("arguments[0].click();", closewindow);
		
		WebElement slider2=driver.findElement(By.xpath("(//div[@class='slider-handle min-slider-handle round'])[1]"));
		WebElement tg = driver.findElement(By.xpath("//p[text()='Policy Term']"));
		js.executeScript("arguments[0].scrollIntoView(true);", tg);
		for(int i=1; i<=100; i++)
		{
			a.clickAndHold(slider2).dragAndDropBy(slider2, i, 0).perform();
			WebElement text1 = driver.findElement(By.xpath("(//div[@class='tooltip tooltip-main bottom in']//div)[2]"));
			String actualtext=text1.getText();
			if(actualtext.equals("19"))
			{
				a.release(slider2).perform();
				break;
			}
		}
		

	}

}
