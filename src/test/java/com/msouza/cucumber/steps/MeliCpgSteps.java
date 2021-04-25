package com.msouza.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MeliCpgSteps {

	private WebDriver driver = new ChromeDriver();

	@Dado("que estou acessando a aplicação não logado")
	public void que_estou_acessando_a_aplicacao() {
		driver.get("https://www.mercadolivre.com.br/");
	}

	@Quando("faço uma busca por {string}")
	public void informo_o_usuário(String search) {
		driver.findElement(By.name("as_word")).sendKeys(search);
		driver.findElement(By.className("nav-search-btn")).click();
	}

	@Então("visualizo o componente de intervenção com titulo {string} e link {string} para home de super")
	public void visualizo_o_componente_de_intervencao_com_titulo_e_link_para_home_de_super(String title, String link) {
		String titleText = driver.findElement(By.xpath("//p[@class='ui-search-carousel__item-generic-main__title']")).getText();
		String linkText = driver.findElement(By.xpath("//p[@class='ui-search-carousel__item-generic-main__link']")).getText();
		Assert.assertEquals(title, titleText);
		Assert.assertEquals(link, linkText);
	}

	@After
	public void finish() {
		driver.quit();
	}

	@BeforeStep
	public void beforeStep() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(1000);
	}

}
