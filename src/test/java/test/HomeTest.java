package test;

import static core.DriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.BaseTest;
import page.HomePage;

public class HomeTest extends BaseTest {
	private HomePage homePage;
	private static final String urlHome = "https://www.grocerycrud.com/demo/bootstrap_theme";
	private static final String urlTheme_V4 = "https://www.grocerycrud.com/demo/bootstrap_theme_v4";

	@BeforeMethod
	public void beforeMethod() {
		getDriver().get("https://www.grocerycrud.com/demo/bootstrap_theme");
		homePage = new HomePage();
	}

	@Test
	public void acessarPaginaInicial() {
		Assert.assertEquals(urlHome, homePage.paginaAtual());
	}

	@Test
	public void alterarVersaoParaTheme_V4() {
		homePage.selectVersionTheme_v4();
		Assert.assertEquals(urlTheme_V4, homePage.paginaAtual());
	}

	@Test
	public void addCustomer() throws InterruptedException {
		homePage.selectVersionTheme_v4();
		homePage.addCustomer("Anderosn", "Mann", "morais", "051-99886677", "", "5th Ave", "New York", "NY", "94510344",
				"USA", "15000");

		esperar(2000);

		assertEquals(homePage.getText(),
				"Your data has been successfully stored into the database. Edit Customer or Go back to list");
	}

}