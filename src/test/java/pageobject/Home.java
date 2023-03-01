package pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class Home extends PageObject {

    public static Double priceProductList;
    public static Double subTotalCart;

    ////input[contains(@name,'search')]
    @FindBy(xpath = "//input[@name='search']")
    public WebElementFacade boxSearch;
    @FindBy(xpath = "//button[contains(@class,'btn btn-default btn-lg')]")
    public WebElementFacade btnSearch;
    @FindBy(xpath = "//p[@class='price']/span")
    public WebElementFacade price;
    @FindBy(xpath = "//div[@class='button-group']/button[1]")
    public WebElementFacade btnAddCart;
    @FindBy(xpath = "//div[@id='cart']/button")
    public WebElementFacade cartShop;
    @FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[1]/td[2]")
    public WebElementFacade subTotal;

    public void searchProduct(String product) {
        boxSearch.type(product);
        // enter(product).into(boxSearch);
        // boxSearch.sendKeys(product);
        //text
        btnSearch.click();
    }

    public void addToCartProduct() {
        priceProductList = Double.parseDouble(price.getText().replace("Ex Tax: $", ""));
        btnAddCart.click();
        //cartShop.withTimeoutOf(Duration.ofSeconds(20)).isEnabled();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", cartShop.waitUntilEnabled());
        subTotalCart = Double.parseDouble(subTotal.getText().replace("$", ""));
        Assert.assertTrue("Validar ambos valores", priceProductList.equals(subTotalCart));
    }


}
