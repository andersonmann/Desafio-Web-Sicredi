package test;

import static core.DriverFactory.getDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.BaseTest;
import page.HomePage;

public class HomeTest extends BaseTest {
	private HomePage homePage;
	private static final String urlHome = "https://www.grocerycrud.com/demo/bootstrap_theme";

	@BeforeMethod
	public void beforeMethod() {
		getDriver().get("https://www.grocerycrud.com/demo/bootstrap_theme");
		homePage = new HomePage();
	}

	@Test
	public void acessarPaginaInicial() {
		// homePage.selecionarQueroMeCredenciar();
		Assert.assertEquals(urlHome, homePage.paginaAtual());
	}

	@Test
	public void acessaJaInicieiCredenciamento() {
		// homePage.selecionarJaInicieiCredenciamento();
		Assert.assertEquals(urlHome, homePage.paginaAtual());
	}

}