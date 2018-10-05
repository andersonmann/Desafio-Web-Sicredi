package test;

import static core.DriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.BaseTest;
import page.CustomerPage;
import page.HomePage;

public class CustomerTest extends BaseTest {
	private HomePage homePage;
	private CustomerPage customerPage;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage();
		customerPage = new CustomerPage();
		getDriver().get(Messages.getString("HomeTest.0"));
	}

	@Test
	public void addCustomer() throws InterruptedException {
		customerPage.addCustomer("Teste Sicredi", "Teste", "Anderson Mann", "51 9999-9999", "Av Assis Brasil, 3970",
				"Torre D", "Porto Alegre", "RS", "91000-000", "BRASIL", "200");
		assertEquals(customerPage.getMessageCreationSuccess(),
				"Your data has been successfully stored into the database");
	}

	@Test
	public void deleteCustomer() throws InterruptedException {
		customerPage.deleteCustomer("Teste Sicredi", "Teste", "Anderson Mann", "51 9999-9999", "Av Assis Brasil, 3970",
				"Torre D", "Porto Alegre", "RS", "91000-000", "BRASIL", "200", "Teste Sicredi");
		assertEquals("Are you sure that you want to delete this record?", homePage.getMessageDeleteConfirmation());
		// String message = homePage.pegaTextoUltimaMSG(); message
		assertEquals("Your data has been successfully deleted from the database.", homePage.getMessageSuccess());
	}
}