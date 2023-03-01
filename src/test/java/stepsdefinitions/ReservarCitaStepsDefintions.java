package stepsdefinitions;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import pageobject.CitaPages.HomeCita;
import pageobject.CitaPages.LoginCita;
import pageobject.CitaPages.ReservarCita;
import pageobject.CitaPages.ValidarCita;


public class ReservarCitaStepsDefintions {

    @Steps
    HomeCita homeCita;
    @Steps
    LoginCita loginCita;
    @Steps
    ReservarCita reservarCita;
    @Steps
    ValidarCita validarCita;


    @Given("que el usuario ingresa a la web cita")
    public void queElUsuarioIngresaALaWebCita() {
        homeCita.open();
        homeCita.botonMakeAppointment();
    }


}
