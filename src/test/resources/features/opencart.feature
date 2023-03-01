Feature: Funcionalidad Checkout Open Cart
  Rule: Yo como usuario quiero realizar una compra de un producto de open cart
  de manera exitosa y con todos mis datos correctamente

    Background: Ingresar a la web
      Given que el usuario ingresa a la web ecommerce

    @regresion-success
    Scenario Outline: Validar que la orden de un producto fue exitosa
      When busca el producto <producto> y agrego al carrito
      And se dirige a realizar la compra como <optionCustomer>
      And ingresa sus datos <nombre>, <apellido>, <email>, <telefono> y de envio de producto <direccion>, <ciudad>
      And ingresa un metodo de delivery <descripcion>
      And selecciona el metodo de pago <metodoPago>
      Then verifica y confirma la orden de compra
      Examples:
        | producto | optionCustomer   | nombre | apellido | email            | telefono  | direccion      | ciudad    | descripcion   | metodoPago       |
        | iPhone   | Guest Checkout   | Erick  | Montes   | montes@gmail.com | 969929157 | Jiron Salavery | Surquillo | Enviar rápido | Cash On Delivery |
#        | iPhone   | Register Account | Pablo  | Montes   | montes@gmail.com | 969929157 | Jiron Salavery | Surquillo | Enviar rápido | Cash On Delivery |

