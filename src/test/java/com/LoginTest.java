package com;

import com.PageObject.BasePage;
import com.PageObject.Login;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends TestBase {
     User user;
     BasePage basePage;
     Login login;
     private By successLoggedIn= By.xpath("//a[text()='Logged in as  ']");



    @BeforeClass
    @Step("Open 'Add new owner' page")
    public void beforeClass() {
        user = new User();
        basePage = new BasePage(driver);
        login = new Login(driver);

    }

    @Test
    public void Login() {
        login.openBasePage();
        login.clickLoginBtn();
        login.setUserName("Test User");
        login.setPassword("123456");
        login.confirmLogin();

    }
}
