
// Selenium Class 11.e:- July 16, 2023, Sunday with Instructor Shihabul Khandakar (Shibab) 



package nb_c11s9_Test_pkg;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import nb_c11s9_Page_pkg.AddCustomerPage;
import nb_c11s9_Page_pkg.DashboardPage;
import nb_c11s9_Page_pkg.LoginPage;
import nb_c11s9_Util_pkg.BrowserFactory;


public class AddCustomerTest {

	
	
	
	
	// https://github.com/techfios-git/xmlProjectFeb23.git
	
	// =============================================================================
	
	
	WebDriver driver;
	
	
	@Test
	@Parameters({"userName", "password", "dashboardValidationText", "addCustomerValidationText", "fullName", "company", "email", "phone", "address", "city", "country", "state", "zip" })	
	public void userShouldBeAbleToAddCustomer(String userName, String password, String dashboardValidationText, String addCustomerValidationText, String fullName, String company, String email, String phone, String address, String city, String country, String state, String zip ) throws InterruptedException {
		
		// we need to relaunch this over again to first launch driver, then login, then validation which was already done previously
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.performLogin(userName, password);
		
		// validating dashboard page again and clicking on customers and clicking on add customer button
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardValidationText);
		dashboardPage.clickCustomerButton();
		dashboardPage.clickAddCustomer();
	
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddCustomerPage(addCustomerValidationText);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountry(country);
		addCustomerPage.clickOnSaveButton();
		
		dashboardPage.clickOnListCustomersButton();
		addCustomerPage.validateInsertedNameThenDelete();
		addCustomerPage.clickOnOkButton();
		
		BrowserFactory.tearDown();
		
	}
		
}
