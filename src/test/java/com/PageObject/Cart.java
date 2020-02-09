package com.PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart extends BasePage {
    private By openByCataloq= By.xpath("//*.[href='category.html']");

    public Cart(WebDriver driver) {
        super(driver);
    }


    @Step("Open 'Cataloque'")
    public BasePage openCataloque() {
        WebElement catalogBtn = driver.findElement(openByCataloq);
        catalogBtn.click();
        return new BasePage(driver);
    }


}
