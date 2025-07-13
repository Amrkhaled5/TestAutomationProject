package tests;

import Pages.AccountCreationPage;
import Pages.HomePage;
import Pages.LoginPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

public class RegisterTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountCreationPage accountPage;

    private final String pass="asdfg";
    private String email;
    Random random=new Random();

    @BeforeClass
    public void callClasses(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountCreationPage(driver);

        int randomNum = random.nextInt(100000);
        email = "amr_" + randomNum + "@mail.com";

    }

    @Test(priority = 1, description = "Register a new user with valid Data Then Verify account creation success and logout Then Login")
    public void testRegisterNewUser(){
        homePage.goToHomepage();
        homePage.clickSignIn();

        loginPage.creatAccountWithNewEmail(email);
        loginPage.clickCreateAccount();

        accountPage.selectTitle("Mr");
        accountPage.enterFirstName("Amr");
        accountPage.enterLastName("Khaled");
        accountPage.enterPassword(pass);
        accountPage.selectDOB("8","8","2000");
        accountPage.subscribeToNewsletter();
        accountPage.clickRegister();

        Assert.assertTrue(accountPage.isAccountCreatedMessageDisplayed(), "Success message not displayed");
        Assert.assertTrue(accountPage.isSignoutVisible(), "Logout link not visible");
        accountPage.clickLogout();

        loginPage.login(email, pass);
        Assert.assertTrue(accountPage.isSignoutVisible(), "Login failed with registered credentials");
    }

    @Test(priority = 2, description = "Register using an already registered email")
    public void testVerifySuccessAndLogout() {
        homePage.clickSignOut();
        loginPage.creatAccountWithNewEmail(email);
        loginPage.clickCreateAccount();
        //need to wait in isErrorMessageDisplayed function
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Expected error message for existing email was not displayed.");
    }

    @Test(priority = 3, description = "Registration with invalid email format")
    public void testRegisterWithInvalidEmailFormat() {
        homePage.goToHomepage();
        homePage.clickSignIn();
        loginPage.creatAccountWithNewEmail("email@");
        loginPage.clickCreateAccount();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid email");
    }

    @Test(priority = 4, description = "Registration with empty email")
    public void testRegisterWithEmptyEmail() {
        homePage.goToHomepage();
        homePage.clickSignIn();
        loginPage.creatAccountWithNewEmail("");
        loginPage.clickCreateAccount();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid email");
    }

    @Test(priority = 5, description = "Registration without put in all requird fields")
    public void testAccountCreationWithMissingFields() {
        int randomNum = random.nextInt(100000);
        email = "amr_" + randomNum + "@ml.com";

        homePage.goToHomepage();
        homePage.clickSignIn();

        loginPage.creatAccountWithNewEmail(email);
        loginPage.clickCreateAccount();

        accountPage.selectTitle("Mrs");
        accountPage.enterFirstName("");
        accountPage.enterLastName("");
        accountPage.enterPassword(pass);
        accountPage.selectDOB("","","");
        accountPage.subscribeToNewsletter();
        accountPage.clickRegister();

        Assert.assertTrue(accountPage.isValidationErrorApper(),
                "Validation error should be displayed for weak password");
    }

    @Test(priority = 6, description = "Registration with weak password")
    public void testRegisterWithWeakPassword() {
        int randomNum = random.nextInt(100000);
        email = "amr_" + randomNum + "@mrl.com";

        homePage.goToHomepage();
        homePage.clickSignIn();

        loginPage.creatAccountWithNewEmail(email);
        loginPage.clickCreateAccount();

        accountPage.selectTitle("Mr");
        accountPage.enterFirstName("Amr");
        accountPage.enterLastName("Khaled");
        accountPage.enterPassword("123");
        accountPage.selectDOB("3","3","2003");
        accountPage.subscribeToNewsletter();
        accountPage.clickRegister();

        Assert.assertTrue(accountPage.isValidationErrorApper(),
                "Validation error should be displayed for weak password");
    }

    @Test(priority = 7, description = "Registration with invalid Data")
    public void testRegisterWithInvalidData() {
        homePage.goToHomepage();
        homePage.clickSignIn();
        loginPage.creatAccountWithNewEmail("");
        loginPage.clickCreateAccount();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid email");
    }

}
