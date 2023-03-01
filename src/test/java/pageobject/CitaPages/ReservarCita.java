package pageobject.CitaPages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.eclipse.jetty.http.HttpTokens;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ReservarCita extends PageObject {

    @FindBy(xpath = "//select[@id='combo_facility']")
    public WebElementFacade selInstlacion;
    @FindBy(xpath = "//input[@id='chk_hospotal_readmission']")
    public WebElementFacade checkReadmission;
    @FindBy(xpath = "//input[@value='Medicare']")
    public WebElementFacade radButtonSeguroMedico;
    @FindBy(xpath = "//input[@value='Medicare']")
    public WebElementFacade radButtonSeguroEnfermedad;
    @FindBy(xpath = "//input[@value='Medicare']")
    public WebElementFacade radButtonNinguno;

    public void seleccionInstalacion(String valor) {
        Select sede = new Select(selInstlacion);
        sede.selectByValue(valor);
    }

    public void checkReadmision() {
        checkReadmission.click();
    }

    public void buttonPrograma(String programa) {
        switch (programa) {
            case "Seguro médico del estado":
                radButtonSeguroMedico.click();
                break;
            case "Seguro de enfermedad":
                radButtonSeguroEnfermedad.click();
                break;
            case "Ninguno":
                radButtonNinguno.click();
                break;
            default:
                System.out.println("error de programa");
        }

    }

}
