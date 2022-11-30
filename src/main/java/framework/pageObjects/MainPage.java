package framework.pageObjects;


import framework.elements.Button;
import framework.elements.Form;
import framework.elements.TextBox;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
    private static final Form FORM = new Form(By.id("root"), "MainPage");
    private static final TextBox UNIQUE_ELEMENT = new TextBox(By.id("user-name"), "Unique element of Main page");
    private static final TextBox LOGIN_FIELD = new TextBox(By.id("user-name"), "Login field");
    private static final TextBox PASSWORD_FIELD = new TextBox(By.id("password"), "Password field");
    private static final Button LOGIN_BUTTON = new Button(By.id("login-button"), "Login button");
    public MainPage() {
        super(FORM, "MainPage");
    }

    public boolean isMainPageOpen() {
        return UNIQUE_ELEMENT.isElementOnPage();
    }

    public void inputLogin(String login){
        LOGIN_FIELD.sendText(login);
    }

    public void inputPassword(String password){
        PASSWORD_FIELD.sendText(password);
    }

    public void clickLoginButton(){
        LOGIN_BUTTON.click();
    }
}
