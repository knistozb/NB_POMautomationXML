
// Selenium Class 11.g:- July 16, 2023, Sunday with Instructor Shihabul Khandakar (Shibab) 


package nb_c11s9_Page_pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListCustomersPage extends BasePage {

	
	
	
	
	
	
	// ==========================================================================

	
	
	WebDriver driver;
	WebDriverWait wait;

	
	// parameterizing the constructor to save it under a variable and globally declare in this class
	public ListCustomersPage(WebDriver driver) {	
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/table/thead/tr/th[2]") WebElement LIST_CUST_VALIDATION_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]") WebElement ADD_CUSTOMER_LIST_CUST_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"foo_filter\"]") WebElement SEARCH_BAR_LIST_CUST_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div[2]/button[2]") WebElement DELETE_OK_LIST_CUST_ELEMENT;

	
	public void clickOnAddCustomerOnListCustPage() throws InterruptedException {
		Thread.sleep(1500);
		ADD_CUSTOMER_LIST_CUST_ELEMENT.click();
	}
	
	public void validateImageOnListCustpage(String expectedText) throws InterruptedException {
		Thread.sleep(1500);
		validateElement(LIST_CUST_VALIDATION_ELEMENT.getText(), expectedText, "List Customer Page is not available!");
	}
	
	public void insertOnSearchBar () {
		SEARCH_BAR_LIST_CUST_ELEMENT.sendKeys(AddCustomerPage.getInsertedName());
	}
	
	
	
	// how to get different cells and rows from the excel table:
	// tbody/tr[1]/td[3]/a // to get row 1, cell 3
	// tbody/tr[2]/td[3]/a // to get row 2, cell 3
	// tbody/tr[3]/td[3]/a // to get row 3, cell 3
	// tbody/tr[i]/td[3]/a // for generic use

	// tbody/tr[1]/td[7]/a[2] // to get row 1, cell last one for delete button

	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]/a";
	String after_xpath_delete = "]/td[7]/a[2]";
	String after_xpath_profile = "]/td[7]/a[1]";

	
	public void validateInsertedNameThenDelete() throws InterruptedException {
		for (int i = 1; i <= 10; i++) {
			String actualName = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			if (actualName.contains(AddCustomerPage.getInsertedName())) {
				System.out.println("Inserted Name exists.");
				Thread.sleep(2000);
				driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
				/*
				 * Actions action = new Actions(driver);
				 * action.moveToElement(driver.findElement(By.xpath(before_xpath + i + after_xpath_delete))).click().build().perform();
				 */
			}
			break;
		}
	}
	
	public void validateInsertedNameOnSearchAndProfile() throws InterruptedException {
		
		for(int i = 1; i <=5; i++) {
			String actualName = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			if(actualName.contains(AddCustomerPage.getInsertedName())) {
				System.out.println("Inserted Name exists.");
				Thread.sleep(2000);
				driver.findElement(By.xpath(before_xpath + i + after_xpath_profile)).click();
				
			}
			break;
		}
	}
	
	public void clickOnOkButtonOnListCustPage() throws InterruptedException {
		Thread.sleep(2000);
		DELETE_OK_LIST_CUST_ELEMENT.click();
	}

}
