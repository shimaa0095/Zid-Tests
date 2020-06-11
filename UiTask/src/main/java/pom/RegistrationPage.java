package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	public void clickOnNextButton(String name,String phone, String email, String passW) {
		WebDriver driver = BaseClass.getWebDriver();

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.id("name")).sendKeys(name);
		//driver.findElement(By.id("country_code")).click();
		driver.findElement(By.id("mobile")).sendKeys(phone);
		driver.findElement(By.id("registration_email")).sendKeys(email);
		driver.findElement(By.id("registration_password")).sendKeys(passW);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/div/div[1]/div/div/div[5]/button")).click();
	}
	
	public void clickOnSignButton(String storeNameE, String storeNameA, 
			String productType, String ownbusiness, String  businessCode) {
		
		WebDriver driver = BaseClass.getWebDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.id("store_username")).sendKeys(storeNameE);
		driver.findElement(By.id("store_name")).sendKeys(storeNameA);
		Select drpProductType=new Select(driver.findElement(By.id("store_category_id")));
		drpProductType.selectByVisibleText(productType);
		if(ownbusiness.contains("نعم")) {
			driver.findElement(By.id("started_business_before_registration_yes")).click();
		}
		else if(ownbusiness.contains("لا")){
			driver.findElement(By.id("started_business_before_registration_no")).click();
		}
		driver.findElement(By.id("registration_discount_code")).sendKeys(businessCode);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/div/div[2]/div/div/div[7]/div/button")).click();
	
	}

	public String getCurrentSiteUlr() {
		WebDriver driver = BaseClass.getWebDriver();
		String currentUrl=driver.getCurrentUrl();
        return currentUrl;
	}
	
	public String getNameVerificationMessg() {
		WebDriver driver = BaseClass.getWebDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String errorMessg= driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/div/div[1]/div/div/div[1]/span/strong")).getText(); 
	    return errorMessg;
	}
	public String getPhoneVerificationMessg() {
		WebDriver driver = BaseClass.getWebDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		return driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/div/div[1]/div/div/div[2]/span/strong")).getText(); 
	} 
	public String getEmailVerificationMessg() {
		WebDriver driver = BaseClass.getWebDriver();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		return driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/div/div[1]/div/div/div[3]/span/strong")).getText(); 
	} 
	public String getPasswordVerificationMessg() {
		WebDriver driver = BaseClass.getWebDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		return driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/div/div[1]/div/div/div[4]/span/strong")).getText(); 
	} 
	public String getEStoreNameVerificationMessg() {
		WebDriver driver = BaseClass.getWebDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		return driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/div/div[2]/div/div/div[1]/span")).getText(); 
	}
	public String getAStoreNameVerificationMessg() {
		WebDriver driver = BaseClass.getWebDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		return driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/div/div[2]/div/div/div[2]/span/strong")).getText(); 
	} 
	
	public String getOwnBussinessVerificationMessg() {
		WebDriver driver = BaseClass.getWebDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		return driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/div/div[2]/div/div/div[5]/div/span[2]/strong")).getText(); 
	}
	public String getRegistratinActualResult(String indicatorCode) {
		String actualResult;
		if (indicatorCode.contentEquals("0")) {
			actualResult=getCurrentSiteUlr();
		}
		else if(indicatorCode.contentEquals("1")) {
			actualResult=getNameVerificationMessg();
		}
		else if(indicatorCode.contentEquals("2")) {
			actualResult=getPhoneVerificationMessg();
		}
		else if(indicatorCode.contentEquals("3")) {
			actualResult=getEmailVerificationMessg();
		}
		else if(indicatorCode.contentEquals("4")) {
			actualResult=getPasswordVerificationMessg();
		}
		else if(indicatorCode.contentEquals("5")) {
			actualResult=getEStoreNameVerificationMessg();
		}
		else if(indicatorCode.contentEquals("6")) {
			actualResult=getAStoreNameVerificationMessg();
		}
		else {
			actualResult=getOwnBussinessVerificationMessg();
		}
		System.out.println(actualResult);
		return actualResult;
	}	
}


