/**
 * 
 */
package core;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	/********* TextField e TextArea ************/

	/**
	 * Find an element and perform writing in the field
	 * 
	 * 
	 * @param By    Type of locator used for search (Ex: id, name,
	 *              xpath,cssSelector)
	 * @param texto Text to be written in the field
	 */

	public void write(By by, String texto) throws NoSuchElementException {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			getDriver().findElement(by).sendKeys(texto);
		} catch (Exception e) {
			throw new NoSuchElementException("Element not found: " + e.getMessage());
		}
	}

	/********* Button ************/

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

	/********* Obter valor campo ************/

	public String obterValueElemento(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}

	/********* Combo ************/

	public void selecionarCombo(By by, String valor) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		// combo.selectByVisibleText(valor);
		combo.selectByValue(valor);
	}

	public void selecionarCombo2(By by) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		// combo.selectByVisibleText(valor);
		combo.selectByIndex(8);

	}

	public void selecionarCombo3(By by, String valor) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	/********* Texts ************/

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

	/********* Frames e Janelas ************/

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

//	public Object executarJS(String cmd, Object... param) {
//		JavascriptExecutor js = (JavascriptExecutor) getDriver();
//		return js.executeScript(cmd, param);
//	}

//	public String executeJS(String cmd, Object... param) {
//		JavascriptExecutor js = (JavascriptExecutor) getDriver();
//		return (String) js.executeScript(cmd, param);
//	}

	public String executeJS(String cmd) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return (String) js.executeScript(cmd);
	}

}
