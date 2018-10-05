/**
 * 
 */
package core;

import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

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

	

	/********* Radio e Check ************/

	public void clicarRadio(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public boolean isRadioMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
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

	public void deselecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	public String obterValorCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}

	public List<String> obterValoresCombo(String id) {
		WebElement element = getDriver().findElement(By.id("select"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for (WebElement opcao : allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}

	public int obterQuantidadeOpcoesCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}

	public boolean verificarOpcaoCombo(String id, String opcao) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for (WebElement option : options) {
			if (option.getText().equals(opcao)) {
				return true;
			}
		}
		return false;
	}

	/********* Link ************/

	public void clicarLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}

	public void clicarLinkByXpath(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();

	}

	/********* Textos ************/
	
	public String getText(By by) throws NoSuchElementException {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			//wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return getDriver().findElement(by).getText();
		} catch (Exception e) {
			throw new NoSuchElementException("Element not found: " + e.getMessage());
		}
	}

	/********* Alerts ************/

	public String alertaObterTexto() {
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}

	public String alertaObterTextoEAceita() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}

	public String alertaObterTextoENega() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
	}

	public void alertaEscrever(String valor) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}

	/********* Frames e Janelas ************/

	public void entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}

	public void sairFrame() {
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
