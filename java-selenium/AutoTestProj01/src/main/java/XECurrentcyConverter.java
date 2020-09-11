import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XECurrentcyConverter {

	public static void main(String[] args) {
		System.out.println("Hello");
		WebDriver driver=null;
		System.setProperty("webdriver.chrome.driver", "/Users/murugepx/drivers/chromedriver");
		driver=new ChromeDriver();
		driver.get("https://xe.com");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait driverWait= new WebDriverWait(driver, 30);

		String xpathToCurrencyDropDown="//form/div/label[text()='To']/following-sibling::div[contains(@class,'converterform-dropdown')]";
		String xpathFocussedCurrencyDropDownValue="//div[contains(@class,'converterform-dropdown__control--is-focused')]/div[contains(text(),'Type to search...')]//descendant::input";
		String xpathFromCurrencyDropDown="//form/div/label[text()='From']/following-sibling::div[contains(@class,'converterform-dropdown')]";
		String xpathAmount="//input[@name='Amount']";
		String xpathSubmitButton="//button[@type='submit']";
		String xpathResult="//span[@class='converterresult-toAmount']";
		
		String currencyFrom="GBP";
		String currencyTo="INR";
		String amountIn="100";
		String amountOut=null;
		
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathToCurrencyDropDown)));
		WebElement elementToCurrencyDropdown=driver.findElement(By.xpath(xpathToCurrencyDropDown));		
		elementToCurrencyDropdown.click();
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathFocussedCurrencyDropDownValue)));
		WebElement elementToCurrencyDropdownValue=driver.findElement(By.xpath(xpathFocussedCurrencyDropDownValue));
		elementToCurrencyDropdownValue.sendKeys(currencyTo);
		elementToCurrencyDropdownValue.sendKeys(Keys.ENTER);
		
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathFromCurrencyDropDown)));
		WebElement elementFromCurrencyDropdown=driver.findElement(By.xpath(xpathFromCurrencyDropDown));		
		elementFromCurrencyDropdown.click();
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathFocussedCurrencyDropDownValue)));
		WebElement elementFromCurrencyDropdownValue=driver.findElement(By.xpath(xpathFocussedCurrencyDropDownValue));
		elementFromCurrencyDropdownValue.sendKeys(currencyFrom);
		elementFromCurrencyDropdownValue.sendKeys(Keys.ENTER);
		
		WebElement elementInputAmount=driver.findElement(By.xpath(xpathAmount));
		elementInputAmount.sendKeys(amountIn);
		
		WebElement elementSubmitButton=driver.findElement(By.xpath(xpathSubmitButton));
		elementSubmitButton.click();

		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathResult)));
		WebElement elementResult=driver.findElement(By.xpath(xpathResult));
		amountOut=elementResult.getText();
		
		System.out.println(amountIn+" "+currencyFrom+" = "+amountOut+" "+currencyTo);
		
		driver.close();

	}

}



