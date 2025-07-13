package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    //Locators for create Account
    private By newEmailInput=By.id("email_create");
    private By createAccountButton=By.id("SubmitCreate");
    private By accountAlreadyRegisterdMsg=By.id("create_account_error");

    //Locators for login
    private By emailLoginInput =By.id("email");
    private By passwordLoginInput =By.id("passwd");
    private By signInButton =By.id("SubmitLogin");

    //access locators for new Account
    public void creatAccountWithNewEmail(String email){
        driver.findElement(newEmailInput).sendKeys(email);
    }
    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }
    public boolean isAccountAleadyExistMessageDisplayed(){
        return driver.findElement(accountAlreadyRegisterdMsg).isDisplayed();
    }

    //access locators for login
    public void login(String email, String password) {
        driver.findElement(emailLoginInput).sendKeys(email);
        driver.findElement(passwordLoginInput).sendKeys(password);
        driver.findElement(signInButton).click();
    }
}
