/**
 * 
 */
package core;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

/**
 * @author anderson.mann
 *
 */
@Listeners({ ScreenshotUtility.class })
public class BaseTest {

	@AfterClass
	public static void finalizaClasse() {
		DriverFactory.killDriver();
	}

	public void esperar(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}