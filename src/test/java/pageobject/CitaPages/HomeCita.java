package pageobject.CitaPages;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class HomeCita extends PageObject {

    @FindBy(xpath = "//a[@id='btn-make-appointment']")
    private WebElementFacade BtnMakeAppointment;


    public void botonMakeAppointment(){
        BtnMakeAppointment.click();
    }

}
