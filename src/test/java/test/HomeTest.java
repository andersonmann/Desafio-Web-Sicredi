package test;

import static core.DriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.BaseTest;
import page.HomePage;

public class HomeTest extends BaseTest {
	private HomePage homePage;

	private static final String urlHome = Messages.getString("HomeTest.0");
	private static final String urlTheme_V4 = Messages.getString("HomeTest.1");

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage();
		getDriver().get(Messages.getString("HomeTest.2"));
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
}