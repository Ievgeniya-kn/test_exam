package com.PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends BasePage {
    private By loginButton = By.id("login");
    private By LoginPopup = By.xpath("//*[@class='text-center']");
    private By userNameByField = By.id("username-modal");
    private By passwordByField = By.id("password-modal");
    private By loginEnteredByPopup = By.xpath("//*[@class='btn btn-primary']");

    private By successLoggedIn= By.xpath("//a[text()='Logged in as  ']");

    public Login(WebDriver driver) {
        super(driver);
    }

    @Step("Open page")
    public void openBasePage() {
        goToUrl("","HOT THIS WEEK");
    }

    @Step("Press link 'Login'")
    public void clickLoginBtn() {
        WebElement loginBtn = waitUntilElementVisible("Login",loginButton);
        waitUntilClickable("Login", loginButton);
        loginBtn.click();
    }

    @Step("Set field='User Name'")
    public void setUserName(String username) {
        WebElement name = driver.findElement(userNameByField);
        name.clear();
        name.sendKeys(username);
    }

    @Step("Set field='Password'")
    public void setPassword(String password) {
        WebElement passwordField = driver.findElement(passwordByField);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @Step("Press button 'Login'")
    public BasePage confirmLogin() {
        WebElement loginBtn = driver.findElement(loginEnteredByPopup);

        loginBtn.click();

        WebElement successLogin = waitUntilElementVisible("Logged in as",successLoggedIn);
        return new BasePage(driver);
    }
}
