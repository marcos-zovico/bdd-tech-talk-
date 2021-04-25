package com.msouza.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class InserirContasSteps {

    private WebDriver driver = new ChromeDriver();

    @Dado("que estou acessando a aplicação")
    public void que_estou_acessando_a_aplicação() {
        driver.get("https://seubarriga.wcaquino.me/");
        sleep();
    }

    @Quando("informo o usuário {string}")
    public void informo_o_usuário(String user) {
        driver.findElement(By.id("email")).sendKeys(user);
        sleep();
    }

    @Quando("a senha {string}")
    public void a_senha(String pass) {
        driver.findElement(By.name("senha")).sendKeys(pass);
        sleep();
    }

    @Quando("seleciono entrar")
    public void seleciono_entrar() {
        driver.findElement(By.tagName("button")).click();
        sleep();
    }

    @Então("visualizo a página inicial")
    public void visualizo_a_pagina_inicial() {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertTrue(texto.contains("Bem vindo"));
        sleep();
    }

    @Quando("seleciono Contas")
    public void seleciono_contas() {
        driver.findElement(By.linkText("Contas")).click();
        sleep();
    }

    @Quando("seleciono Adicionar")
    public void seleciono_adicionar() {
        driver.findElement(By.linkText("Adicionar")).click();
        sleep();
    }

    @Quando("informo a conta {string}")
    public void informo_a_conta(String nome) {
        if ("Nova Conta de Teste".equalsIgnoreCase(nome)) {
            nome = nome.concat(RandomString.make(10));
        }
        driver.findElement(By.name("nome")).sendKeys(nome);
        sleep();
    }

    @Quando("seleciono Salvar")
    public void seleciono_salvar() {
        driver.findElement(By.tagName("button")).click();
        sleep();
    }

    @Então("a conta é inserida com sucesso")
    public void a_conta_é_inserida_com_sucesso() {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Conta adicionada com sucesso!", texto);
        sleep();
    }

    @Então("sou notificado que o nome da conta é obrigatório")
    public void sou_notificar_que_o_nome_da_conta_e_obrigatorio() {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        Assert.assertEquals("Informe o nome da conta", texto);
        sleep();
    }

    @Então("sou notificado que já existe uma conta com esse nome")
    public void sou_notificado_que_ja_existe_uma_conta_com_esse_nome() {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        Assert.assertEquals("Já existe uma conta com esse nome!", texto);
        sleep();
    }

    @After
    public void finish(Scenario scenario) {
		screenshot(scenario);
		driver.quit();
    }

    public void sleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void screenshot(Scenario scenario) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("build/cucumber/screenshot/" + scenario.getName()+ ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
