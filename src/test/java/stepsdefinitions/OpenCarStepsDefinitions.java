package stepsdefinitions;

import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import pageobject.CarritoCompras;
import pageobject.Checkout;
import pageobject.Home;

public class OpenCarStepsDefinitions {
    @Steps
    Home home;

    @Steps
    CarritoCompras cart;

    @Steps
    Checkout checkout;

    @Given("^que el usuario ingresa a la web ecommerce$")
    public void queElUsuarioIngresaALaWebEcommerce() {
        home.open();
    }

    @When("^busca el producto (.*) y agrego al carrito$")
    public void buscaElProductoYAgregoAlCarrito(String product) {
        home.searchProduct(product);
        home.addToCartProduct();
    }

    @And("^se dirige a realizar la compra como (.*)$")
    public void seDirigeARealizarLaCompraComoOptionCustomer(String customer) {
        cart.goToCheckout(customer);
    }

    @And("^ingresa sus datos (.*), (.*), (.*), (.*) y de envio de producto (.*), (.*)")
    public void ingresaSusDatosNombreApellidoEmailTelefonoYDeEnvioDeProductoDireccionCiudad(String name, String lastName, String email, String phone, String address, String city) {
        checkout.billingDetails(name, lastName, email, phone, address, city);
    }

    @And("^ingresa un metodo de delivery (.*)$")
    public void ingresaUnMetodoDeDeliveryDescripcion(String description) {
        checkout.deliveryMethod(description);
    }

    @And("^selecciona el metodo de pago (.*)$")
    public void seleccionaElMetodoDePagoMetodoPago(String methodPay) {
        checkout.paymentMethod(methodPay);
    }

    @Then("^verifica y confirma la orden de compra$")
    public void verificaYConfirmaLaOrdenDeCompra() {
        checkout.validateOrder();
    }


}
