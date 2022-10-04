package Tests;

import org.junit.Test;

import Pages.LoginPage;

public class LoginTest extends BaseTest{
    
    public LoginPage loginPage;
    String email = "marija.krivokapic.105@gmail.com";
    String LoginText = "My account";
    String emptyEmail = "";
    String emptyEmailError = "An email adress required";
    String password = "Test0510";
    String passwordError = "kuca";
    String wrongPasswordError = "Authentication failed";
    String LogoutText = "Logout authentication";

    @Test
    public void verifySuccessfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email,password);
        loginPage.verifySuccessfulLogin(LoginText);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifyUnsuccessfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login (emptyEmail, passwordError);
        loginPage.verifyWrongPasswordLogin(wrongPasswordError);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifyUnsccessfulEmptyMailLogin(){
        loginPage = new LoginPage(driver);
        loginPage.loginPage ();
        loginPage.login(emptyEmail, password);
        loginPage.verifyEmptyMailLogin(emptyEmailError);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifyUnsccessfulWrongPasswordLogin (){
        loginPage = new LoginPage(driver);
        loginPage.login(email, wrongPasswordError);
        loginPage.verifyWrongPasswordLogin(wrongPasswordError);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifySuccessfulLogout (){
        loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        loginPage.verifySuccessfulLogout(LogoutText);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

