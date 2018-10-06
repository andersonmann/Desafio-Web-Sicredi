package test;

import static core.DriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import core.BaseTest;
import page.CustomerPage;
import page.HomePage;

public class CustomerTest extends BaseTest {
	private static String url = "https://www.grocerycrud.com/demo/bootstrap_theme";
	private HomePage homePage;
	private CustomerPage customerPage;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage();
		customerPage = new CustomerPage();
		getDriver().get(url);
	}

	/*@DataProvider(name = "dataProvider")
	public static Object[][] credentials() {
		return new Object[][] { { "Teste Sicredi", "Teste", "Anderson Mann", "51 9999-9999", "Av Assis Brasil, 3970",
				"Torre D", "Porto Alegre", "RS", "91000-000", "BRASIL", "200" } };
	}*/

	@Test(dataProvider = "dataProvider")
	public void addCustomer(String name, String lastName, String contactFirstName, String phone, String addressLine1,
			String addressLine2, String city, String state, String postalCode, String country, String creditLimit) {
		customerPage.addCustomer(name, lastName, contactFirstName, phone, addressLine1, addressLine2, city, state,
				postalCode, country, creditLimit);
		assertEquals(customerPage.getMessageCreationSuccess(),
				"Your data has been successfully stored into the database");
	}

	@Test(dataProvider = "dataProvider")
	public void deleteCustomer(String name, String lastName, String contactFirstName, String phone, String addressLine1,
			String addressLine2, String city, String state, String postalCode, String country, String creditLimit)
			throws InterruptedException {
		customerPage.deleteCustomer(name, lastName, contactFirstName, phone, addressLine1, addressLine2, city, state,
				postalCode, country, creditLimit, "Teste Sicredi");
		assertEquals("Are you sure that you want to delete this record?", homePage.getMessageDeleteConfirmation());
		assertEquals("Your data has been successfully deleted from the database.", homePage.getMessageSuccess());
	}
}