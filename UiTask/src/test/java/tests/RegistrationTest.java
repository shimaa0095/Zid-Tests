package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

//import java.io.IOException;

//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ahmed.excelizer.ExcelReader;

import pom.BaseClass;
import pom.RegistrationPage;

public class RegistrationTest {
	private String url = "https://web.zid.sa/register";
	private static String fileName = "\\data\\registeration_data.xlsx";


	@DataProvider(name = "DataProviderForusers")
	public Object[][] useraData() {
		return ExcelReader.loadTestData(System.getProperty("user.dir") + fileName,
				"Sheet1");
	}

	@BeforeMethod
	public void beforeClass() {
		BaseClass localBaseClass = new BaseClass();
		localBaseClass.setUpChromeDriver(url);
	}

	@Test(dataProvider = "DataProviderForusers")
	public void testRegisteration(String name, String phone, String email, String password, String storeNameE,
			String storeNameA, String productType , String haveBusiness,
			String businessCode, String expectedResult, String indicatorCode) throws IOException, InterruptedException {
		
		RegistrationPage registerationPage = new RegistrationPage();
		registerationPage.clickOnNextButton(name,phone,email,password);
		registerationPage.clickOnSignButton(storeNameE,storeNameA,productType,haveBusiness,businessCode);
		String actaulResult=registerationPage.getRegistratinActualResult(indicatorCode);
		assertTrue(actaulResult.contains(expectedResult));
//		
//		System.out.println(expectedResult);
//		System.out.println(indicatorCode);
//		System.out.println(actaulResult);
	}

	@AfterMethod
	public void endOfTest() {
		BaseClass.getWebDriver().close();
	}

}
