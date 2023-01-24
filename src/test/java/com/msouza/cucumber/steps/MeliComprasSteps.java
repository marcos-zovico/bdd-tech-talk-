package com.msouza.cucumber.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MeliComprasSteps {

    private WebDriver driver = new ChromeDriver();

    @Dado("que estou acessando o marketplace")
    public void que_estou_acessando_o_marketplace() {
        driver.get("https://www.mercadolivre.com.br/");
    }

    @Quando("faço o login")
    public void faco_o_login(String pass) {
        driver.findElement(By.ByCssSelector.cssSelector("a[data-link-id='login']")).click();
    }
}
