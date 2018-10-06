/**
 * 
 */
package core;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Anderson
 *
 */
public class DSL {

	/**
	 * Find an element and perform writing in the field
	 * 
	 * 
	 * @param By     Type of locator used for search (Ex: id, name,
	 *               xpath,cssSelector)
	 * @param String Text to be written in the field
	 */

	public void write(By by, String value) throws NoSuchElementException {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			getDriver().findElement(by).sendKeys(value);
		} catch (Exception e) {
			throw new NoSuchElementException("Element not found: " + e.getMessage());
		}
	}

	/**
	 * Find search field and writing
	 * 
	 * @param String Text to be written in the field
	 */
	public void writeFieldSearch(String value) {
		WebElement textbox = getDriver().findElement(By.name("search"));
		textbox.sendKeys(value, Keys.ENTER);
	}

	/**
	 * Find an element and click
	 * 
	 * @param By Type of locator used for search (Ex: id, name, xpath,cssSelector)
	 */
	public void click(By by) throws NoSuchElementException {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 15);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));			
			getDriver().findElement(by).click();
		} catch (Exception e) {
			throw new NoSuchElementException("Element not found: " + e.getMessage());
		}
	}

	public void clickByText(String texto) {
		click(By.xpath("//*[@text='" + texto + "']"));
	}

	/**
	 * Find an element and select
	 * 
	 * 
	 * @param By     Type of locator used for search (Ex: id, name,
	 *               xpath,cssSelector)
	 * @param String Text to be select
	 */
	public void selectOption(By by, String valor) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		combo.selectByValue(valor);
	}

	/**
	 * Find an element and select
	 * 
	 * 
	 * @param By      Type of locator used for search (Ex: id, name,
	 *                xpath,cssSelector)
	 * @param Integer to be select
	 */
	public void selectOptionByIndex(By by) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		combo.selectByIndex(8);
	}

	/**
	 * Find an element and get the message
	 * 
	 * @param By Type of locator used for search (Ex: id, name, xpath,cssSelector)
	 */
	public String getText(By by) throws NoSuchElementException {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			// wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return getDriver().findElement(by).getText();
		} catch (Exception e) {
			throw new NoSuchElementException("Element not found: " + e.getMessage());
		}
	}

	/********* Frames ************/

	public void enterFrame(String id) {
		getDriver().switchTo().frame(id);
	}

	public void exitFrame() {
		getDriver().switchTo().defaultContent();
	}

	public void switchTo(int value) {
		getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[value]);

	}

	public boolean isElementPresent(By locatorKey) {
		try {
			getDriver().findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	/********* Pages ************/

	public String actualPage() {
		return getDriver().getCurrentUrl();
	}
}
