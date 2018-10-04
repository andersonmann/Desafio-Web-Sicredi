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
	private static final String urlHome = "https://www.grocerycrud.com/demo/bootstrap_theme";

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage();
		customerPage = new CustomerPage();
		getDriver().get(urlHome);
	}

	@Test
	public void addCustomer() throws InterruptedException {
		customerPage.addCustomer("Teste Sicredi", "Teste", "Anderson Mann", "51 9999-9999", "Av Assis Brasil, 3970",
				"Torre D", "Porto Alegre", "RS", "91000-000", "BRASIL", "200");

		esperar(3000);
		assertEquals(homePage.getText(), "Your data has been successfully stored into the database.");
//		equals(js.executeScript("document.querySelector(\"#report-success\").children[0].childNodes[0].data",
//				"Your data has been successfully stored into the database."));
	}
	

}
