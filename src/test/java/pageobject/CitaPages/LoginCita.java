package pageobject.CitaPages;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginCita extends PageObject {

    @FindBy(xpath = "//input[@id='txt-username']")
    private WebElementFacade lblUsername;

    @FindBy(xpath = "//input[@id='txt-password']")
    private WebElementFacade lblPassword;

    @FindBy(xpath = "//button[@id='btn-login']")
    private WebElementFacade btnLogin;


    public void inicioSesion(String username, String password){
        lblUsername.sendKeys(username);
        lblPassword.sendKeys(password);
        btnLogin.click();

    }

}
