package test;

import static core.DriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.BaseTest;
import page.CustomerPage;
import page.HomePage;

public class HomeTest extends BaseTest {
	private HomePage homePage;
	private CustomerPage customerPage;

	private static final String urlHome = "https://www.grocerycrud.com/demo/bootstrap_theme";
	private static final String urlTheme_V4 = "https://www.grocerycrud.com/demo/bootstrap_theme_v4";

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage();
		customerPage = new CustomerPage();
		getDriver().get("https://www.grocerycrud.com/demo/bootstrap_theme");
	}

	@Test
	public void accessInitialPage() {
		assertEquals(urlHome, homePage.getActualPage());
	}

	@Test
	public void changeVersionToTheme_V4() {
		homePage.selectVersionTheme_v4();
		assertEquals(urlTheme_V4, homePage.getActualPage());
	}

	@Test
	public void testeLupa() {
		homePage.selectVersionTheme_v4();
		homePage.clickButtonSearch();
		homePage.fillSearch("Teste Sicredi");
		esperar(3000);
	}

	@Test
	public void deleteCustomer() throws InterruptedException {
		customerPage.deleteCustomer("Teste Sicredi", "Teste", "Anderson Mann", "51 9999-9999", "Av Assis Brasil, 3970",
				"Torre D", "Porto Alegre", "RS", "91000-000", "BRASIL", "200", "Teste Sicredi");

		System.out.println(homePage.pegaTexto());
		assertEquals("Are you sure that you want to delete this record?", homePage.pegaTexto());

		esperar(2000);
		
		System.out.println(homePage.pegaTextoUltimaMSG());
		esperar(2000);

		assertEquals("Your data has been successfully deleted from the database.", homePage.pegaTextoUltimaMSG());

	}

}