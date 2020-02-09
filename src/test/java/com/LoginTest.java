package com;

import com.API.Register;
import com.API.User;
import com.PageObject.BasePage;
import com.PageObject.Cart;
import com.PageObject.Login;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends TestBase {
    User user;
    BasePage basePage;
    Login login;
    Cart cart;
    private By successLoggedIn = By.xpath("//a[text()='Logged in as  ']");


    @BeforeClass
    @Step("Before Class")
    public void beforeClass() {
        user = new User();
        basePage = new BasePage(driver);
        login = new Login(driver);
        Register register = new Register();
        register.postNewSpeciality();

    }

    @Test
    @Step("Logged in")
    public void Login() {
        login.openBasePage();
        login.clickLoginBtn();
        login.setUserName("Test User");
        login.setPassword("123456");
        login.confirmLogin();
    }

    @Test
    @Step("Open Catalogue")
    public void openCataloque() {
        cart = new Cart(driver);
        cart.openCataloque();
    }
}
