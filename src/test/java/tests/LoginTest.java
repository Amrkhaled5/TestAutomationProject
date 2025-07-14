package tests;

import Pages.AccountCreationPage;
import Pages.HomePage;
import Pages.LoginPage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class LoginTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;


    @BeforeClass
    public void callClasses(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }
    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        return new Object[][]{
            {"", "", "An email address required"},
            {"invalid@email.com", "asdasd", "Authentication failed"},
            {"", "asd123", "An email address required"},
            {"test@test.com", "", "Password is required"},
            {"email", "password", "Invalid email address"},
            {"email@", "password", "Invalid email address"},
            {"email@domain", "password", "Invalid email address"},
            {"email@domain.", "password", "Invalid email address"},
            {"email@domain.com", "12", "Authentication failed"},
            {"email@domain.com", "    ", "Authentication failed"},
        };
    }
    @Test(dataProvider = "loginData", description = "Invalid login test cases")
    public void testLoginInvalidData(String email, String password, String expectedErrorMsg) {

        homePage.goToHomepage();
        homePage.clickSignIn();
        loginPage.login(email, password);

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid email");
        Assert.assertTrue(loginPage.isErrorMessageDisplayedCorrectError(expectedErrorMsg),"Error message do not reflect to the corret error");
    }
}
