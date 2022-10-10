package pages;

import core.element.Button;
import core.element.TextBox;

public class LoginPage {

    private final TextBox txtUsername = new TextBox("//input[@formcontrolname='email']");
    private final TextBox txtPassword = new TextBox("//input[@formcontrolname='password']");
    private final Button  btnLogin    = new Button("//button[@type='submit']");

    public void login(String username, String password) {
        this.txtUsername.sendKeys(username);
        this.txtPassword.sendKeys(password);
        this.btnLogin.click();
    }
}
