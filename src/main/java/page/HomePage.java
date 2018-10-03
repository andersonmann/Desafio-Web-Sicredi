package page;

import core.BasePage;

public class HomePage extends BasePage{
	
	
	/** Esse metodo retorna o URL da pagina atual. */

	public String paginaAtual() {
		return dsl.retornaPaginaAtual();
	}

}
