package page;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import core.BasePage;

public class HomePage extends BasePage {

	public String getActualPage() {
		return dsl.actualPage();
	}

	public void selectVersionTheme_v4() {
		dsl.selecionarCombo(By.className("switch-version"), "bootstrap_theme_v4");
	}

	public void clickButtonAddCustomer() {
		dsl.click(By.cssSelector("#gcrud-search-form > div.header-tools > div.floatL.t5 > a"));
	}

	public void clickButtonSearch() {
		dsl.click(By.cssSelector(
				"#gcrud-search-form > div.header-tools > div.floatR > a.btn.search-button.t5.btn-primary"));
	}

	public void fillSearch(String text) {

		WebElement textbox = getDriver().findElement(By.name("search"));
		textbox.sendKeys(text, Keys.ENTER);
	}

	public void deleteCustomer() throws InterruptedException {
		// dsl.click(By.className("btn-group"));

		dsl.click(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/tbody/tr/td[2]/div[1]/div/button"));
		dsl.click(By.cssSelector(
				"#gcrud-search-form > div.scroll-if-required > table > tbody > tr > td:nth-child(2) > div.only-desktops > div > div > a.delete-row.dropdown-item > span"));

		// tambem funciona
		// dsl.click(By.cssSelector(
		// "body > div.container-fluid.gc-container > div.row >
		// div.delete-confirmation.modal.fade.in.show > div > div > div.modal-footer >
		// button.btn.btn-danger.delete-confirmation-button"));

		// clica botao DELETE
		dsl.click(By.xpath("//html/body/div[2]/div[2]/div[2]/div/div/div[3]/button[2]"));

	}

	public String pegaTextoUltimaMSG() {
		return dsl.getText(By.cssSelector(
				"body > div.alert.alert-success.growl-animated.animated.bounceInDown > span:nth-child(4) > p"));
	}

	public String pegaTexto() {
		return dsl.getText(By.cssSelector(
				"body > div.container-fluid.gc-container > div.row > div.delete-confirmation.modal.fade.in.show > div > div > div.modal-body > p"));
	}

	public String getText() {
		// return dsl.getText(By.xpath("//*[@id=\"report-success\"]/p/text()[1]")); //
		// NAO ENCONTRADO
		// return dsl.getText(By.id("report-success"));
		// return dsl.getText(By.cssSelector("#report-success"));
		// return dsl.getText(By.xpath("//*[@id=\"report-success\"]/p/text()[1]"));
		// return dsl.getText(By.xpath("//*[@id=\"report-success\"]/p")); //quase
		// return dsl.getText(By.tagName("p")); //quase

		// return dsl.getText(By.cssSelector("#report-success > p")); // quase

		// System.out.println(js.executeScript("document.querySelector(\"#report-success\").children[0].childNodes[0].data"));
		// document.querySelector("#report-success").children[0].childNodes[0].data

//		WebElement element = driver.findElement(By.id("elementosForm:nome"));
//		js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");

		// WebElement element = getDriver().findElement(By.cssSelector("#report-success
		// > p"));
//		return dsl.executeJS("document.querySelector(\"#report-success\").children[0].childNodes[0].data");

//		js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");

//		js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");

		/*
		 * js.
		 * executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'"
		 * ); js.
		 * executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'"
		 * );
		 * 
		 * WebElement element = driver.findElement(By.id("elementosForm:nome"));
		 * js.executeScript("arguments[0].style.border = arguments[1]", element,
		 * "solid 4px red");
		 * 
		 */

		// consulta LEO
		// document.querySelector("#report-success").children[0].childNodes[0].data

		// WebElement element = getDriver().findElement(By.cssSelector("#report-success
		// > p"));

		return dsl.executeJS("document.querySelector(\"#report-success\").children[0].childNodes[0].data).value");

	}

}
