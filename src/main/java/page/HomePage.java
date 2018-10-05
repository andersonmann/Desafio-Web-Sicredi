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
		dsl.selectOption(By.className("switch-version"), "bootstrap_theme_v4");
	}

	public void clickButtonAddCustomer() {
		dsl.click(By.cssSelector("#gcrud-search-form > div.header-tools > div.floatL.t5 > a"));
	}

	public void clickButtonSearch() {
		dsl.click(By.cssSelector(
				"#gcrud-search-form > div.header-tools > div.floatR > a.btn.search-button.t5.btn-primary"));
	}

	public void fillSearch(String text) {
		dsl.writeFieldSearch(text);
//		WebElement textbox = getDriver().findElement(By.name("search"));
//		textbox.sendKeys(text, Keys.ENTER);
	}

	public void deleteCustomer() throws InterruptedException {
		dsl.click(By.xpath("//tbody//tr[1]//td[2]//div[1]//div[1]//button[1]"));
		dsl.click(By.xpath("//div[@class='btn-group open']//a[@title='Delete']"));
		dsl.switchTo(0);
		dsl.click(By.xpath(
				"//div[@class='delete-confirmation modal fade in show']//button[@type='button'][contains(text(),'Delete')]"));
	}

	public String getMessageSuccess() {
		return dsl.getText(By.cssSelector(
				"body > div.alert.alert-success.growl-animated.animated.bounceInDown > span:nth-child(4) > p"));
	}

	public String getMessageDeleteConfirmation() {
		return dsl.getText(By.cssSelector(
				"body > div.container-fluid.gc-container > div.row > div.delete-confirmation.modal.fade.in.show > div > div > div.modal-body > p"));
	}
}