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
	 * Encontra um elemento e realiza a escrita no campo
	 * 
	 * 
	 * @param By
	 *            Tipo do locator utilizado para a busca (Ex: id, name,
	 *            xpath,cssSelector)
	 * @param texto
	 *            Texto que serï¿½ escrito no campo *
	 */
	public void escrever(final By by, String texto) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement waitingElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		});
		waitingElement.sendKeys(texto);
	}

	public void escreverById(String id_campo, String texto) {
		escrever(By.id(id_campo), texto);
	}

	public void escreverByName(String nome_campo, String texto) {
		escrever(By.name(nome_campo), texto);
	}

	public void escreverByXpath(String xpath_campo, String texto) {
		escrever(By.xpath(xpath_campo), texto);
	}

	public void escreverByCssLocator(String css_locator, String texto) {
		escrever(By.xpath(css_locator), texto);
	}
	
	public void write(By by, String texto) throws NoSuchElementException {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			getDriver().findElement(by).sendKeys(texto);
		} catch (Exception e) {
			throw new NoSuchElementException("Element not found: " + e.getMessage());
		}
	}

	/********* Botao ************/

	/**
	 * Encontra um elemento e clica. *
	 * 
	 * @param By
	 *            Tipo do locator utilizado para a busca (Ex: id, name,
	 *            xpath,cssSelector)
	 */

	public void clicarBotao(final By by) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement waitingElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		});
		waitingElement.click();
	}

	public void clicarBotaoById(String id) {
		clicarBotao(By.id(id));
	}
	
	
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


	public void clicarBotaoByXpath(final String xpath) {
		clicarBotao(By.xpath(xpath));
	}

	public void clicarBotaoByClass(String classe) {
		clicarBotao(By.className(classe));
	}

	public void clicarCssSelector(final String selector) {
		clicarBotao(By.cssSelector(selector));
	}

	/********* Obter valor campo ************/

	public String obterValueElemento(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}

	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}

	/********* Radio e Check ************/

	public void clicarRadio(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public boolean isRadioMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}

	public void clicarCheck(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public boolean isCheckMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}

	/********* Combo ************/

	public void selecionarCombo(By by, String valor) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		//combo.selectByVisibleText(valor);
		combo.selectByValue(valor);
	}
	
	public void selecionarCombo2(By by) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		//combo.selectByVisibleText(valor);
		combo.selectByIndex(8);
	
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

	public String obterTexto(final By by) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement waitingElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		});
		return waitingElement.getText();
	}

	public String obterTextoById(String id) {
		return obterTexto(By.id(id));
	}

	public String obterTextoByXpath(String xpath) {
		return obterTexto(By.xpath(xpath));
	}

	public String obterTextoByClassName(String className) {
		return obterTexto(By.className(className));
	}
	
	public String getText(By by) throws NoSuchElementException {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
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

	public void trocarJanela(String id) {
		getDriver().switchTo().window(id);
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

	public String retornaPaginaAtual() {
		return getDriver().getCurrentUrl();
	}

}
