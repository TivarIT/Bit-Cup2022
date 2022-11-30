package test;

import framework.pageObjects.MainPage;

public class AuthorizationSteps {
    private static final MainPage mainPage = new MainPage();

    public void authorizationStep(String login, String password){
        mainPage.inputLogin(login);
        mainPage.inputPassword(password);
        mainPage.clickLoginButton();
    }
}
