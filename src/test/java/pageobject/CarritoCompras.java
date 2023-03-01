package pageobject;

import actions.SelectOptions;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarritoCompras extends PageObject {

    @FindBy(xpath = "//strong[contains(text(),'Checkout')]")
    public WebElementFacade linkCheckout;
    @FindBy(xpath = "//div[@class='radio']")
    public WebElementFacade BlockCustomer;
    @FindBy(xpath = "//div[@class='radio']/label")
    public List<WebElementFacade> listCustomer;
    @FindBy(id = "button-account")
    public WebElementFacade buttonAccount;

    public void goToCheckout(String customer) {
        linkCheckout.click();
        element(BlockCustomer).waitUntilVisible();
        SelectOptions.in(listCustomer, customer);
        buttonAccount.click();
    }
}

