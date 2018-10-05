/**
 * 
 */
package page;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;

/**
 * @author anderson.mann
 *
 */
public class CustomerPage extends BasePage {
	private HomePage home = new HomePage();

	public void addCustomer(String name, String lastName, String contactName, String phone, String address1,
			String address2, String city, String state, String postalCode, String country, String creditLimit) {
		home.selectVersionTheme_v4();
		home.clickButtonAddCustomer();
		fillPersonalInformations(name, lastName, contactName, phone, address1, address2, city, state, postalCode,
				country, creditLimit);
		employerSelect();
		clickButtonSave();
	}

	public void fillPersonalInformations(String name, String lastName, String contactName, String phone,
			String address1, String address2, String city, String state, String postalCode, String country,
			String creditLimit) {
		dsl.write(By.name("customerName"), name);
		dsl.write(By.id("field-contactLastName"), lastName);
		dsl.write(By.id("field-contactFirstName"), contactName);
		dsl.write(By.id("field-phone"), phone);
		dsl.write(By.id("field-addressLine1"), address1);
		dsl.write(By.id("field-addressLine2"), address2);
		dsl.write(By.id("field-city"), city);
		dsl.write(By.id("field-state"), state);
		dsl.write(By.id("field-postalCode"), postalCode);
		dsl.write(By.id("field-country"), country);
		dsl.write(By.id("field-creditLimit"), creditLimit);
	}

	public void employerSelect() {
		dsl.click(By.id("field_salesRepEmployeeNumber_chosen"));
		dsl.click(By.cssSelector("#field_salesRepEmployeeNumber_chosen > div > ul > li:nth-child(8)"));
	}

	public void clickButtonSave() {
		dsl.click(By.id("form-button-save"));
	}

	public void clickButtonGoBackToList() {
		dsl.click(By.linkText("Go back to list"));
	}

	public void deleteCustomer(String name, String lastName, String contactName, String phone, String address1,
			String address2, String city, String state, String postalCode, String country, String creditLimit,
			String textSearch) throws InterruptedException {
		home.selectVersionTheme_v4();
		addCustomer(name, lastName, contactName, phone, address1, address2, city, state, postalCode, country,
				creditLimit);
		clickButtonGoBackToList();
		home.clickButtonSearch();
		home.fillSearch(textSearch);
		Thread.sleep(2000);
		home.deleteCustomer();
	}

	public String getMessageCreationSuccess() {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("report-success")));
			String texto = getDriver().findElement(By.id("report-success")).getText();
			String[] arrSplit = texto.split("\\.");
			return arrSplit[0];

		} catch (Exception e) {
			throw new NoSuchElementException("Element not found: " + e.getMessage());
		}
	}
}