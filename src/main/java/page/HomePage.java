package page;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import core.BasePage;

public class HomePage extends BasePage {

	/** Esse metodo retorna o URL da pagina atual. */

	public String paginaAtual() {
		return dsl.retornaPaginaAtual();
	}

	public void selectVersionTheme_v4() {
		dsl.selecionarCombo(By.className("switch-version"), "bootstrap_theme_v4");
	}

	public void addCustomer(String name, String lastName, String contactName, String phone, String address1,
			String address2, String city, String state, String postalCode, String country, String creditLimit) {

		dsl.click(By.cssSelector("#gcrud-search-form > div.header-tools > div.floatL.t5 > a"));
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
		dsl.click(By.id("field_salesRepEmployeeNumber_chosen"));
		dsl.click(By.cssSelector("#field_salesRepEmployeeNumber_chosen > div > ul > li:nth-child(8)"));
		dsl.click(By.id("form-button-save"));

	}

	public String getText() {
		
		//return dsl.getText(By.xpath("//*[@id=\"report-success\"]/p/text()[1]")); // NAO ENCONTRADO
		//return dsl.getText(By.id("report-success"));
		//return dsl.getText(By.cssSelector("#report-success")); 
			
		
		//return dsl.getText(By.xpath("//*[@id=\"report-success\"]/p/text()[1]"));		
		
		
		return dsl.getText(By.xpath("//*[@id=\"report-success\"]/p")); 	//quase		
		
		//return dsl.getText(By.tagName("p")); 								//quase					
		
		//return dsl.getText(By.cssSelector("#report-success > p"));  		// quase
		
		
	}
	
	
	
	
	
	
	
}
