
// Selenium Class 11.c:- July 16, 2023, Sunday with Instructor Shihabul Khandakar (Shibab) 

package nb_c11s9_Test_pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import nb_c11s9_Page_pkg.DashboardPage;
import nb_c11s9_Page_pkg.LoginPage;
import nb_c11s9_Util_pkg.BrowserFactory;


public class LoginTest {

	
	
	// smoke testing: checking whether major components are working as per expected 
		// testing left navigation pannel and validating them will be smoke testing
		// other buttons which are accessible/common to all the pages are tested under smoke testing
		// bascially the major functionalities which are seen and opened without going in depth into any specific pages
	
	// sanity is going in depth inside each specific pages and then checking if each of those newly added or old tabs inside that are funcitoning properly....
	
	// add customer test will be our regression
	
	
	// What to talk about when they ask us about these?
		// 1. Language: Java
		// 2. Project: Maven
		// 3. AFT TEsteng: Selenium
		// 4. Framework: Junit/TestNG
		// 5. Data Management: XML/Excel/
		// 6. Reporting: To/Extent Report
		// 7. Project Management: POM: where we save our dependencies so we have all the jar files we need for our testing using JUnit and TestNG
				// Apache POI: if we are simply just running with Maven project
				// XSSF when dealing with versions 7 or newer
				// XSSF is the POI Project's pure Java implementation of the Excel 2007 OOXML (.xlsx) file format.
				// HSSF when dealing with versions 7 or older
				// HSSF is the POI Project's pure Java implementation of the Excel '97(-2007) file format. 
	
	
	// ================================================================================================

	
	WebDriver driver;
	
	
	@Test
	@Parameters({"userName", "password", "dashboardValidationText"})
	public void validUserShouldBeAbleToLogin(String userName, String password, String dashboardValidationText) throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardValidationText);
		
		BrowserFactory.tearDown();
	}
	
	
}
	

