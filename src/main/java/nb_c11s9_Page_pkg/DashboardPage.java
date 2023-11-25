
// Selenium Class 11.d:- July 16, 2023, Sunday with Instructor Shihabul Khandakar (Shibab) 

package nb_c11s9_Page_pkg;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardPage extends BasePage {

	
	
	
	
	
	
	
	
	// ==========================================================================

	WebDriver driver;
	WebDriverWait wait;

	
	// parameterizing the constructor to save it under a variable and globally declare in this class
	public DashboardPage(WebDriver driver) {
			
		this.driver = driver;
	}

	// WebElements:
	@FindBy(how = How.XPATH, using = "//div[@id=\"page-wrapper\"]/div[2]/div/h2") WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Customers')]") WebElement Customer_Menu_Element;
	@FindBy(how = How.XPATH, using = "//ul[@id=\"side-menu\"]/li[3]/ul/li[1]/a") WebElement Add_Customer_Menu_Element;
	@FindBy(how = How.XPATH, using = "//ul[@id=\"side-menu\"]/li[3]/ul/li[2]/a") WebElement List_Customers_Menu_Element;

	
	public void validateDashboardPage(String expectedText) throws InterruptedException {
		Thread.sleep(2000);
		validateElement(DASHBOARD_HEADER_ELEMENT.getText(), expectedText, "Dashboard Page is not found!");
	}
	
	public void clickCustomerButton() {
		Customer_Menu_Element.click();
	}
	
	public void clickAddCustomer() {
		Add_Customer_Menu_Element.click();
	}
	
	public void clickOnListCustomersButton() throws InterruptedException {
		Thread.sleep(3000);
		List_Customers_Menu_Element.click();
	}
	
}
