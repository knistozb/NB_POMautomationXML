
// Selenium Class 11.b:- July 16, 2023, Sunday with Instructor Shihabul Khandakar (Shibab) 


package nb_c11s9_Page_pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {



	// Types of Testing:
		// 1. Unit Testing: I never had to do this particular one because our DevOps used to perform this.
		
		// Others: Stress, Load, Escability, 
			// we need tools like Jmeter, LoadRunner, etc. 
	
	// Every application has 3 phases: front, middle tier, and back end:
		// 1. Functional Testing: Functional testing is a type of testing that seeks to establish whether each application feature works as per the software requirements. 
					// Each function is compared to the corresponding requirement to ascertain whether its output is consistent with the end user's expectations.
		// 2. Regression is done to ensure front end...
		// 3. if your team is running from front to end then, it is called end to end... End-to-end testing (E2E testing) is a testing method that evaluates the entire application flow, from start to finish. 
			// It ensures that all components work as expected and the software application functions correctly in real-world scenarios.
	
	
	
	// Smoke testing is performed to ascertain that the acute functionalities of the program are operating properly. 
	// Sanity testing is done to check that bugs have been fixed after the build. This is done before running deep into the application. 
		// Smoke testing can be documented and scripted. while Sanity testing can't be documented and is unscripted.
	
	
	
	
	
	// ================================================================================================

	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]" ) WebElement USER_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]" ) WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/form/div[3]/button" ) WebElement Sign_In_Element;
	
	
	// we need to identify our intractable methods:
	public void insertUserName(String userName) {	
		USER_NAME_ELEMENT.sendKeys(userName);
	}
	
	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	
	public void clickOnSignInButton() {
		Sign_In_Element.click();
	}
	
	// Combining Method:
	public void performLogin(String userName, String password) {
		
		USER_NAME_ELEMENT.sendKeys(userName);
		PASSWORD_ELEMENT.sendKeys(password);
		Sign_In_Element.click();	
	}
	
		
}
	


