package com.PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static final String BASE_URL = "http://167.172.110.35/";

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    protected WebDriverWait waitFor() {
        return new WebDriverWait(driver, 2);
    }

    @Step("Open page {title}")
    protected void goToUrl(String url, String title) {
        driver.get(BASE_URL + url);
        waitFor().withMessage(title + " page is not open!")
                .until(ExpectedConditions.textToBe(By.xpath("//h2"), title));
    }

    @Step("Wait until element {elementName} isn't clickable")
    protected WebElement waitUntilClickable(String elementName, By elementPath) {
        waitFor().withMessage(elementName + " not clickable")
                .until(ExpectedConditions.elementToBeClickable(elementPath));
        return driver.findElement(elementPath);
    }

    @Step("Wait until element {elementName} isn't displayed")
    protected WebElement waitUntilElementVisible(String elementName, By elementPath) {
        waitFor().withMessage(elementName + " isn't enabled")
                .until(ExpectedConditions.visibilityOf(driver.findElement(elementPath)));

        return driver.findElement(elementPath);
    }
}
