package pageobject;

import actions.SelectOptions;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.apache.xalan.trace.SelectionEvent;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Checkout extends PageObject {

    public static Double subTotalConfirm;
    public static Double flatConfirm;
    public static Double totalaConfirm;

    //Billing Details
    @FindBy(id = "input-payment-firstname")
    public WebElementFacade firstNameTxt;
    @FindBy(id = "input-payment-lastname")
    public WebElementFacade lastNameTxt;
    @FindBy(id = "input-payment-email")
    public WebElementFacade emailTxt;
    @FindBy(id = "input-payment-telephone")
    public WebElementFacade phoneTxt;
    @FindBy(id = "input-payment-company")
    public WebElementFacade companyTxt;
    @FindBy(id = "input-payment-address-1")
    public WebElementFacade addressTxt;
    @FindBy(id = "input-payment-city")
    public WebElementFacade cityTxt;
    @FindBy(id = "input-payment-postcode")
    public WebElementFacade codeTxt;
    @FindBy(id = "input-payment-country")
    public WebElementFacade countryTxt;
    @FindBy(id = "input-payment-zone")
    public WebElementFacade stateTxt;
    @FindBy(id = "button-guest")
    public WebElementFacade btnBillingDetails;

    //Delivery Method
    @FindBy(xpath = "//textarea[@name='comment']")
    public WebElementFacade descriptionTxt;
    @FindBy(id = "button-shipping-method")
    public WebElementFacade btnDeliveryMethod;

    //Payment Method
    @FindBy(xpath = "//div[@class='radio']/label")
    public List<WebElementFacade> listMethodPay;
    @FindBy(xpath = "//input[@name='agree']")
    public WebElementFacade termAndConditions;
    @FindBy(id = "button-payment-method")
    public WebElementFacade btnPaymentMethod;

    //Confirm Order
    @FindBy(xpath = "//table[@class='table table-bordered table-hover']/tfoot/tr[1]/td[2]")
    public WebElementFacade subTotal;
    @FindBy(xpath = "//table[@class='table table-bordered table-hover']/tfoot/tr[2]/td[2]")
    public WebElementFacade flat;
    @FindBy(xpath = "//table[@class='table table-bordered table-hover']/tfoot/tr[3]/td[2]")
    public WebElementFacade total;
    @FindBy(id = "button-confirm")
    public WebElementFacade btnConfirmOrder;
    @FindBy(xpath = "//h1[text()='Your order has been placed!']")
    public WebElementFacade textOrderConfirm;

    public void billingDetails(String name, String lastName, String email, String phone, String address, String city) {
        element(firstNameTxt).waitUntilVisible();
        firstNameTxt.type(name);
        lastNameTxt.type(lastName);
        emailTxt.type(email);
        phoneTxt.type(phone);
        companyTxt.type("ZUM");
        addressTxt.type(address);
        cityTxt.type(city);
        codeTxt.type("15047");
        Select elementCountry = new Select(countryTxt);
        elementCountry.selectByVisibleText("Peru");
        Select elementState = new Select(stateTxt);
        elementState.selectByVisibleText("Lima");
        JavascriptExecutor js= (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();",btnBillingDetails);
    }

    public void deliveryMethod(String description) {
        descriptionTxt.type(description);
        btnDeliveryMethod.click();
    }

    public void paymentMethod(String methodPay) {
        SelectOptions.in(listMethodPay, methodPay);
        termAndConditions.click();
        btnPaymentMethod.click();
    }

    public void validateOrder() {
        subTotalConfirm = Double.parseDouble(subTotal.getText().replace("$", ""));
        flatConfirm = Double.parseDouble(flat.getText().replace("$", ""));
        totalaConfirm = Double.parseDouble(total.getText().replace("$", ""));
        String sbtMasflat = String.valueOf(subTotalConfirm + flatConfirm);
        String totalOrder = String.valueOf(totalaConfirm);
        Assert.assertEquals(sbtMasflat, totalOrder);
        btnConfirmOrder.click();
        textOrderConfirm.withTimeoutOf(Duration.ofSeconds(20)).isEnabled();
        Assert.assertEquals(textOrderConfirm.getText(), "Your order has been placed!");
    }
}

