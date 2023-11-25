
// Selenium Class 11.e:- July 16, 2023, Sunday with Instructor Shihabul Khandakar (Shibab) 


package nb_c11s9_Page_pkg;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

	
	
	
	
	
	// ==========================================================================

	
	public void validateElement(String actualText, String expectedText, String errorMessage) {
		
		Assert.assertEquals(actualText, expectedText, errorMessage);
	}
	
	private void assertValidation(WebElement elementPath, String validatingHeaderText, String assertMsg) {

		Assert.assertEquals(elementPath.getText(), validatingHeaderText, assertMsg);	
	}
	
	public void webExpWait(WebDriver driver, int waitTime, By visibleText) {

		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(visibleText));			
	}
	
	public int randomNumGenerator(int bound) {  
		
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(bound);   
		return generatedNum;						
	}
	
	public void selectDropdown(WebElement elementPath, String visibleText) {

		Select sel = new Select(elementPath);
		sel.selectByVisibleText(visibleText);
	}
	
}
