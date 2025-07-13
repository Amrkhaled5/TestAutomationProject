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

        int randomNum = random.nextInt(100000); // generates a number from 0 to 99999
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
        Assert.assertTrue(loginPage.isAccountAleadyExistMessageDisplayed(), "Message did not shown for existing email.");
    }

    @Test(priority = 3, description = "Register using an already registered email")

}
